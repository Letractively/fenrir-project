/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fenrir.erp.teste;

import com.fenrir.erp.pojo.dao.ContinenteDAO;
import com.fenrir.erp.pojo.entity.Continente;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author felipe-andrade
 */
public class Conection_test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("fenrirErpLibraryPU");
        //EntityManager em = emf.createEntityManager();

        //testeConection(em);
        testeGenericDAO();
        //emf.close();
    }

    public static void testeConection(EntityManager em) {
        verifyConection(em);
        em.getTransaction().begin();
        System.out.println("foi aberta uma trasação.");
        StringBuilder sql = new StringBuilder();
        sql.append(" SELECT r FROM Continente r ");
        List<Continente> result = em.createQuery(sql.toString()).getResultList();
        for (Continente doc : result) {
            System.out.println(doc.getNmContinente().toString());
        }
        em.getTransaction().commit();
        System.out.println("trasação comitada.");
        em.close();
        verifyConection(em);
    }

    public static void testeGenericDAO() {
        ContinenteDAO condao = new ContinenteDAO();
        condao.beginTransaction();
        List<Continente> lista = condao.findAll();
        for (Continente doc : lista) {
            System.out.println(doc.getNmContinente());
        }
        condao.commitAndCloseTransaction();
    }
    
    public static void verifyConection(EntityManager em){
        if (!em.isOpen()) {
            System.out.println("A conexão esta FECHADA.");
        }else{
            System.out.println("A conexão esta ABERTA.");
        }
    }
}
