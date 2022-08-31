package com.sage.deliveryfood.models;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "tb_user")
public class UserModel implements Serializable, UserDetails {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", columnDefinition = "BINARY(16)")
	private UUID id;
	private String username;
	private String userPassword;
	
	@ManyToMany
	@JoinTable(name = "tb_user_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<RoleModel> roles;
	
	public UserModel() {
		super();
	}
	
	public UserModel(String username, String userPassword, List<RoleModel> roles) {
		super();
		this.username = username;
		this.userPassword = userPassword;
		this.roles = roles;
	}
	
	public UUID getId() {
		return id;
	}
	public void setId(UUID id) {
		this.id = id;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public List<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleModel> roles) {
		this.roles = roles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.roles;
	}
	@Override
	public String getPassword() {
		return this.userPassword;
	}
	@Override
	public String getUsername() {
		return this.username;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}

}
