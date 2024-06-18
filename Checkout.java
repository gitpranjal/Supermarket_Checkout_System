import java.util.ArrayList;
import java.util.HashMap;

public class Checkout {

    Cart cart;
    Cart discountedCart;
    ItemPriceMap itemPriceMap;
    ArrayList<PricingModel>discounts;
    Double totalAmount;
    Double discountedAmount;
    HashMap<String, Double>receipt;
    HashMap<String, Double>discountedReceipt;
    ItemRecommender recommender;
    Payment paymentHandler;

    public Checkout(ItemPriceMap itemPriceMap){

        this.itemPriceMap = itemPriceMap;
        this.cart = new Cart();
        this.discounts = new ArrayList<>();
        this.receipt = new HashMap<>();
        this.discountedReceipt = new HashMap<>();
        this.totalAmount = 0.0;
        this.recommender = new ItemRecommender();
        this.paymentHandler = new Payment();


    }

    public void addDiscount(PricingModel discount){
        this.discounts.add(discount);
        this.updateTotalAmaount();
    }

    public void scan(String item){
        this.cart.addItem(item);
        this.updateTotalAmaount();
        this.recommender.recommendItems(cart);
    }
    
    public void makePayment(){
        this.paymentHandler.pay(discountedReceipt);
    }

    public Double getTotalAmaount(){
        return this.totalAmount;
    }

    public void updateTotalAmaount(){

        for(PricingModel discount: discounts){
            this.discountedCart = discount.getUpdatedCart(this.cart, this.itemPriceMap);
        }
        this.totalAmount = 0.0;
        this.discountedAmount = 0.0;
        ArrayList<String>itemList = cart.getItemList();
        for(String item: itemList){
            
            this.totalAmount += itemPriceMap.getItemPrice(item)*cart.getItemQuantity(item);
            this.receipt.put(item, itemPriceMap.getItemPrice(item)*cart.getItemQuantity(item));
            this.receipt.put("Total Amount", totalAmount);

            this.discountedAmount += itemPriceMap.getItemPrice(item)*discountedCart.getItemQuantity(item);
            this.discountedReceipt.put(item, itemPriceMap.getItemPrice(item)*discountedCart.getItemQuantity(item));
            this.discountedReceipt.put("Total Amount", discountedAmount);
        }
        
    }

    public void printReceipt(){
        System.out.println("############################## Item Cost before discount ########################");
        Utilities.prettyPrintMap(this.receipt, "Item Name", "Item total");


        System.out.println("############################## Items cost after discount ########################");
        Utilities.prettyPrintMap(discountedReceipt, "Item Name", "Item Total");
    }

    public void vewCart(){
        System.out.println("############################## Cart Status ########################");
        Utilities.prettyPrintMap(cart.getCart(), "Item Name", "Quantity");
    }
    
}