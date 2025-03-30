// package com.vdc.vignan.degree.college.Entity;

// import jakarta.persistence.Entity;
// import jakarta.persistence.Id;
// import lombok.Data;

// @Entity
// @Data
// public class Announcement {

//     @Id
//     private int id;
//     private String information;


    
// }

package com.vdc.vignan.degree.college.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Announcement {
    @Id
    private int id;
    private String information;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	@Override
	public String toString() {
		return "Announcement [id=" + id + ", information=" + information + ", getId()=" + getId()
				+ ", getInformation()=" + getInformation() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
    
    
}
