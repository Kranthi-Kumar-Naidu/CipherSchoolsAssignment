import java.util.*;
import java.util.Map.*;
public class GrocceryManagement{
    public class item{
        String name;
        float price;
        float quantity;
        item(String name, float price, float quantity){
            this.name=name;
            this.price=price;
            this.quantity=quantity;
        }
        public void setPrice(float price){
            this.price=price;
        }
        public void setQuantity(float quantity){
            this.quantity=quantity;
        }
    }
    public static float addProduct(HashMap<String, Float> priceMap ,HashMap<String, Float> quantityMap,String name, float price, String quantityS ,float budget){
        String[] arrOfStr = quantityS.split(" ");
        float quantity=Float.parseFloat(arrOfStr[0]);
        if(!priceMap.containsKey(name)){
            priceMap.put(name,price);
            quantityMap.put(name,quantity);
        }else{
            float temp = budget+ priceMap.get(name);
            priceMap.put(name,price);
            quantityMap.put(name,quantity);
            System.out.println("Amount left : "+(temp-price));
            return (temp-price);
        }
        System.out.println("Amount left : "+(budget-price));
        return (budget-price);
    }
     public static void displayGroceryList(HashMap<String, Float> priceMap ,HashMap<String, Float> quantityMap, float budget){
         System.out.println("Amount left can buy you : ");
         for (Map.Entry mapElement : priceMap.entrySet()) { 
            String productName = (String)mapElement.getKey(); 
            float priceOfProduct = ((float)mapElement.getValue()); 
            if(priceOfProduct==budget)
                System.out.println(productName); 
        } 
         System.out.println("\nGROCERY LIST is:\nProduct name   Quantity    Price");
         if(!priceMap.isEmpty()) {
         Iterator it1 = priceMap.entrySet().iterator();
         Iterator it2 = quantityMap.entrySet().iterator();
         while(it1.hasNext()) {
            Map.Entry obj1 = (Entry)it1.next();
            Map.Entry obj2 = (Entry)it2.next();
            System.out.format("%-10s     %4s kg   %7s\n",obj1.getKey(), obj2.getValue(), obj1.getValue());
         }
      }
     }
    public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      HashMap<String, Float> priceMap = new HashMap<String, Float>();
      HashMap<String, Float> quantityMap = new HashMap<String, Float>();
      int input=0;
      float budget;
      System.out.print("Enter Your budget : ");
      budget=sc.nextFloat();
      while(input!=2){
        System.out.print("\n1.Add an item\n2.Exit\nEnter your choice : ");  
        input=sc.nextInt();
        String student1 = sc.nextLine();
        switch(input){
            case 1: String name;
                    float price;
                    String quantity;
                    System.out.println("Enter product : ");
                    name=sc.nextLine();
                    System.out.println("Enter quantity : ");
                    quantity=sc.nextLine();
                    System.out.println("Enter Price : ");
                    price=sc.nextFloat();
                    if(budget<price){
                        System.out.println("\nCan't Buy the product ###( because budget left is "+budget+" )");
                    }else{
                        budget=addProduct(priceMap,quantityMap,name,price,quantity,budget);
                    }
                    break;
            case 2: displayGroceryList(priceMap,quantityMap,budget);
                    break;
            default: System.out.println("Invalid input. Try Again.");
        }
      }
    }
}