package com.sage.deliveryfood.models;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;

import com.sage.deliveryfood.enums.RoleName;

@Entity
@Table(name = "TB_ROLE")
public class RoleModel implements GrantedAuthority, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false, unique = false)
	private RoleName roleName;
	
	public RoleModel(RoleName roleName) {
		super();
		this.roleName = roleName;
	}
	
	public RoleModel() {
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public RoleName getRoleName() {
		return roleName;
	}

	public void setRoleName(RoleName roleName) {
		this.roleName = roleName;
	}

	@Override
	public String getAuthority() {
		return roleName.toString();
	}
	
}
