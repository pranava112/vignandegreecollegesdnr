package com.vdc.vignan.degree.college.Entity;

import java.util.Arrays;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;



@Entity

public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long id;
    private String name;
    @Lob
    private byte[] data;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public byte[] getData() {
		return data;
	}
	public void setData(byte[] data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "Image [id=" + id + ", name=" + name + ", data=" + Arrays.toString(data) + ", getId()=" + getId()
				+ ", getName()=" + getName() + ", getData()=" + Arrays.toString(getData()) + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
    
    

}
