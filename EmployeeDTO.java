package com.employee.details.dto;

public class EmployeeDTO {
	

		private Integer Id;
		private String Name;
		private String Emailid;
		private Integer Age;
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			Id = id;
		}
		public String getEmailid() {
			return Emailid;
		}
		public void setEmailid(String emailid) {
			Emailid = emailid;
		}
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public Integer getAge() {
			return Age;
		}
		public void setAge(Integer age) {
			Age = age;
		}
		@Override
		public String toString() {
			return "EmployeeDTO [Id=" + Id + ", Emailid=" + Emailid + ", Name=" + Name + ", Age=" + Age + "]";
		}
		
		
		
	}


