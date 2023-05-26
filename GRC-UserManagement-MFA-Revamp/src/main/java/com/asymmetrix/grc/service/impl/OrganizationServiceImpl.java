package com.asymmetrix.grc.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.asymmetrix.grc.common.utils.MapperUtils;
import com.asymmetrix.grc.dto.OrganizationChartDTO;
import com.asymmetrix.grc.dto.OrganizationHierarchyDTO;
import com.asymmetrix.grc.entity.MstOrganization;
import com.asymmetrix.grc.entity.OrgWeightageDTO;
import com.asymmetrix.grc.entity.OrganizationDTO;
import com.asymmetrix.grc.entity.OrganizationHierarchy;
import com.asymmetrix.grc.repository.MstOrganizationRepository;
import com.asymmetrix.grc.repository.OrgWeightageRepository;
import com.asymmetrix.grc.repository.OrganizationHierarchyRepository;
import com.asymmetrix.grc.service.OrganizationService;

@Service
public class OrganizationServiceImpl implements OrganizationService {

	@Resource
	MstOrganizationRepository organizationRepo;
	
	@Resource
	OrganizationHierarchyRepository hierarchyRepo;
	
	@Resource
	OrgWeightageRepository orgWeightageRepo;

	private static final String ACTIVE_FLAG = "Y";
	private static final String VERSION_PREFIX = "V.";

	public List<OrganizationDTO> getAllOrganizationVersions() {
		return MapperUtils.mapToTargetClass(organizationRepo.findByActiveOrderByCreatedDateDesc(ACTIVE_FLAG),
				OrganizationDTO.class);
	}

	public OrganizationDTO createOrganizationVersion(OrganizationDTO organizationDTO) {

		organizationDTO.setVersion(generateNewVersion());
		//organizationDTO.setCreatedBy("Admin");
		organizationDTO.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		organizationDTO.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		MstOrganization mstOrganization = organizationRepo
				.save(MapperUtils.mapToTargetClass(organizationDTO, MstOrganization.class));
		return MapperUtils.mapToTargetClass(mstOrganization, OrganizationDTO.class);		
	}
	
	public List<OrganizationHierarchyDTO> getOrganizatinHierarchy(String version, int level){
		List<OrganizationHierarchyDTO> organizationHierarchyDTOList =  MapperUtils.mapToTargetClass(hierarchyRepo.findByVersionAndLevelAndActive(version, level, ACTIVE_FLAG),
				OrganizationHierarchyDTO.class);
		
		//Populating the parent mapping information
		for (OrganizationHierarchyDTO organizationHierarchyDTO : organizationHierarchyDTOList) {
			if (organizationHierarchyDTO.getLevel() > 1) {
				OrganizationHierarchy parentMapping = hierarchyRepo.findByVersionAndParentIDAndActive(version,
						organizationHierarchyDTO.getParentMapping(), ACTIVE_FLAG);
				if (parentMapping != null) {
					OrganizationHierarchyDTO parentMappingDTO = MapperUtils.mapToTargetClass(parentMapping,
							OrganizationHierarchyDTO.class);
					parentMappingDTO.setRiskChampionEmpInfo(null);
					parentMappingDTO.setBuRiskOwnerEmpInfo(null);
					parentMappingDTO.setParentMapping(null);
					parentMappingDTO.setWeightage(null);
					organizationHierarchyDTO.setParentMappingDTO(parentMappingDTO);
				}
			}
		}
		return organizationHierarchyDTOList;
	}
	
	public List<OrganizationHierarchyDTO> createOrganizationHierarchyLevel(List<OrganizationHierarchyDTO> organizationHierarchyDTOList, String modifiedBy){		
		if(organizationHierarchyDTOList.size() > 0) {
			String version = organizationHierarchyDTOList.get(0).getVersion();
			int level = organizationHierarchyDTOList.get(0).getLevel();
			//If already the same hierarchy is present, make it inactive		
			hierarchyRepo.updateOrganizationHierarchyToInactive(version, level);
			//Updating the last modified date in organization version whenever the hierarchy is changed
			MstOrganization organization = organizationRepo.findByVersion(version);
			organization.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			organization.setModifiedBy(modifiedBy);
			organizationRepo.save(organization);
		}			
		List<OrganizationHierarchy> organizationHierarchyList = MapperUtils.mapToTargetClass(
		        MapperUtils.mapToTargetClass(organizationHierarchyDTOList, OrganizationHierarchyDTO.class), OrganizationHierarchy.class);		
		
		return MapperUtils.mapToTargetClass(hierarchyRepo.saveAll(organizationHierarchyList), OrganizationHierarchyDTO.class);
	}
	
