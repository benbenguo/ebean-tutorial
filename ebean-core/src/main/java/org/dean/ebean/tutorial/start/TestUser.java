package org.dean.ebean.tutorial.start;

import com.avaje.ebean.EbeanServer;
import org.dean.ebean.tutorial.model.User;
import org.dean.ebean.tutorial.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestUser {

    static ApplicationContext context;

    public static void main(String[] args) {
        context =  new ClassPathXmlApplicationContext("classpath:applicationContext-*.xml");
        UserService service = (UserService) context.getBean("userService");
        service.updateUser();
//        EbeanServer server = (EbeanServer) context.getBean("ebeanServer");
//        List list = server.find(User.class).findList();
    }
}
