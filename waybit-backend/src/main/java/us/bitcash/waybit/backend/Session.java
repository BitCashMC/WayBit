package us.bitcash.waybit.backend;

import java.io.*;
import java.util.UUID;
public class Session {

    private Customer customer = null;
    private String sessionID = null;
    private boolean isLoggedIn;

    public void setLoggedIn(boolean status) {
        this.isLoggedIn = status;
    }
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.isLoggedIn = true;
        this.customer = customer;
    }

    /*
    The class where aspects related to initializing and retrieving session details are done
     */

     Session() {
        this.customer = null;
        this.sessionID = UUID.randomUUID().toString();
        this.isLoggedIn = false;
    }

    public void activate() {

    }



}
