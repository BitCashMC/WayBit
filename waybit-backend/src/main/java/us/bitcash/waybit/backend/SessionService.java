package us.bitcash.waybit.backend;

public class SessionService {

    public static Session createSession() {
        return new Session();
    }

    public static Status attemptLogin(Session session, Customer.CustomerCredentials credentials) {

        if (!CustomerFileManager.queryAccountFromFileSystem(credentials.getEmailAddress())) return Status.NOT_FOUND;

        Customer loaded_customer = CustomerFileManager.loadAccountFromFileSystem(credentials.getEmailAddress());

        if (credentials.getPassword().equals(loaded_customer.getCredentials().getPassword())) {
            session.setCustomer(loaded_customer);

            return Status.SUCCESS;
        }

        return Status.INCORRECT;
    }

    public static Status attemptRegistration(Session session, Customer.CustomerCredentials credentials) {

        Customer cust = new Customer(credentials);

        if (CustomerFileManager.queryAccountFromFileSystem(credentials.getEmailAddress())) return Status.FAILURE;

        CustomerFileManager.saveAccountToFileSystem(cust);
        session.setCustomer(cust);
        return Status.SUCCESS;
    }

}
