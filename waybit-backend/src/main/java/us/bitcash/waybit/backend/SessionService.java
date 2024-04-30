package us.bitcash.waybit.backend;

import java.io.*;
import java.util.Optional;

public class SessionService {

    public static Session createSession() {
        return new Session();
    }

    public static boolean attemptLogin(Session session, Customer.CustomerCredentials credentials) {

        Customer loaded_customer = loadAccountFromFileSystem(createCustomerFile(credentials.getEmailAddress()).get());

        if (credentials.getPassword().equals(loaded_customer.getCredentials().getPassword())) {
            session.setCustomer(loaded_customer);

            session.setLoggedIn(true);
            return true;
        }

        return false;
    }

    public static boolean attemptRegistration(Session session, Customer.CustomerCredentials credentials) {

        File custFile = createCustomerFile(credentials.getEmailAddress()).get();

        Customer newCustomer = new Customer(credentials);

        saveAccountToFileSystem(newCustomer);
        session.setCustomer(newCustomer);

        session.setLoggedIn(true);
        return true;
    }

    private static Customer loadAccountFromFileSystem(File custFile) {
        Customer loaded_customer = null;

        try (FileInputStream fileIn = new FileInputStream(custFile);
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            loaded_customer = (Customer) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error whilst trying to retrieve account at " + custFile.getPath());
        }
        return loaded_customer;
    }

    private static void saveAccountToFileSystem(Customer c) {
        File cFile = createCustomerFile(c.getCredentials().getEmailAddress()).get();

        try {
            if (!cFile.exists()) cFile.createNewFile();
        } catch (IOException e) {}

        try (FileOutputStream fileOut = new FileOutputStream(cFile);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(c);
        } catch (IOException e) {}
    }

    public static Optional<File> createCustomerFile(String email) {
        String path = SessionService.class.getResource("accounts/").getPath();
        return path != null ? Optional.of(new File(path + email + ".ser")) : Optional.empty();
    }

}
