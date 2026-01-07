package service;

import java.util.ArrayList;
import java.util.List;
import model.*;

/**
 *service class responsible for user related operations.
 *This class manages registration and login of all user types
 *(student and homeowner) and stores them in a list.
 */
public class UserService {
    //stores all registered users in the system
    private List<User> users = new ArrayList<>();

    //registers a new student
    public Student registerStudent(String name, String email, String password) {
        Student s = new Student(name, email, password);
        users.add(s);
        return s;
    }
    
    //registers a new homeowner
    public Homeowner registerHomeowner(String name, String email, String password) {
        Homeowner h = new Homeowner(name, email, password);
        users.add(h);
        return h;
    }

    //authenticates using their email and password
    public User login(String email, String password) {
        for (User u : users) {
            if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }
}
