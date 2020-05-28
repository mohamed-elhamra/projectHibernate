package com.melhamra.repository;

import com.melhamra.model.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("projectRepository")
public class ProjectDaoImpl {

    @Autowired
    SessionFactory sessionFactory;

    public void saveProject(Project project){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        session.close();
    }

    public Project getProjectByID(int id){
        Session session = sessionFactory.openSession();
        Project project = session.get(Project.class, id);
        return project;
    }

    public List<Project> getProjectBySubject(String subject){
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from Project where subject = :subject");
        query.setParameter("subject",subject);
        query.setCacheable(true);
        List<Project> projects = query.list();
        return projects;
    }

}
