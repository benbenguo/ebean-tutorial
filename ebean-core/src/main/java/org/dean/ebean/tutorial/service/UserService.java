package org.dean.ebean.tutorial.service;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.annotation.Transactional;
import org.dean.ebean.tutorial.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    EbeanServer ebeanServer;

    @Transactional
    public void updateUser() {
        User user1 = ebeanServer.find(User.class).where().eq("id", "111").findUnique();
        User user2 = ebeanServer.find(User.class).where().eq("id", "222").findUnique();

        user1.setLoginName("dean2");
        user1.setUpdBy(user2);
        ebeanServer.update(user1);
    }
}
