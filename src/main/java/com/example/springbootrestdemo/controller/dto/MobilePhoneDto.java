package com.example.springbootrestdemo.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MobilePhoneDto {
	
	private String modelName;
	private String color;

}
