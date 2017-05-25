/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sys.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import sys.model.Post;
import sys.util.HibernateUtil;

/**
 *
 * @author Toño
 */
public class postDaoImp implements postDao{

    @Override
    public List<Post> mostrarPost() {
        List<Post> listarPost = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        
        String hql="FROM Post";
        
        try {
            listarPost= session.createQuery(hql).list();
            transaction.commit();
            session.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            transaction.rollback();
        }
        return listarPost;
    }
    
    @Override
    public void nuevoPost(Post post) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(post);
            session.getTransaction().commit();   
        } catch (Exception e) {
              System.out.println(e.getMessage());
              session.getTransaction().rollback();
        } finally{
            if (session != null) {
                session.close();
            }
        }
    }
    
    
    @Override
    public void modificarPost(Post post) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(post);
            session.getTransaction().commit();
            
        } catch (Exception e) {
              System.out.println(e.getMessage());
              session.getTransaction().rollback();
        } finally{
            if (session != null) {
                session.close();
                
            }
        }
    }

    @Override
    public void eliminarPost(Post post) {
        Session session = null;
        
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(post);
            session.getTransaction().commit();
            
        } catch (Exception e) {
              System.out.println(e.getMessage());
              session.getTransaction().rollback();
        } finally{
            if (session != null) {
                session.close();
                
            }
        }
    }
    
}
