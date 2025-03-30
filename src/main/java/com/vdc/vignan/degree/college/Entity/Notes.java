package com.vdc.vignan.degree.college.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notes {

    @Id
    @Column(unique = true, nullable = false)
    private String id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String description;

    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Notes [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", getId()=" + getId() + ", getTitle()=" + getTitle() + ", getDescription()=" + getDescription()
				+ ", getCategory()=" + getCategory() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	@Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    public enum Category {
        GENERAL, OFFICIAL, TECHNICAL
    }
}
