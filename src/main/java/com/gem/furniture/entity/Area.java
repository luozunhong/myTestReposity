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
@Table(name = "AREA")
public class Area {
	@Id
	private Long id;
	private String code;
	private String name;
	private String cityId;

	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", name=" + name + "]";
	}
}
