package com.metacube.StudentProject.services;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Student {
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	public String first_name;
	 
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	public String last_name;
	
	@NotEmpty(message="{field.empty}")
	@Pattern(regexp="[A-Z a-z]*",message="{name.validation}")
	public String father_name;
	
	@NotEmpty(message="{field.empty}")
	@Email(message="{email.validation}")
	public String email;
	
	@NotEmpty(message="{field.empty}")
	public String cls;
	
	@NotNull(message="{field.empty}")
	@Min(value=1,message="{min.age}")
	@Max(value=50,message="{max.age}")
	public int age;
	
	
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getFather_name() {
		return father_name;
	}
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCls() {
		return cls;
	}
	public void setCls(String cls) {
		this.cls = cls;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
