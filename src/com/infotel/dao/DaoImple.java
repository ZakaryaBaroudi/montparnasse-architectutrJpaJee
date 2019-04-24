package com.infotel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.infotel.metier.Adresse;
import com.infotel.metier.Connexion;
import com.infotel.metier.Personne;

public class DaoImple implements Idao {
	
	EntityManagerFactory emf; // EMFactory créer l'autoroute (unité de persistence), 
	
	//et EM créer les requetes (porteur de requete)
	EntityManager em;

	@Override
	public int ajouterPersonne(Personne p) {
		// ouverture unité de persistance et transaction (déclaration)
		
			emf = Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
		try {
			//1 Débuter la transaction
			tx.begin();
			
			//2 effectuer la requete
			em.persist(p);
			//3 valider la transaction
			tx.commit();
			//4 fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		
		return p.getId();
	}
	
	@Override
	public Personne affichagePersonne(int id) {
		// ouverture unité de persistance
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Personne p = new Personne();
		
		try {
			p=em.find(Personne.class, id);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}
	

	@Override
	public Personne getPersonne(int id) {
		// ouverture unité de persistance
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Personne p = new Personne();
		
		try {
			p=em.getReference(Personne.class, id);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return p;
	}
	
	
	

	@Override
	public int supprimerPersonne(Personne p) {
		// ouverture unité de persistance et transaction (déclaration)
		
					emf = Persistence.createEntityManagerFactory("demojpa-pu");
					em = emf.createEntityManager();
					EntityTransaction tx = em.getTransaction();
					
				try {
					//1 Débuter la transaction
					tx.begin();
					
					//2 effectuer la requete
					em.remove(p);
					//3 valider la transaction
					tx.commit();
					//4 fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				
				return p.getId();
			}

	@Override
	public int modifierPersonne(Personne p) {
		// ouverture unité de persistance et transaction (déclaration)
		
					emf = Persistence.createEntityManagerFactory("demojpa-pu");
					em = emf.createEntityManager();
					EntityTransaction tx = em.getTransaction();
					
				try {
					//1 Débuter la transaction
					tx.begin();
					
					//2 effectuer la requete
					em.merge(p);
					//3 valider la transaction
					tx.commit();
					//4 fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				
				return p.getId();
	}

	@Override
	public List<Personne> findAllPersonnes() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q=em.createQuery("SELECT p FROM Personne p");
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	


	@Override
	public List<Personne> rechercherParMC(String mc) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q=em.createQuery("SELECT p FROM Personne p where nom like :lenom");
			q.setParameter("lenom", "%"+mc+"%");
			
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public int ajouterAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
	try {
		//1 Débuter la transaction
		tx.begin();
		
		//2 effectuer la requete
		em.persist(a);
		//3 valider la transaction
		tx.commit();
		//4 fermer l'unité de persistance
		em.close();
		emf.close();
	} catch (Exception e) {
		// annule la transaction
		tx.rollback();
	}
	
	return a.getIdAdresse();
	}

	@Override
	public Adresse affichageAdresse(int idAdresse) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Adresse a = new Adresse();
		
		try {
			a=em.find(Adresse.class, idAdresse);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	@Override
	public Adresse getAdresse(int idAdresse) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Adresse a = new Adresse();
		
		try {
			a=em.getReference(Adresse.class, idAdresse);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	@Override
	public int supprimerAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
	try {
		//1 Débuter la transaction
		tx.begin();
		
		//2 effectuer la requete
		em.remove(a);
		//3 valider la transaction
		tx.commit();
		//4 fermer l'unité de persistance
		em.close();
		emf.close();
	} catch (Exception e) {
		// annule la transaction
		tx.rollback();
	}
	
	return a.getIdAdresse();
	}

	@Override
	public int modifierAdresse(Adresse a) {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
	try {
		//1 Débuter la transaction
		tx.begin();
		
		//2 effectuer la requete
		em.merge(a);
		//3 valider la transaction
		tx.commit();
		//4 fermer l'unité de persistance
		em.close();
		emf.close();
	} catch (Exception e) {
		// annule la transaction
		tx.rollback();
	}
	
	return a.getIdAdresse();
	}
	
	@Override
	public List<Adresse> findAllAdresses() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Adresse> l = new ArrayList<Adresse>();
		try {
			q=em.createQuery("SELECT a FROM Adresse a");
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	@Override
	public List<Adresse> rechercherAdresseParMC(String mc) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Adresse> l = new ArrayList<Adresse>();
		try {
			q=em.createQuery("SELECT a FROM Adresse a where nomRue like :larue");
			q.setParameter("larue", "%"+mc+"%");
			
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}
	
	@Override
	public int ajouterConnexion(Connexion c) {
		// ouverture unité de persistance et transaction (déclaration)
		
			emf = Persistence.createEntityManagerFactory("demojpa-pu");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
		try {
			//1 Débuter la transaction
			tx.begin();
			
			//2 effectuer la requete
			em.persist(c);
			//3 valider la transaction
			tx.commit();
			//4 fermer l'unité de persistance
			em.close();
			emf.close();
		} catch (Exception e) {
			// annule la transaction
			tx.rollback();
		}
		
		return c.getIdConnexion();
	}
	
	@Override
	public Connexion affichageConnexion(int idConnexion) {
		// ouverture unité de persistance
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Connexion c = new Connexion();
		
		try {
			c=em.find(Connexion.class, idConnexion);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	

	@Override
	public Connexion getConnexion(int idConnexion) {
		// ouverture unité de persistance
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		
		Connexion c = new Connexion();
		
		try {
			c=em.getReference(Connexion.class, idConnexion);
			
			em.close();
			emf.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return c;
	}
	
	
	

	@Override
	public int supprimerConnexion(Connexion c) {
		// ouverture unité de persistance et transaction (déclaration)
		
					emf = Persistence.createEntityManagerFactory("demojpa-pu");
					em = emf.createEntityManager();
					EntityTransaction tx = em.getTransaction();
					
				try {
					//1 Débuter la transaction
					tx.begin();
					
					//2 effectuer la requete
					em.remove(c);
					//3 valider la transaction
					tx.commit();
					//4 fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				
				return c.getIdConnexion();
			}

	@Override
	public int modifierConnexion(Connexion c) {
		// ouverture unité de persistance et transaction (déclaration)
		
					emf = Persistence.createEntityManagerFactory("demojpa-pu");
					em = emf.createEntityManager();
					EntityTransaction tx = em.getTransaction();
					
				try {
					//1 Débuter la transaction
					tx.begin();
					
					//2 effectuer la requete
					em.merge(c);
					//3 valider la transaction
					tx.commit();
					//4 fermer l'unité de persistance
					em.close();
					emf.close();
				} catch (Exception e) {
					// annule la transaction
					tx.rollback();
				}
				
				return c.getIdConnexion();
	}

	@Override
	public List<Connexion> findAllConnexions() {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Connexion> l = new ArrayList<Connexion>();
		try {
			q=em.createQuery("SELECT c FROM Connexion c");
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	


	@Override
	public List<Connexion> rechercherConnexionParMC(String mc) {
		// TODO Auto-generated method stub
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Connexion> l = new ArrayList<Connexion>();
		try {
			q=em.createQuery("SELECT c FROM Connexion c where login like :lelogin");
			q.setParameter("lelogin", "%"+mc+"%");
			
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;

	}

	@Override
	public List<Personne> findAllPersonnesConnexions() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q=em.createQuery("SELECT p FROM Personne p join p.connexion");
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Personne> findAllPersonnesAdresses() {
		emf = Persistence.createEntityManagerFactory("demojpa-pu");
		em = emf.createEntityManager();
		Query q=null;
		List<Personne> l = new ArrayList<Personne>();
		try {
			q=em.createQuery("SELECT p FROM Personne p join p.adresse");
			l=q.getResultList();
			em.close();
			emf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	


}
