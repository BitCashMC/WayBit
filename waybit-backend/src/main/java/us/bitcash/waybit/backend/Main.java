package us.bitcash.waybit.backend;

public class Main {

    public static void main(String[] args) {
        Session test = SessionService.createSession();

        SessionService.attemptLogin(test,new Customer.CustomerCredentials(
                "bitcashmc@gmail.com",
                "1234567"
        ));
    }


}
