import java.util.ArrayList;
import java.util.HashMap;

public class Cart{
    
    HashMap<String, Double>itemQuantityMap;
    ArrayList<String>itemList;

    public Cart(){
        this.itemQuantityMap = new HashMap<>();
        this.itemList = new ArrayList<>();
    }

    public Cart(HashMap<String, Double>itemQuantityMap){
        this.itemQuantityMap = itemQuantityMap;
        this.itemList = new ArrayList<>(itemQuantityMap.keySet());
    }

    public void addItem(String item){
        if(itemQuantityMap.containsKey(item))
            itemQuantityMap.put(item, itemQuantityMap.get(item)+1);
        else
            {
                itemQuantityMap.put(item, 1.0);
                itemList.add(item);
            }
        
    }

    public void removeItem(String item){
        if(!itemQuantityMap.containsKey(item) || itemQuantityMap.get(item) == 0)
            return;
        itemQuantityMap.put(item, itemQuantityMap.get(item) - 1);
        
        if(this.itemQuantityMap.get(item) == 0)
            itemList.remove(item);
    } 

    public Double getItemQuantity(String item){
        if(!itemQuantityMap.containsKey(item))
            return 0.0;

        return itemQuantityMap.get(item);
    }

    public void updateItem(String item, Double quantity){
        this.itemQuantityMap.put(item, quantity);

        if(this.itemQuantityMap.get(item) == 0)
            itemList.remove(item);
    }

    public ArrayList<String>getItemList(){
        return this.itemList;
    }

    public HashMap<String, Double>getCart(){
        return this.itemQuantityMap;
    }

  
}
