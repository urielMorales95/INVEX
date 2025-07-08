package com.invex.mx.model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "EMPLOYEE")

public class Employee {
	 
	public Employee() {}	

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEE_ID")
    private Long employeeId;

    @Column(name = "FIRST_NAME", nullable = false)
    @NotBlank(message = "Validation failed: name is required.")
    @NotNull(message = "Validation failed:  name is required.")
    private String firstName;

    @Column(name = "MIDDLE_NAME")
    private String middleName;

    @Column(name = "LAST_NAME", nullable = false)
    @NotBlank(message = "Validation failed: last name is required.")
    @NotNull(message = "Validation failed: last name is required.")
    private String lastName;

    @Column(name = "SECOND_LAST_NAME")
    private String secondLastName;

    @Column(name = "AGE")
    @NotBlank(message = "Validation failed: age is required.")
    @NotNull(message = "Validation failed: age is required.")
    private Integer age;

    @Column(name = "GENDER")
    @NotBlank(message = "Validation failed: gender is required.")
    @NotNull(message = "Validation failed: gender is required.")
    private String gender;

    @Column(name = "BIRTH_DATE", nullable = false)
    @NotBlank(message = "Validation failed: gender is required.")
    @NotNull(message = "Validation failed: gender is required.")
    private LocalDate birthDate;

    @Column(name = "JOB_TITLE", nullable = false)
    private String jobTitle;

    @Column(name = "SYSTEM_ENTRY_DATE")
    @NotBlank(message = "Validation failed: Entry is required.")
    @NotNull(message = "Validation failed: Entry is required.")
    private LocalDateTime systemEntryDate = LocalDateTime.now();

    @Column(name = "ACTIVE_STATUS")
    @NotBlank(message = "Validation failed: status is required.")
    @NotNull(message = "Validation failed: status is required.")
    private String activeStatus = "A";

    // Getters and Setters
    
   

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public LocalDateTime getSystemEntryDate() {
		return systemEntryDate;
	}

	public void setSystemEntryDate(LocalDateTime systemEntryDate) {
		this.systemEntryDate = systemEntryDate;
	}

	public String getActiveStatus() {
		return activeStatus;
	}

	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}

    
}