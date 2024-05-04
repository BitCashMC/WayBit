package us.bitcash.waybit.backend;

public class Main {

    public static void main(String[] args) {

        Session s1 = SessionService.createSession();

        //s1.launch()



        Status regStatus = SessionService.attemptRegistration(s1,new Customer.CustomerCredentials(
                "123@org.com",
                "123456"
        ));

        System.out.println(regStatus);

        Status state = SessionService.attemptLogin(s1,new Customer.CustomerCredentials("13@org.com","12345"));
        System.out.println(state.toString());


    }


}
