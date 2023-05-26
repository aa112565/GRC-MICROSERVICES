package com.asymmetrix.grc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.asymmetrix.grc.Entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, String> {

}
