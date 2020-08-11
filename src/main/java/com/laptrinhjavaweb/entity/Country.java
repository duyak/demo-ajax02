package com.laptrinhjavaweb.entity;
// default package
// Generated Aug 11, 2020 8:47:55 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Country generated by hbm2java
 */
@Entity
@Table(name = "country", catalog = "ajax3")
public class Country implements java.io.Serializable {

	private Integer id;
	private String name;
	private Set<State> states = new HashSet<State>(0);

	public Country() {
	}

	public Country(String name, Set<State> states) {
		this.name = name;
		this.states = states;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "country")
	public Set<State> getStates() {
		return this.states;
	}

	public void setStates(Set<State> states) {
		this.states = states;
	}

}