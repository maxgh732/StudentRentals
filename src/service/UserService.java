package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

public class UserService {
    private List<User> users = new ArrayList<>();

    public Student registerStudent(String name, String email, String password) {
        Student s = new Student(name, email, password);
        users.add(s);
        return s;
    }

    public Homeowner registerHomeowner(String name, String email, String password) {
        Homeowner h = new Homeowner(name, email, password);
        users.add(h);
        return h;
    }

    public User login(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
