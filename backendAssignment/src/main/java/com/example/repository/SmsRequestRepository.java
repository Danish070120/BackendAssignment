package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.SmsRequest;
import com.sun.xml.bind.v2.model.core.ID;

public interface SmsRequestRepository extends JpaRepository<SmsRequest, ID> {

}
