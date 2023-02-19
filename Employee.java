package com.employee.details.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
@Entity
@Table(name="employeedetails")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmailid() {
		return Emailid;
	}
	public void setEmailid(String emailid) {
		Emailid = emailid;
	}
	public Integer getAge() {
		return Age;
	}
	public void setAge(Integer age) {
		Age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(Age, Emailid, Id, Name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Age, other.Age) && Objects.equals(Emailid, other.Emailid) && Objects.equals(Id, other.Id)
				&& Objects.equals(Name, other.Name);
	}
	@Override
	public String toString() {
		return "employee [Id=" + Id + ", Name=" + Name + ", Emailid=" + Emailid + ", Age=" + Age + "]";
	}
	
}




