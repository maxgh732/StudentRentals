package model;

//abstarct class which represents a user in the system
public abstract class User {
    private String name;
    private String email;
    private String password;

    //creates a user
    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
}
