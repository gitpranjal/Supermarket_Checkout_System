public interface PricingModel {
    
    Cart getUpdatedCart(Cart cart, ItemPriceMap itemPriceMap);
    
}