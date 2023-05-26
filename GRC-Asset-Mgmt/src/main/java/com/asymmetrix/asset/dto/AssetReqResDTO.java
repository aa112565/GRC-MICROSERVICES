package com.asymmetrix.asset.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AssetReqResDTO {

	private AssetDTO assetdto;
	private AssetAssessmentDTO assetassessmentdto;
	private AssetQuestionAssessmentDTO questassessmentdto;
	private AssetQuestionCategoryAssessmentDTO categorydto;
	private List<AssetQuestionCategoryAssessmentDTO> categorylistdto;
	private List<AssetQuestionAssessmentDTO> assetquestassessmentdto;
	private List<AssetAttachmentsDTO> files;
	private List<AssessmentAttachmentsDTO> assessmentfiles;

	public AssetDTO getAssetdto() {
		return assetdto;
	}

	public void setAssetdto(AssetDTO assetdto) {
		this.assetdto = assetdto;
	}

	public List<AssetAttachmentsDTO> getFiles() {
		return files;
	}

	public void setFiles(List<AssetAttachmentsDTO> files) {
		this.files = files;
	}

	public AssetAssessmentDTO getAssetassessmentdto() {
		return assetassessmentdto;
	}

	public void setAssetassessmentdto(AssetAssessmentDTO assetassessmentdto) {
		this.assetassessmentdto = assetassessmentdto;
	}

	public List<AssessmentAttachmentsDTO> getAssessmentfiles() {
		return assessmentfiles;
	}

	public void setAssessmentfiles(List<AssessmentAttachmentsDTO> assessmentfiles) {
		this.assessmentfiles = assessmentfiles;
	}

	public List<AssetQuestionAssessmentDTO> getAssetquestassessmentdto() {
		return assetquestassessmentdto;
	}

	public void setAssetquestassessmentdto(List<AssetQuestionAssessmentDTO> assetquestassessmentdto) {
		this.assetquestassessmentdto = assetquestassessmentdto;
	}

	public AssetQuestionAssessmentDTO getQuestassessmentdto() {
		return questassessmentdto;
	}

	public void setQuestassessmentdto(AssetQuestionAssessmentDTO questassessmentdto) {
		this.questassessmentdto = questassessmentdto;
	}

	public AssetQuestionCategoryAssessmentDTO getCategorydto() {
		return categorydto;
	}

	public void setCategorydto(AssetQuestionCategoryAssessmentDTO categorydto) {
		this.categorydto = categorydto;
	}

	public List<AssetQuestionCategoryAssessmentDTO> getCategorylistdto() {
		return categorylistdto;
	}

	public void setCategorylistdto(List<AssetQuestionCategoryAssessmentDTO> categorylistdto) {
		this.categorylistdto = categorylistdto;
	}

}
