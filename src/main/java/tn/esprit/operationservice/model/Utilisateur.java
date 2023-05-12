package tn.esprit.operationservice.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Utilisateur implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2944329031519034793L;

	@Column(name = "email")
	private String email;
	@Column(name = "adresse")
	private String adresse;

	@Column(name = "num_Tel")
	private String num_Tel;

	@Transient
	private String password;

	@Id
	@Column(name = "username")
	private String username;

	@Transient
	private Collection<GrantedAuthority> authorities = AuthorityUtils.NO_AUTHORITIES;

	@Transient
	private boolean accountNonExpired = true;

	@Transient
	private boolean accountNonLocked = true;

	@Transient
	private boolean credentialsNonExpired = true;

	@Transient
	private boolean enabled = true;

	@OneToMany(mappedBy = "numeroCompte")
	private List<Compte> comptetList = new ArrayList<>();

	

	public Utilisateur() {
		super();
	}

	public Utilisateur(String username,String password,
			boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired, boolean enabled) {
		super();
		this.password = password;
		this.username = username;
		this.accountNonExpired = accountNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.credentialsNonExpired = credentialsNonExpired;
		this.enabled = enabled;
	}



	public Utilisateur(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNum_Tel() {
		return num_Tel;
	}

	public void setNum_Tel(String num_Tel) {
		this.num_Tel = num_Tel;
	}

	public List<Compte> getComptetList() {
		return comptetList;
	}

	public void setComptetList(List<Compte> comptetList) {
		this.comptetList = comptetList;
	}

	

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.authorities;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return this.accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {
		return this.accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return this.credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		return this.enabled;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		List<GrantedAuthority> mutableAuthorities = new ArrayList<>();
		mutableAuthorities.addAll(authorities);
		this.authorities=Collections.unmodifiableList(mutableAuthorities);
	}

	public void setAccountNonExpired(boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public void setCredentialsNonExpired(boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (accountNonExpired ? 1231 : 1237);
		result = prime * result + (accountNonLocked ? 1231 : 1237);
		result = prime * result + ((adresse == null) ? 0 : adresse.hashCode());
		result = prime * result + ((authorities == null) ? 0 : authorities.hashCode());
		result = prime * result + ((comptetList == null) ? 0 : comptetList.hashCode());
		result = prime * result + (credentialsNonExpired ? 1231 : 1237);
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + ((num_Tel == null) ? 0 : num_Tel.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
}
