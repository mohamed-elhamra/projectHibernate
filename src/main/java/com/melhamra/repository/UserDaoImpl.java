package com.melhamra.repository;

import com.melhamra.model.Company;
import com.melhamra.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public class UserDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
        session.close();
    }

    public User getUserByID(int id){
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public void updateUser(User user){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
        session.close();
    }

    public void deleteUserByID(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        User user = session.get(User.class, id);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    public List<User> getAllUsers(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User");
        List<User> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }

    public List<User> getUserByInformations(String id, String name){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Query query = session.createQuery("from User where id = :id and name = :name");
        query.setParameter("id",Integer.parseInt(id));
        query.setParameter("name",name);
        List<User> list = query.list();
        session.getTransaction().commit();
        session.close();
        return list;
    }


}
