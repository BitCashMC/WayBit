package us.bitcash.waybit.backend;

import java.util.Optional;

public class SessionService {
    public static Session createSession() {
        Session s = new Session();
        return new Session();
    }

    public static Status attemptLogin(Session session, Customer.CustomerCredentials credentials) {

        String email = credentials.getEmailAddress();
        String password = credentials.getPassword();

        if (!email.matches("^[\\w-]+@(\\w+\\.)+([a-z]+)$")) return Status.FAILURE;

        if (!CustomerFileManager.queryAccountFromFileSystem(email)) return Status.NOT_FOUND;

        Customer loaded_customer;
        Optional<Customer> custOpt = CustomerFileManager.loadAccountFromFileSystem(email);
        if (custOpt.isPresent()) loaded_customer = custOpt.get();
        else return Status.FAILURE;

        if (password.equals(loaded_customer.getCredentials().getPassword())) {
            session.setCustomer(loaded_customer);

            return Status.SUCCESS;
        }

        return Status.INCORRECT;
    }

    public static Status attemptRegistration(Session session, Customer.CustomerCredentials credentials) {

        String email = credentials.getEmailAddress();
        String password = credentials.getPassword();

        Customer cust = new Customer(credentials);

        if (CustomerFileManager.queryAccountFromFileSystem(email))
            return Status.FAILURE;

        if (email.isEmpty() || password.isEmpty())
            return Status.FAILURE;

        if (!email.matches("^[\\w-]+@(\\w+\\.)+([a-z]+)$")) return Status.FAILURE;


        CustomerFileManager.saveAccountToFileSystem(cust);
        session.setCustomer(cust);
        return Status.SUCCESS;
    }

}
