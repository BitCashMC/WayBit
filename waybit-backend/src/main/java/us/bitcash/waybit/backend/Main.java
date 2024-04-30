package us.bitcash.waybit.backend;

public class Main {

    public static void main(String[] args) {
        Session test = SessionService.createSession();

        SessionService.attemptRegistration(test,new Customer.CustomerCredentials(
                "bitcashmc@gmail.com",
                "1234567"
        ));

        SessionService.attemptLogin(test,new Customer.CustomerCredentials(
                "bitcashmc@gmail.com",
                "1234567"
        ));
    }


}
