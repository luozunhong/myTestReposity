package com.gem.furniture.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CITY")
public class City {
	@Id
	private Long id;
	private String code;
	private String name;
	private String provinceId;

	@Override
	public String toString() {
		return "City [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
}
