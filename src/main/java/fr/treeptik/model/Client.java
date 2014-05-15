package fr.treeptik.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Size(min=2, max=10, message = "Le nom doit faire entre 2 et 10 char")
	@NotNull(message = "Pas de nom")
	private String nom;
	
	@Email(message = "Email non valide")
	private String email;
	
	@NotNull(message = "Pas d'age")
	private Integer age;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Past(message = "Date incorrecte")
	private Date dateInscription;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", email=" + email
				+ ", age=" + age + ", dateInscription=" + dateInscription + "]";
	}
	
}
