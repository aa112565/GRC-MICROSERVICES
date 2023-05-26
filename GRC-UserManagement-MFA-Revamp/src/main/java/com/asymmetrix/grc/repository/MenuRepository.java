package com.asymmetrix.grc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asymmetrix.grc.entity.CnfgMenu;

public interface MenuRepository extends JpaRepository<CnfgMenu, String> {

}
