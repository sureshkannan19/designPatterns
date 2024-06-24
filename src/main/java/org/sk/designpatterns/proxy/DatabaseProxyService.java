package org.sk.designpatterns.proxy;

import java.util.HashMap;
import java.util.Map;

public class DatabaseProxyService implements Database {

    private final Map<String, String> allowedUsers = new HashMap<>();

    {
        allowedUsers.put("Suresh", "Suresh");
        allowedUsers.put("Bruce", "Bruce");
        allowedUsers.put("Barry", "Barry");
    }

    private final Database db;

    public DatabaseProxyService() {
        this.db = new DatabaseService();
    }

    @Override
    public void connect(String userName, String password) {
        System.out.println("Connecting to database...");
        if (allowedUsers.containsKey(userName) && allowedUsers.get(userName).equals(password)) {
            db.connect(userName, password);
            System.out.println("Connected successfully.");
        } else {
            System.out.println("Not authenticated to connect database.");
        }
    }
}
