package com.infotel.service;

import java.util.List;

import com.infotel.dao.DaoImple;
import com.infotel.dao.Idao;
import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class ServiceImpl implements Iservice{
	
	private Idao dao = new DaoImple();

	public int ajouterPersonne(Personne p) {
		return dao.ajouterPersonne(p);
	}

	@Override
	public Personne getPersonne(int id) {
		// TODO Auto-generated method stub
		return dao.getPersonne(id);
	}

	@Override
	public int supprimerPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.supprimerPersonne(p);
	}

	@Override
	public int modifierPersonne(Personne p) {
		// TODO Auto-generated method stub
		return dao.modifierPersonne(p);
	}

	@Override
	public Personne affichagePersonne(int id) {
		// TODO Auto-generated method stub
		return dao.affichagePersonne(id);
	}

	@Override
	public List<Personne> findAllPersonnes() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnes();
	}


	@Override
	public int ajouterAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.ajouterAdresse(a);
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.affichageAdresse(idAdresse);
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		// TODO Auto-generated method stub
		return dao.getAdresse(idAdresse);
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.supprimerAdresse(a);
	}

	@Override
	public int modifierAdresse(Adresse a) {
		// TODO Auto-generated method stub
		return dao.modifierAdresse(a);
	}

	@Override
	public int ajouterConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.ajouterConnexion(c);
	}

	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connexion getConnexion(int idConnexion) {
		// TODO Auto-generated method stub
		return dao.getConnexion(idConnexion);
	}

	@Override
	public int supprimerConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return dao.supprimerConnexion(c);
	}

	@Override
	public int modifierConnexion(Connexion c) {
		// TODO Auto-generated method stub
		return modifierConnexion(c);
	}

	@Override
	public List<Adresse> findAllAdresses() {
		// TODO Auto-generated method stub
		return dao.findAllAdresses();
	}

	@Override
	public List<Connexion> findAllConnexions() {
		// TODO Auto-generated method stub
		return dao.findAllConnexions();
	}

	@Override
	public List<Personne> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherParMC(mc);
	}

	@Override
	public List<Adresse> rechercherAdresseParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherAdresseParMC(mc);
	}

	@Override
	public List<Connexion> rechercherCOnnexionParMC(String mc) {
		// TODO Auto-generated method stub
		return dao.rechercherConnexionParMC(mc);
	}

	@Override
	public List<Personne> findAllPersonnesConnexions() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnesConnexions();
	}

	@Override
	public List<Personne> findAllPersonnesAdresses() {
		// TODO Auto-generated method stub
		return dao.findAllPersonnesAdresses();
	}

}
