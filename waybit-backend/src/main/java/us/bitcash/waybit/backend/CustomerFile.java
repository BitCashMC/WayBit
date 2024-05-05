package us.bitcash.waybit.backend;

import java.io.File;
import java.io.IOException;

class CustomerFile extends File {
    private Customer customer;
    CustomerFile(Customer c) {
        super(CustomerFileManager.getPointerToAccountFile(c.getCredentials().getEmailAddress()));
//        try {
//            this.createNewFile();
//        } catch (IOException e) {
//            System.err.println("Failure to create file -- \n" + e);;
//        }
    }

    protected Customer getCustomer() {
        return this.customer;
    }

}
