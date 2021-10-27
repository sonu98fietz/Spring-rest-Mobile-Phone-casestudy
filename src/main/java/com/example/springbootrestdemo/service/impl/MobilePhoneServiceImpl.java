package com.example.springbootrestdemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.example.springbootrestdemo.entites.MobilePhone;
import com.example.springbootrestdemo.exception.MobilePhoneNotFoundException;
import com.example.springbootrestdemo.mapper.MobilePhoneMapper;
import com.example.springbootrestdemo.repository.MobilePhoneRepository;
import com.example.springbootrestdemo.service.MobilePhoneService;

@Service
public class MobilePhoneServiceImpl implements MobilePhoneService {
	
	@Autowired
	private MobilePhoneRepository repo; //MobilePhone Class
	
	@Autowired
	private MobilePhoneMapper mapper; //MobilePhoneDto

	@Override
	public List<MobilePhone> getAllMobiles() {
		return repo.getAllMobileDetails(); //CUstom Query
		//return repo.findAll(); //in-built methods
	}

	@Override
	public MobilePhone saveMobilePhone(MobilePhone mobilePhone) throws MobilePhoneNotFoundException {
		if(repo.existsById(mobilePhone.getMobileId())) {
			throw new MobilePhoneNotFoundException("Mobile Phone already exist");
		}
		else {
			MobilePhone mobilePhone2 = repo.saveAndFlush(mobilePhone);
			return mobilePhone2;
		}		
	}

	@Override
	public MobilePhone getMobilePhoneById(long id) {
		
		return repo.getMobilePhoneById(id); //Custom Query
		//return repo.findById(id).get(); //in-built menthods
	}

	@Override
	public void editMobilephone(MobilePhone mobilePhone) {
		MobilePhone mobilePhone2 = repo.findById(mobilePhone.getMobileId()).get();
		mobilePhone2.setModelName(mobilePhone.getModelName());
		mobilePhone2.setBrandName(mobilePhone.getBrandName());
		mobilePhone2.setProcessor(mobilePhone.getProcessor());
		mobilePhone2.setBatteryPower(mobilePhone.getBatteryPower());
		mobilePhone2.setColor(mobilePhone.getColor());
		mobilePhone2.setCost(mobilePhone.getCost());
		repo.save(mobilePhone2);	
	}

	@Override
	public void deleteMobilePhone(long id) {
		repo.deleteById(id);
		
	}

	@Override
	public List<MobilePhoneDto> getAllMobilePhones() {
		List<MobilePhone> mobiles = new ArrayList<MobilePhone>();
		mobiles = repo.findAll();
		MobilePhoneDto md = new MobilePhoneDto();
		List<MobilePhoneDto> mds = new ArrayList<MobilePhoneDto>();
		for(MobilePhone m : mobiles) {
			md = mapper.convertToDto(m);
			mds.add(md);
		}
		
		return mds;
	}

	
}
