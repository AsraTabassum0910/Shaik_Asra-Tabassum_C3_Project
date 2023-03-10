import java.awt.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();
    private List<Item> selectedItems = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }
    public Restaurant(){

    }

    public boolean isRestaurantOpen() {
        int val1 = getCurrentTime().compareTo(this.openingTime);
        int val2 =  getCurrentTime().compareTo(this.closingTime);
        if(val1 > 0 && val2 <0){
            return true;
        }
        return false;
    }


    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {
        //List<Item> m1 = new ArrayList<Item>();
        //for(Item item: menu) {
          // System.out.println(item.toString());
        //}
        return menu;
    }

    private Item findItemByName(String itemName){
        for(Item item: menu) {
            if(item.getName().equals(itemName))
                return item;
        }
        return null;
    }
    public int findTotalPrice(){
        int totalPrice = 0;
        for(Item item: selectedItems) {
            totalPrice = totalPrice + item.getPrice();
        }
        return totalPrice;
    }

    public void addToMenu(String name, int price) {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    public void addItemListToMenu(Item newItem) {
        //Item newItem = new Item(name,price);
        selectedItems.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }
    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }

    public String getName() {
        return name;
    }

}
