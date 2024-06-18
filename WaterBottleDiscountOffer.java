public class WaterBottleDiscountOffer implements PricingModel {

    @Override
    public Cart getUpdatedCart(Cart cart, ItemPriceMap itemPriceMap){
        // Implementing the offer Buy 1 hershey get 1 free
       
       Double currentWaterBottleQuantity = cart.getItemQuantity("water_bottle");
       
       Double discountedPrice = (currentWaterBottleQuantity % 3.0)*itemPriceMap.getItemPrice("water_bottle");

       discountedPrice +=  (cart.getItemQuantity("water_bottle") - (currentWaterBottleQuantity % 3.0))*(4.0/3.0);

       Double adjustedQuantity = discountedPrice/itemPriceMap.getItemPrice("water_bottle");


       Cart newUpdatedCart = new Cart();
       for(String item: cart.getItemList()){
        newUpdatedCart.addItem(item);
       }
       newUpdatedCart.updateItem("water_bottle", adjustedQuantity);

       return newUpdatedCart;

    }  
    
}
