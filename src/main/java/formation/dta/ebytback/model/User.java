package formation.dta.ebytback.model;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4839107002418554325L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String nom;
	@Column
	private String prenom;
	@Column
	private String photo;
	@Column
	private String role;
	

	public User() {
		this("test@hotmail.fr", "1234", "nom", "prenom");
	}
	
	public User(String mail, String mdp, String nom, String prenom) {
		this.username = mail;
		this.password = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.photo = "";
		this.role = EnumRole.ROLE_USER.getRole();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}	
}
