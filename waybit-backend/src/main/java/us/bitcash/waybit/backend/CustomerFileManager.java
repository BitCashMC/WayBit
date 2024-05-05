package us.bitcash.waybit.backend;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;

public class CustomerFileManager {
    protected static Optional<Customer> loadAccountFromFileSystem(String email) {
        Customer loaded_customer = null;

        try (FileInputStream fileIn = new FileInputStream(getPointerToAccountFile(email));
             ObjectInputStream in = new ObjectInputStream(fileIn)){
            loaded_customer = (Customer) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error whilst trying to retrieve account at " + getPointerToAccountFile(email));
            System.err.println(e);
        }
        return Optional.ofNullable(loaded_customer);
    }

    protected static void saveAccountToFileSystem(Customer c) {

        try (FileOutputStream fileOut = new FileOutputStream(c.getCustomerFile());
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(c);

        } catch (IOException e) {
            System.err.println(e);
        }
    }


    /*
    Helper methods for finding and deserializing a customer object from the system.
     */
    public static String getPathToAccountsDir() {
        return "C:\\Users\\musky\\IdeaProjects\\WaybitUtilities\\Waybit Utilities\\waybit-backend\\src\\accounts_serialized\\";
    }

    public static String getPointerToAccountFile(String email) {
        return getPathToAccountsDir()+email+".ser";
    }
    protected static boolean queryAccountFromFileSystem(String email) {
        return new File(getPointerToAccountFile(email)).exists();
    }
}
