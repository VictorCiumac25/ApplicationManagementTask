package model;

public class User {
    private String firstName;
    private String lastName;
    private Status status;
    private long timestamp;
    private int age;
    private String email;

    public User(String firstName, String lastName, Status status, long timestamp, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.timestamp = timestamp;
        this.age = age;
        this.email = email;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "model.User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public long getTimestamp() {
        return timestamp;
    }
}

