package com.grc.email.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grc.email.entity.EmailNotification;


public interface EmailNotificationRepository extends JpaRepository<EmailNotification, Long>{
	List<EmailNotification> findByStatus(String status);
}
