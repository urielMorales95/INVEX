package com.invex.mx.model.dto;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
	public EmployeeDto(
		    Long employeeId,
		    String firstName,
		    String middleName,
		    String lastName,
		    String secondLastName,
		    Integer age,
		    String gender,
		    LocalDate birthDate,
		    String jobTitle,
		    LocalDateTime systemEntryDate,
		    String activeStatus
		) {
		    this.employeeId = employeeId;
		    this.firstName = firstName;
		    this.middleName = middleName;
		    this.lastName = lastName;
		    this.secondLastName = secondLastName;
		    this.age = age;
		    this.gender = gender;
		    this.birthDate = birthDate;
		    this.jobTitle = jobTitle;
		    this.systemEntryDate = systemEntryDate;
		    this.activeStatus = activeStatus;
		}

	@NotBlank(message = "Validation failed: name is required.")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Validation failed: last name is required.")
    private String lastName;

    private String secondLastName;

    @NotNull(message = "Validation failed: age is required.")
    private Integer age;

    @NotBlank(message = "Validation failed: gender is required.")
    private String gender;

    @NotNull(message = "Validation failed: birth date is required.")
    private LocalDate birthDate;

    @NotBlank(message = "Validation failed: job title is required.")
    private String jobTitle;

    @NotNull(message = "Validation failed: entry date is required.")
    private LocalDateTime systemEntryDate;

    @NotBlank(message = "Validation failed: status is required.")
    private String activeStatus;

	private Long employeeId;

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
