package com.userservice.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "micro_users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	// id name email about
	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "NAME", length = 20)
	private String name;
	@Column(name = "EMAIL", length = 30)
	private String email;
	@Column(name = "ABOUT")
	private String about;
	@Transient
	private List<Rating> ratings= new ArrayList<>();

}
