package com.ignite.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Signature implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2067279529146860257L;
	private Long id;
	private String name;
	private Integer points;
}
