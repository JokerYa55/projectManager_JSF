/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.jboss.logging.Logger;
import ru.project.beans.Users;
import ru.project.interfaces.daoInterface;

/**
 *
 * @author vasiliy.andricov
 */
public class UsersDAO implements daoInterface<Users, Long> {

    private Logger log = Logger.getLogger(getClass().getName());

    private EntityManager em;
    private static EntityManagerFactory emf;

    public UsersDAO() {
        if (emf == null) {
            this.emf = Persistence.createEntityManagerFactory("projectManage_JPA");
        }
        em = emf.createEntityManager();
    }

//    public Users getItem(Long id) {
//        log.info("getItem");
//
//        Users res = null;
//        try {
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        return res;
//    }
//
//    public List<Users> getList() {
//        List<Users> res = new LinkedList();
//        try {
//            log.info("getList()");
//            em.getTransaction().begin();
//            TypedQuery<Users> namedQuery = em.createNamedQuery("Users.findAll", Users.class);
//            //namedQuery.setParameter("id", id);
//            em.getTransaction().commit();
//            res = namedQuery.getResultList();
//
//        } catch (Exception e) {
//            log.error(e.getMessage());
//        }
//        return res;
//    }

//    public void addItem(Users item) {
//        try {
//            log.info("addItem()");
//            em.getTransaction().begin();
//            em.persist(item);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//        }
//    }

    @Override
    public EntityManager getEM() {
        return em;
    }
}
