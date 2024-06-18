import java.util.Scanner;

public class Shop {

    //Main function where execution happens, shopper gets to checkout
    public static void main(String[] args){

        //Creating an item catalogue for price of each item
        ItemPriceMap itemPriceMap = new ItemPriceMap();
        itemPriceMap.addItem("hershey", 4.5);
        itemPriceMap.addItem("pasta", 6.5);
        itemPriceMap.addItem("water_bottle", 1.5);
        itemPriceMap.addItem("milk", 4.25);

        //Initializing the Discount Offers
        PricingModel hersheyDisountModel = new HersheyDiscountOffer();
        PricingModel waterBottleDiscountModel = new WaterBottleDiscountOffer();
        PricingModel pastaDiscountOffer = new PastaDiscountOffer();


        //Creating a checkout object representing the current shopping session by the customer
        Checkout checkout = new Checkout(itemPriceMap);

        //adding the discount offer
        checkout.addDiscount(hersheyDisountModel);
        checkout.addDiscount(waterBottleDiscountModel);
        checkout.addDiscount(pastaDiscountOffer);


        System.out.println("Scan the items: Choose items, Items can be chosen multiple times. Exnter 'done' when done scanning");
        System.out.println(itemPriceMap.getItemList());

        String userInput = "";
        Scanner s  = new Scanner(System.in);
        userInput = s.nextLine();

        while(!userInput.equals("done")){

            checkout.scan(userInput);
            //viewing the cart and receipt after every addion
            checkout.vewCart();
            checkout.printReceipt();
            System.out.println("Add More Item or type 'done' if done adding");
            userInput = s.nextLine();
            System.out.println();
        }

        //Making payment
        checkout.makePayment();

        s.close();
     
        


    }
}
