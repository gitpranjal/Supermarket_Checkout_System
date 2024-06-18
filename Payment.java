import java.util.HashMap;

public class Payment {
    public Payment(){

    }

    public void pay(HashMap<String, Double>check){

        System.out.println("Patment done");
        Utilities.prettyPrintMap(check, "Item", "Amount Payed");

    }

}
