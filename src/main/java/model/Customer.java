package model;

import java.io.Serializable;

public class Customer extends User implements Serializable {
    private int idCustomer;
    private String email;
    private String firstName;
    private String lastname;
    private String phoneNumber;

    public Customer(int idCustomer, String email, String firstName, String lastname, String phoneNumber) {
        this.idCustomer = idCustomer;
        this.email = email;
        this.firstName = firstName;
        this.lastname = lastname;
        this.phoneNumber = phoneNumber;
    }

    public Customer() {
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
