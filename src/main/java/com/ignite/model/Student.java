package com.ignite.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8833325000869266534L;
	private Long id;
	private String name;
	private Double avg;
}