	public List<String> getParentMappingOfVersionAndLevel(String version, int level){		
		return hierarchyRepo.findParentMappingOfVersionAndLevelAndActive(version, level, ACTIVE_FLAG);
	}
	
	public List<OrganizationChartDTO> getOrganizationChart(String version){
		
		List<OrganizationChartDTO> organizationChartList = new ArrayList<OrganizationChartDTO>();
		
		List<OrganizationChartDTO> organizationHierarchyDTOList = MapperUtils.mapToTargetClass(hierarchyRepo.findByVersionAndActive(version, ACTIVE_FLAG),
				OrganizationChartDTO.class);
		
		OrganizationDTO organizationNameDTO = MapperUtils.mapToTargetClass(organizationRepo.findFirstByVersionAndActiveOrderByCreatedDateDescIdDesc(version, ACTIVE_FLAG), OrganizationDTO.class);
		
		OrganizationChartDTO maxLevelInHeirarchyDTO = organizationHierarchyDTOList
			      .stream()
			      .max(Comparator.comparing(OrganizationChartDTO::getLevel))
			      .orElseThrow(NoSuchElementException::new);				
		int maxLevel = maxLevelInHeirarchyDTO.getLevel();		
		
		List<OrganizationChartDTO> filteredLevelZeroList = organizationHierarchyDTOList.stream()
				.filter(a -> a.getLevel() == 1).collect(Collectors.toList());	
		
				
		//L1 Child	
		/**
		 * Too much mappings and attribute value changes has been only done in order to get integrate with angular UI 
		 * Organaization chart component.
		 */
		for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {	
			
			filteredL0List.setName(filteredL0List.getBuHeadEmpInfo());
			filteredL0List.setBuHeadEmpInfo(null);
			
			for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {				
				if(filteredL0List.getParentID().equals(organizationDTO.getParentMapping())){
					//Bu Head Info not required to display chart in the levels more than or equal to 1
					organizationDTO.setBuHeadEmpInfo(null);
					organizationDTO.setName(organizationDTO.getBlUserEmpInfo());	
					organizationDTO.setBlUserEmpInfo(null);
					filteredL0List.addChild(organizationDTO);					
				}					
			}		
		}
		
		if(maxLevel >= 2) {			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {						
						if(child.getParentID().equals(organizationDTO.getParentMapping())){		
							//Bu Head Info not required to display chart in the levels more than or equal to 2
							organizationDTO.setBuHeadEmpInfo(null);		
							organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
							organizationDTO.setBlUserEmpInfo(null);
							child.addChild(organizationDTO);							
						}	
					}					
				}			
			}				
		}
		
		if(maxLevel >= 3) {			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO child1: child.getChild()) {					
						for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {							
							if(child1.getParentID().equals(organizationDTO.getParentMapping())){								
								organizationDTO.setBuHeadEmpInfo(null);
								organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
								organizationDTO.setBlUserEmpInfo(null);
								child1.addChild(organizationDTO);
							}							
						}
					}
				}				
			}				
		}
		
		if(maxLevel >= 4) {
			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO child1: child.getChild()) {						
						for(OrganizationChartDTO child2: child1.getChild()) {					
							for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {								
								if(child2.getParentID().equals(organizationDTO.getParentMapping())){									
									organizationDTO.setBuHeadEmpInfo(null);	
									organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
									organizationDTO.setBlUserEmpInfo(null);
									child2.addChild(organizationDTO);
								}								
							}
						}
					}
				}				
			}				
		}
		
		if(maxLevel >= 5) {			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO child1: child.getChild()) {						
						for(OrganizationChartDTO child2: child1.getChild()) {							
							for(OrganizationChartDTO child3: child2.getChild()) {					
								for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {									
									if(child3.getParentID().equals(organizationDTO.getParentMapping())){										
										organizationDTO.setBuHeadEmpInfo(null);	
										organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
										organizationDTO.setBlUserEmpInfo(null);
										child3.addChild(organizationDTO);
									}									
								}
							}
						}
					}
				}				
			}				
		}
		
		if(maxLevel >= 6) {			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO child1: child.getChild()) {						
						for(OrganizationChartDTO child2: child1.getChild()) {							
							for(OrganizationChartDTO child3: child2.getChild()) {								
								for(OrganizationChartDTO child4: child3.getChild()) {					
									for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {										
										if(child4.getParentID().equals(organizationDTO.getParentMapping())){
											organizationDTO.setBuHeadEmpInfo(null);
											organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
											organizationDTO.setBlUserEmpInfo(null);
											child4.addChild(organizationDTO);
										}										
									}
								}
							}
						}
					}
				}				
			}				
		}
		
		if(maxLevel >= 7) {			
			for(OrganizationChartDTO filteredL0List: filteredLevelZeroList) {			
				for(OrganizationChartDTO child: filteredL0List.getChild()) {					
					for(OrganizationChartDTO child1: child.getChild()) {						
						for(OrganizationChartDTO child2: child1.getChild()) {							
							for(OrganizationChartDTO child3: child2.getChild()) {								
								for(OrganizationChartDTO child4: child3.getChild()) {									
									for(OrganizationChartDTO child5: child4.getChild()) {					
										for(OrganizationChartDTO organizationDTO: organizationHierarchyDTOList) {											
											if(child5.getParentID().equals(organizationDTO.getParentMapping())){
												organizationDTO.setBuHeadEmpInfo(null);	
												organizationDTO.setName(organizationDTO.getBlUserEmpInfo());
												organizationDTO.setBlUserEmpInfo(null);
												child5.addChild(organizationDTO);
											}											
										}
									}
								}
							}
						}
					}
				}				
			}				
		}	
		
		//Board Of Directors
		OrganizationChartDTO boardOfDirectors = new OrganizationChartDTO();		
		List<OrganizationChartDTO> boardOfDirectorsList = organizationHierarchyDTOList.stream()
				.filter(a -> a.getLevel() == 0).collect(Collectors.toList());		
		String boardOfDirectorsStr = "";		
		for(OrganizationChartDTO director: boardOfDirectorsList) {
			if(boardOfDirectorsStr.isEmpty())  
				boardOfDirectorsStr = director.getTopLevelEmpInfo().getEmployeeName();
			else
				boardOfDirectorsStr = boardOfDirectorsStr+", "+director.getTopLevelEmpInfo().getEmployeeName();
		}		
		boardOfDirectors.setNameStr(boardOfDirectorsStr);		
		boardOfDirectors.setChild(filteredLevelZeroList);		
				
		//Organization Name
		OrganizationChartDTO organization = new OrganizationChartDTO();
		organization.setNameStr(organizationNameDTO.getOrganizationName());
		organization.addChild(boardOfDirectors);		
		
		
		organizationChartList.add(organization);
		return organizationChartList;
	}
	
	public OrganizationHierarchyDTO getOrganizationParentInformation(String parentID, String version) {
		OrganizationHierarchyDTO organizationHierarchyDTO = MapperUtils.mapToTargetClass(hierarchyRepo.findByVersionAndParentIDAndActive(parentID, version, ACTIVE_FLAG),
				OrganizationHierarchyDTO.class);
		//Remove parent mapping information of the parent from the entity which is not required.
		organizationHierarchyDTO.setParentMapping(null);		
		organizationHierarchyDTO.setWeightage(null);
		return organizationHierarchyDTO;
	}

	private String generateNewVersion() {
		MstOrganization mstOrganization = organizationRepo.findFirstByOrderByCreatedDateDescIdDesc();
		if (mstOrganization != null) {
			String lastCreatedworkshopID = mstOrganization.getVersion();
			Pattern pattern = Pattern.compile("[a-z]+|\\d+");
			Matcher matcher = pattern.matcher(lastCreatedworkshopID);
			int numberPartOfLastCreatedID = 0;
			while (matcher.find()) {
				numberPartOfLastCreatedID = Integer.parseInt(matcher.group());
			}
			// New ID
			int newVersionID = numberPartOfLastCreatedID + 1;
			return VERSION_PREFIX + newVersionID;
		} else {
			return VERSION_PREFIX + 1;
		}
	}
	
	public List<OrgWeightageDTO> getAllWeightages(){
		return MapperUtils.mapToTargetClass(orgWeightageRepo.findAll(), OrgWeightageDTO.class);
	}
	
	public Integer getMaxLevelCompleted(String version){	
		Integer maxLevelCreated = hierarchyRepo.getMaxLevelCompleted(version, ACTIVE_FLAG);
		if(maxLevelCreated == null) {
			maxLevelCreated = -1;
		} 
		return maxLevelCreated;
	}

}
