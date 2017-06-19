package com.TrackApp.TrackApp.starter;

import com.TrackApp.TrackApp.domain.*;
import com.TrackApp.TrackApp.services.CustomerService;
import com.TrackApp.TrackApp.services.ProjectService;
import com.TrackApp.TrackApp.services.SessionService;
import com.TrackApp.TrackApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by oana_ on 6/16/2017.
 */
@Component
public class JpaStarter implements ApplicationListener<ContextRefreshedEvent> {

    private CustomerService customerService;
    private ProjectService projectService;
    private SessionService sessionService;
    private UserService userService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Autowired
    public void setSessionService(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

        loadUsersAndCustomers();
        loadSession();
        loadProjects();

    }

    public void loadUsersAndCustomers() {

        User user1 = new User();

        user1.setUserName("user1");
        user1.setPassword("password");

        user1.setRole(Role.USER);


        Customer customer1 = new Customer();

        customer1.setLastName("chis");
        customer1.setFirstName("oana");


        user1.setCustomer(customer1);
        userService.saveOrUpdate(user1);



        User user2 = new User();

        user2.setUserName("user2");
        user2.setPassword("password");

        user2.setRole(Role.USER);


        Customer customer2 = new Customer();
        customer2.setLastName("chis");
        customer2.setFirstName("andreea");


        user2.setCustomer(customer2);
        userService.saveOrUpdate(user2);

        User user3 = new User();

        user3.setUserName("admin");
        user3.setPassword("password");

        user3.setRole(Role.ADMIN);


        Customer customer3 = new Customer();
        customer3.setLastName("chis");
        customer3.setFirstName("admin");


        user3.setCustomer(customer3);
        userService.saveOrUpdate(user3);


    }



    private void loadProjects() {
        List<User> users = (List<User>) userService.listAll();
        List<Session> sessions = (List<Session>) sessionService.listAll();

        users.forEach(user -> {
            Project project = new Project();
            project.setCustomer(user.getCustomer());
            project.setDescription("this is my first project-cross hoia ");
            project.setTypeOfProject("runn");

            // this part needs to be checked


//            sessions.forEach(session -> {
//                session.setProject(project);
//
//            });

            project.setCustomer(user.getCustomer());

            project.calculateTotalDuration();


            projectService.saveOrUpdate(project);

        });


    }


    public void loadSession() {

        // to check

        Session session1 = new Session();
        session1.setDuration(10);

        sessionService.saveOrUpdate(session1);


        // to check

        Session session2 = new Session();
        session2.setDuration(20);

        sessionService.saveOrUpdate(session2);


    }


}
