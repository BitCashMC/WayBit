package us.bitcash.waybit.backend;

import java.io.Serializable;

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String displayName;
    private CustomerCredentials credentials;

    private CustomerFile file = null;

    public Customer(CustomerCredentials credentials) {
        this.displayName = null;
        this.credentials = credentials;
        this.file = new CustomerFile(this);
    }

    public CustomerFile getCustomerFile() {
        return this.file;
    }

    public CustomerCredentials getCredentials() {
        return new CustomerCredentials(this.credentials);
    }

    static class CustomerCredentials implements Serializable {
        private static final long serialVersionUID = 1L;

        public CustomerCredentials(CustomerCredentials cc) {
            this.emailAddress = cc.emailAddress;
            this.password = cc.password;
        }
        public CustomerCredentials(String emailAddress, String password) {
            this.emailAddress = emailAddress;
            this.password = password;
        }

        private String emailAddress;
        private String password;

        public String getEmailAddress() {
            return this.emailAddress;
        }

        public String getPassword() {
            return this.password;
        }

    }
}
