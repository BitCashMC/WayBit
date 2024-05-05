package us.bitcash.waybit.backend;

public class Main {

    public static void main(String[] args) {

        Session s1 = SessionService.createSession();

        //s1.launch()

        System.out.println(
                SessionService.attemptRegistration(s1,new Customer.CustomerCredentials("bitcash8@mc.gmail","123456"))
        );



    }


}
