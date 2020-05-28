package com.melhamra.repository;


import com.melhamra.model.User;
import com.melhamra.model.UserType1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userType1Repository")
public class UserType1DaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveUser(UserType1 userType1){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(userType1);
        session.getTransaction().commit();
        session.close();
    }

}
