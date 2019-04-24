package com.infotel.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infotel.metier.Personne;
import com.infotel.service.Iservice;
import com.infotel.service.ServiceImpl;


/**
 * Servlet implementation class ModifierPersonne
 */
@WebServlet("/ModifierPersonne")
public class ModifierPersonne extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Iservice service = new ServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierPersonne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//1 - Récupération des données
        
		int id = Integer.parseInt(request.getParameter("id"));
        Personne p = service.affichagePersonne(id);
        
        //2 - Envoyer à la couche service
    

        
        //3 - Préparation à l'envoi
        
        request.setAttribute("id", p.getId());
        
        request.setAttribute("nom", p.getNom());
        request.setAttribute("prenom", p.getPrenom());
        request.setAttribute("age", p.getAge());
        request.setAttribute("personne", service.findAllPersonnes());
        request.setAttribute("adresses", service.findAllAdresses());
        
        //4 - Envoi à la JSP
        
        request.getRequestDispatcher("personne.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
