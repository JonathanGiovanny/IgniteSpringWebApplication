package com.ignite.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.ignite.cache.query.annotations.QueryGroupIndex;
import org.apache.ignite.cache.query.annotations.QuerySqlField;

import com.ignite.utilities.annotations.IgniteTable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@QueryGroupIndex.List(@QueryGroupIndex(name = "idx1"))
@IgniteTable(cacheName = "StudentCache")
public class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8833325000869266534L;

	@Id
	@GeneratedValue
	@Column(name = "STUDENT_ID")
	@QuerySqlField(index = true, orderedGroups = { @QuerySqlField.Group(name = "idx1", order = 0) })
	private Long id;

	@Column(name = "STUDENT_NAME")
	@QuerySqlField(index = true, orderedGroups = { @QuerySqlField.Group(name = "idx1", order = 1) })
	private String name;

	@Column(name = "STUDENT_AVG")
	private Double avg;
}
