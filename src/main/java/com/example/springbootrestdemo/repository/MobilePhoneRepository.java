package com.example.springbootrestdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.springbootrestdemo.entites.MobilePhone;

@Repository
public interface MobilePhoneRepository extends JpaRepository<MobilePhone, Long> {
	//In-build methods
	//or
	//Custom query
	
	@Query(value = "select m from MobilePhone m")
	public List<MobilePhone> getAllMobileDetails();	
	
	@Query(value = "select m from MobilePhone m where m.mobileId = :id")
	public MobilePhone getMobilePhoneById(@Param(value = "id") long id);

}
