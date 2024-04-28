package us.bitcash.waybit.backend;

public class Customer {

    private String displayName;
    private CustomerCredentials credentials;

    public Customer(CustomerCredentials credentials) {
        this.displayName = null;
        this.credentials = credentials;
    }

    public CustomerCredentials getCredentials() {
        return new CustomerCredentials(this.credentials);
    }

    static class CustomerCredentials {

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
