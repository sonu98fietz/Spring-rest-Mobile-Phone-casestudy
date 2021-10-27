package com.example.springbootrestdemo.service;

import java.util.List;

import com.example.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.example.springbootrestdemo.entites.MobilePhone;
import com.example.springbootrestdemo.exception.MobilePhoneNotFoundException;

public interface MobilePhoneService {

	public List<MobilePhone> getAllMobiles();
	
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneNotFoundException;
	
	public MobilePhone getMobilePhoneById(long id);
	
	public void editMobilephone(MobilePhone mobilePhone);
	
	public void deleteMobilePhone(long id);
	
	public List<MobilePhoneDto> getAllMobilePhones();
}
