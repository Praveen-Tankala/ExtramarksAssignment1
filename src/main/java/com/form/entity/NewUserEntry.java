package com.form.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Service;

import lombok.Getter;

import lombok.Setter;


@Getter
@Setter
@Entity(name="test")
@Service
public class NewUserEntry {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Long phone;
	private String state;
	private String skills;
	private String gender;
	private byte[] image;

}
