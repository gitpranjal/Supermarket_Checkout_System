public class HersheyDiscountOffer implements PricingModel{

    @Override
    public Cart getUpdatedCart(Cart cart, ItemPriceMap itemPriceMap){
        // Implementing the offer Buy 1 hershey get 1 free
       
       Double currentHersheyQuantity = cart.getItemQuantity("hershey");
       Double newHersheyQuantity = currentHersheyQuantity/2.0;

       Cart newUpdatedCart = new Cart();
       for(String item: cart.getItemList()){
        newUpdatedCart.addItem(item);
       }
     
       newUpdatedCart.updateItem("hershey", newHersheyQuantity);

       return newUpdatedCart;

    }  
    
}
