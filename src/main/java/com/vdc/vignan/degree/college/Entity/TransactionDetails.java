package com.vdc.vignan.degree.college.Entity;

// import java.util.Date;
// import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TransactionDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
    private String type;
    private double amount;
    private String description;
    private String receiptno;
    private String mode;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getReceiptno() {
		return receiptno;
	}
	public void setReceiptno(String receiptno) {
		this.receiptno = receiptno;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	@Override
	public String toString() {
		return "TransactionDetails [id=" + id + ", type=" + type + ", amount=" + amount + ", description=" + description
				+ ", receiptno=" + receiptno + ", mode=" + mode + ", getId()=" + getId() + ", getType()=" + getType()
				+ ", getAmount()=" + getAmount() + ", getDescription()=" + getDescription() + ", getReceiptno()="
				+ getReceiptno() + ", getMode()=" + getMode() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

    
}



