package com.iapppay.code.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.Test;

public class CommonTest {

    @Test
    public void timezoneDiff() {
        System.out.println(TimeZone.getTimeZone("UTC+3"));
        System.out.println(TimeZone.getTimeZone("UTC+6"));
        System.out.println(TimeZone.getTimeZone("GMT+3"));
        TimeZone.setDefault(TimeZone.getTimeZone("GMT+3"));
        System.out.println(new Date());
    }

    @Test
    public void formatTimestamp() {
        System.out.println(new Date(1440129901163L));
    }

    @Test
    public void compareTo() {
        List<User> users = new ArrayList<User>();
        User user = new User(1, "t1");
        User user2 = new User(10, "t10");
        User user3 = new User(8, "t8");
        User user4 = new User(5, "t5");
        users.add(user);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if (o1.id < o2.id) {
                    return 1;
                } else if (o1.id == o2.id) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });
        for (User u : users) {
            System.out.println(u);
        }
    }
}

class User {
    long id;
    String name;

    public User(long id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }

}