package com.invex.mx.model.dto;

import java.util.List;


public class PagableInvexEmployee {
	private List<EmployeeDto> employeeInvex;
	
	private Integer totalpages;
	private Long totalElements;
	private Integer size;

	public List<EmployeeDto> getEmployeeInvex() {
		return employeeInvex;
	}
	public void setEmployeeInvex(List<EmployeeDto> employeeInvex) {
		this.employeeInvex = employeeInvex;
	}
	public Integer getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(Integer totalpages) {
		this.totalpages = totalpages;
	}
	public Long getTotalElements() {
		return totalElements;
	}
	public void setTotalElements(Long totalElements) {
		this.totalElements = totalElements;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}

	
}
