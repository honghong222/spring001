package com.yedam.app.mybatis.service;

import java.util.Date;

import lombok.Data;


@Data
public class EmpInfo {
	private int employeeId;
	private String lastName;
	private Date hireDate;
	private double salary;
}
