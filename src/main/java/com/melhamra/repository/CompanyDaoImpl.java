package com.melhamra.repository;

import com.melhamra.model.Company;
import net.bytebuddy.asm.Advice;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("companyRepository")
public class CompanyDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveCompany(Company company){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(company);
        session.getTransaction().commit();
        session.close();
    }

    public Company getCompanyByID(int id){
        Session session = sessionFactory.openSession();
        Company company = session.get(Company.class, id);
        session.close();
        return company;
    }

    public void deleteCompanyByID(int id){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Company company = session.get(Company.class, id);
        session.delete(company);
        session.getTransaction().commit();
        session.close();
    }

}
