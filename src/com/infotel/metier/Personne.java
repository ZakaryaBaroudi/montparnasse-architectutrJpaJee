package com.infotel.metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
//methode1 tout dans une single table    
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_PERS")
@DiscriminatorValue("PERS")
//methode2@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//Methode 3@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
	@Id
	//Pour single table 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// Methode 3 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom;
	private String Prenom;
	private int age;
	
	
	@ManyToOne //(cascade = {CascadeType.PERSIST})
	private Adresse adresse;
	
	@OneToOne (cascade = {CascadeType.PERSIST})
	private Connexion connexion;

	@ManyToMany
	private List<Club> clubs = new ArrayList<Club>();
	
	public Connexion getConnexion() {
		return connexion;
	}

	public void setConnexion(Connexion connexion) {
		this.connexion = connexion;
	}

	public int getId() {
		return id;
	}

	public void setIdPersonne(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	

	@Override
	public String toString() {
		return "Personne [id=" + id + ", nom=" + nom + ", Prenom=" + Prenom + ", age=" + age + 
				", adresse=" + adresse + "]";
	}
	


}
