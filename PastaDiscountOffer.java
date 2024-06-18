public class PastaDiscountOffer implements PricingModel {

    @Override
    public Cart getUpdatedCart(Cart cart, ItemPriceMap itemPriceMap){
        // Implementing the offer Buy 1 hershey get 1 free
       
       Double currentPastaQuantity = cart.getItemQuantity("pasta");
       
       Double discountedPrice = (currentPastaQuantity % 3.0)*itemPriceMap.getItemPrice("pasta");

       // Cost of 1 pasta = x, of 2 = 2x, of 3 pastas = 2x+x/2 = 2.5x, by this logic, discounted cost of each pasta = (2.5/3)(Orignal cost)
       discountedPrice +=  (cart.getItemQuantity("pasta") - (currentPastaQuantity % 3.0))*(2.5/3.0)*itemPriceMap.getItemPrice("pasta");

       //adjusted quantity of pasta in the cart
       Double adjustedQuantity = discountedPrice/itemPriceMap.getItemPrice("pasta");

       Cart newUpdatedCart = new Cart();
       for(String item: cart.getItemList()){
        newUpdatedCart.addItem(item);
       }
       newUpdatedCart.updateItem("pasta", adjustedQuantity);

       return newUpdatedCart;

    }  
    
} 