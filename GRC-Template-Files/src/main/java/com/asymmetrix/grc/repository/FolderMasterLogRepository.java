package com.asymmetrix.grc.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.entity.FolderMasterLog;

@Repository
public interface FolderMasterLogRepository extends JpaRepository<FolderMasterLog, Long> {
	
}
