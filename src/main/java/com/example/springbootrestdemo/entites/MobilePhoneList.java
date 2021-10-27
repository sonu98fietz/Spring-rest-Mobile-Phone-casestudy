package com.example.springbootrestdemo.entites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MobilePhoneList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long mobilePhoneListId;
	
	@OneToMany
	@JoinColumn(name = "mobilephonelist_id")
	private List<MobilePhone> mobilePhones;

}
