package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.PolicyOrganization;

@Repository
public interface PolicyOrganizationDDRepo  extends JpaRepository<PolicyOrganization, String> {

}
