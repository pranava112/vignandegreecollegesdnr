package com.vdc.vignan.degree.college.Entity;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.List;
import java.util.Map;


@Entity

@JsonIgnoreProperties(ignoreUnknown = true)

public class Student {
    @Id

    private String rollno;
    private String surname;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date dob;
    private String jyear;
    @Column(name = "student_group")
    private String group;
    private String year;
    private String school;
    private String tenthgpa;
    private String inter;
    private String intergpa;
    private String mobile;
    private String address;
    private double balance;
    private double sem1;
    private double sem2;
    private double sem3;
    private double sem4;
    private double sem5;
    private double sem6;

    @Column(columnDefinition = "json")
    @Convert(converter = TransactionsConverter.class)
    private List<TransactionDetails> transactions;
    
    @Column(columnDefinition = "json")
    @Convert(converter = AttendanceConverter.class)
    private Map<Date, Map<String, String>> attendanceRecords;

	public String getRollno() {
		return rollno;
	}

	public void setRollno(String rollno) {
		this.rollno = rollno;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getJyear() {
		return jyear;
	}

	public void setJyear(String jyear) {
		this.jyear = jyear;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getTenthgpa() {
		return tenthgpa;
	}

	public void setTenthgpa(String tenthgpa) {
		this.tenthgpa = tenthgpa;
	}

	public String getInter() {
		return inter;
	}

	public void setInter(String inter) {
		this.inter = inter;
	}

	public String getIntergpa() {
		return intergpa;
	}

	public void setIntergpa(String intergpa) {
		this.intergpa = intergpa;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getSem1() {
		return sem1;
	}

	public void setSem1(double sem1) {
		this.sem1 = sem1;
	}

	public double getSem2() {
		return sem2;
	}

	public void setSem2(double sem2) {
		this.sem2 = sem2;
	}

	public double getSem3() {
		return sem3;
	}

	public void setSem3(double sem3) {
		this.sem3 = sem3;
	}

	public double getSem4() {
		return sem4;
	}

	public void setSem4(double sem4) {
		this.sem4 = sem4;
	}

	public double getSem5() {
		return sem5;
	}

	public void setSem5(double sem5) {
		this.sem5 = sem5;
	}

	public double getSem6() {
		return sem6;
	}

	public void setSem6(double sem6) {
		this.sem6 = sem6;
	}

	public List<TransactionDetails> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<TransactionDetails> transactions) {
		this.transactions = transactions;
	}

	public Map<Date, Map<String, String>> getAttendanceRecords() {
		return attendanceRecords;
	}

	public void setAttendanceRecords(Map<Date, Map<String, String>> attendanceRecords) {
		this.attendanceRecords = attendanceRecords;
	}

	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", surname=" + surname + ", name=" + name + ", dob=" + dob + ", jyear="
				+ jyear + ", group=" + group + ", year=" + year + ", school=" + school + ", tenthgpa=" + tenthgpa
				+ ", inter=" + inter + ", intergpa=" + intergpa + ", mobile=" + mobile + ", address=" + address
				+ ", balance=" + balance + ", sem1=" + sem1 + ", sem2=" + sem2 + ", sem3=" + sem3 + ", sem4=" + sem4
				+ ", sem5=" + sem5 + ", sem6=" + sem6 + ", transactions=" + transactions + ", attendanceRecords="
				+ attendanceRecords + ", getRollno()=" + getRollno() + ", getSurname()=" + getSurname() + ", getName()="
				+ getName() + ", getDob()=" + getDob() + ", getJyear()=" + getJyear() + ", getGroup()=" + getGroup()
				+ ", getYear()=" + getYear() + ", getSchool()=" + getSchool() + ", getTenthgpa()=" + getTenthgpa()
				+ ", getInter()=" + getInter() + ", getIntergpa()=" + getIntergpa() + ", getMobile()=" + getMobile()
				+ ", getAddress()=" + getAddress() + ", getBalance()=" + getBalance() + ", getSem1()=" + getSem1()
				+ ", getSem2()=" + getSem2() + ", getSem3()=" + getSem3() + ", getSem4()=" + getSem4() + ", getSem5()="
				+ getSem5() + ", getSem6()=" + getSem6() + ", getTransactions()=" + getTransactions()
				+ ", getAttendanceRecords()=" + getAttendanceRecords() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

    // Getters and Setters
}
