package com.vdc.vignan.degree.college.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data

public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String uname;
    private long mobile;   // mobile as long, can store a 10-digit number
    private String email;
    private String password;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Register [id=" + id + ", uname=" + uname + ", mobile=" + mobile + ", email=" + email + ", password="
				+ password + ", getId()=" + getId() + ", getUname()=" + getUname() + ", getMobile()=" + getMobile()
				+ ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    
    
    
}
