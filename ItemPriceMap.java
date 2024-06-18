import java.util.ArrayList;
import java.util.HashMap;

public class ItemPriceMap {
    
    HashMap<String, Double>priceMap;
    ArrayList<String>itemList;

    public ItemPriceMap(HashMap<String, Double>priceMap){
        this.priceMap = priceMap;
        this.itemList = new ArrayList<>(priceMap.keySet());
    }

    public ItemPriceMap(){
        this.priceMap = new HashMap<>();
        this.itemList = new ArrayList<>();
    }

    public Double getItemPrice(String item){

        return priceMap.get(item);

    }

    public void addItem(String item, Double value){
        this.priceMap.put(item, value);
        this.itemList.add(item);
    }

    public void updateItem(String item, Double value){
        this.priceMap.put(item, value);
    }

    public ArrayList<String>getItemList(){
        return this.itemList;
    }
}
