package com.example.springbootrestdemo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.springbootrestdemo.controller.dto.MobilePhoneDto;
import com.example.springbootrestdemo.entites.MobilePhone;

@Mapper
public interface MobilePhoneMapper {
	
	@Mapping(target = "modelName", source = "mobilePhone.modelName")
	@Mapping(target = "color", source = "mobilePhone.color")
	public MobilePhoneDto convertToDto(MobilePhone mobilePhone);
	public MobilePhone convertToEntity(MobilePhoneDto mobilePhoneDto);

}
