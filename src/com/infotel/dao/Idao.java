package com.infotel.dao;

import java.util.List;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public interface Idao {
	
	public int ajouterPersonne(Personne p);
	public Personne affichagePersonne(int id);
	public Personne getPersonne(int id);
	public int supprimerPersonne(Personne p);
	public int modifierPersonne(Personne p);
	public List<Personne> findAllPersonnes();
	public List<Personne> rechercherParMC(String mc);
	
	
	public List<Personne> findAllPersonnesConnexions();
	public List<Personne> findAllPersonnesAdresses();

	
	public int ajouterAdresse(Adresse a);
	public Adresse affichageAdresse(int idAdresse);
	public Adresse getAdresse(int idAdresse);
	public int supprimerAdresse(Adresse a);
	public int modifierAdresse(Adresse a);
	public List<Adresse> findAllAdresses();
	public List<Adresse> rechercherAdresseParMC(String mc);
	
	public int ajouterConnexion(Connexion c);
	public Connexion affichageConnexion(int idConnexion);
	public Connexion getConnexion(int idConnexion);
	public int supprimerConnexion(Connexion c);
	public int modifierConnexion(Connexion c);
	public List<Connexion> findAllConnexions();
	public List<Connexion> rechercherConnexionParMC(String mc);
}
