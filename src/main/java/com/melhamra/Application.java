package com.melhamra;

import com.melhamra.model.Company;
import com.melhamra.model.Project;
import com.melhamra.model.User;
import com.melhamra.model.UserType1;
import com.melhamra.repository.CompanyDaoImpl;
import com.melhamra.repository.ProjectDaoImpl;
import com.melhamra.repository.UserDaoImpl;
import com.melhamra.repository.UserType1DaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Application {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

        UserDaoImpl userDao = applicationContext.getBean("userRepository",UserDaoImpl.class);
        ProjectDaoImpl projectDao = applicationContext.getBean("projectRepository",ProjectDaoImpl.class);
        CompanyDaoImpl companyDao = applicationContext.getBean("companyRepository",CompanyDaoImpl.class);
        UserType1DaoImpl userType1Dao = applicationContext.getBean("userType1Repository", UserType1DaoImpl.class);

        /*Company company = new Company();
        company.setName("company 1");
        for (int i = 1; i < 10; i++){
            UserType1 userType1 = new UserType1();
            userType1.setName("user " + i);
            userType1.setType1Value("zbila");
            userType1.setCompany(company);
            userType1Dao.saveUser(userType1);
        }*/

        Company company = new Company();
        company.setName("company 1");
        UserType1 userType1 = new UserType1();
        userType1.setName("user 1");
        userType1.setType1Value("zbila");
        userType1.setCompany(company);


        company.getUsers().add(userType1);
        companyDao.saveCompany(company);

        /*userDao.getUserByInformations("5","user 5")
                .forEach(user -> System.out.println(user.getId()+" --- "+user.getName()));*/

        /*List<Project> listProject = projectDao.getProjectBySubject("subject 1");
        List<Project> listProject1 = projectDao.getProjectBySubject("subject 1");*/

        /*Project project = projectDao.getProjectByID(1);
        Project project1 = projectDao.getProjectByID(1);*/




    }

}
