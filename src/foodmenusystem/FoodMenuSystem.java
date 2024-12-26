/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package foodmenusystem;


import java.util.*;
import java.util.Scanner;

/**
 *
 * @author asish
 */

class Menu{
    private int item_no;
    private String item_name;
    private String item_description;
    private String item_drinks;
    private float item_price;
    
    Menu(int item_no, String item_name, String item_description, String item_drinks, float item_price){
        
        this.item_no = item_no;
        this.item_name = item_name;
        this.item_description = item_description;
        this.item_drinks = item_drinks;
        this.item_price = item_price;
    
    }
    public int getItem_no(){
    return item_no;
    }
    public String getItem_name(){
    return item_name;
    }
    public String getItem_description(){
    return item_description;
    }
    public String getItem_drinks(){
    return item_drinks;
    }
    public float getItem_price(){
    return item_price;
    }
    
    
    @Override
    public String toString(){
        return "ItemNo:"+item_no+"\nItemName:"
                +item_name+"\nItemType:"+item_description+"\nDrinks:"
                +item_drinks+"\nPrice:$"+String.format("%.2f", item_price)+"\n";
    
    }
    
    
}




public class FoodMenuSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        
        
        
        
        // TODO code application logic here
        System.out.println("Welcome To Our Food Menu System");
        
        List<Menu> c = new ArrayList<Menu>();
        
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);

        
        int ch;
        do{
            System.out.println("\n1 For Insert MenuItem");
            System.out.println("2 For Displaying MenuList");
            System.out.println("3 For Searching Item from MenuList");
            System.out.println("4 For Deleting Ietm from MenuList");
            System.out.println("5 For Updating Details for MenuItem");
            System.out.println("6 For Sorting Menu");
            System.out.println("7 For Filtering Menu");
            System.out.println("0 For Exiting From The System");
            System.out.println("\nEnter Your Choice : ");
            
           ch = s.nextInt();

           switch(ch){
               case 1:
                   System.out.println("Enter Item No : ");
                   int ino= s.nextInt();
                   System.out.println("Enter Item Name : ");
                   String iname= s1.nextLine();
                   System.out.println("Enter Item Type : ");
                   String idescription= s1.nextLine();
                   System.out.println("Enter Item's Drink : ");
                   String idrink= s1.nextLine();
                   System.out.println("Enter Item Price : ");
                   float iprice= s.nextFloat();
                                     
                   c.add(new Menu(ino, iname, idescription, idrink, iprice));
                   
                   System.out.println("\nItem has been added in the menuList successfully!");
                                    
                   break;
                   
               case 2:
                   System.out.println("***********************************");
                   System.out.println("Manu List: \n");
                   Iterator<Menu> i = c.iterator();
                   while(i.hasNext()){
                       Menu m = i.next();
                       System.out.println(m);
                   }
                   System.out.println("\n***********************************");
                   break;
                   
               case 3:
                   boolean found = false;
                   System.out.println("Enter Item Number To Search : ");
                   
                   ino = s.nextInt();
                   
                   System.out.println("***********************************\n");
                   i = c.iterator();
                   while(i.hasNext()){
                       Menu m = i.next();
                       if(m.getItem_no() == ino){
                        System.out.println(m);
                        found = true;
                       } 
                   }
                  
                   if(!found){
                   System.out.println("Item's Record has not Founded in the List");
                   }
                   System.out.println("\n***********************************");
                   break;
               case 4:
                   found = false;
                   System.out.println("Enter Item Number To Delete : ");                  
                   ino = s.nextInt();                  
                   System.out.println("***********************************\n");
                   i = c.iterator();
                   while(i.hasNext()){
                       Menu m = i.next();
                       if(m.getItem_no() == ino){
                        i.remove();
                        found = true;
                       } 
                   }                 
                   if(!found){
                   System.out.println("Item's Record has not Found in the List");
                   }else {
                   System.out.println("Item has been Deleted Successfully ...........!");
                   }
                   System.out.println("\n***********************************");
                   break;
               case 5:             
                   found = false;
                   System.out.println("Enter Item Number Want to be Updated : ");                  
                   ino = s.nextInt();                  
                   System.out.println("***********************************\n");
                   ListIterator<Menu>li = c.listIterator();
                   while(li.hasNext()){
                       Menu m = li.next();
                       if(m.getItem_no() == ino){
                        System.out.println("Enter Item's New Name : ");
                        iname = s1.nextLine();                       
                        System.out.println("Enter Item's New Description : ");
                        idescription = s1.nextLine();
                        System.out.println("Enter Item's New Drink : ");
                        idrink = s1.nextLine();
                        System.out.println("Enter Item's New Price : ");
                        iprice = s.nextFloat();
                        li.set(new Menu(ino, iname, idescription, idrink, iprice));
                        found = true;
                       } 
                   }                 
                   if(!found){
                   System.out.println("Item's Record has not Found in the List");
                   }else {
                   System.out.println("Item has been Updated Successfully ...........!");
                   }
                   System.out.println("\n***********************************");
                   break;
               case 6:
                   System.out.println("***********************************\n");
                   System.out.println("Choose Sorting Option:\n"
                           + "1 For Sorting by Item Number (Low-High)\n"
                           + "2 For Sorting by Item Name (A-Z)\n");
                   System.out.println("***********************************\n");
                   System.out.println("Enter Your Sorting Option: ");
                   
                   int sCh = s.nextInt();
                   
                   if (sCh == 1){
                   Collections.sort(c, Comparator.comparingInt(Menu::getItem_no));
                   System.out.println("Menu Items Sorted by Item No (Lowest to Highest): \n");
                   }else if (sCh==2){                
                   Collections.sort(c, Comparator.comparing(Menu::getItem_name));
                   System.out.println("Menu Items Sorted by Item Name (A to Z): \n");                  
                   }else{
                   System.out.println("Sorting Option is Invalid!...Return to the Menu System");
                   }
                   
                   
                   
                   c.forEach(System.out::println);
                   System.out.println("\n***********************************");                  
                   break;
               case 7:
                   found=false;
                   System.out.println("***********************************\n");
                   System.out.println("Enter ItemType for Filtering : ");                
                   String filterType = s1.nextLine();                                     
                   System.out.println("ItemType: "+filterType+"\n");
                   for (Menu m : c){
                       if(m.getItem_description().equalsIgnoreCase(filterType)){
                       System.out.println(m);
                       found=true;
                       }
                   }
                   if(!found){
                   System.out.println("Given ItemType is not Matching......Sorry!");
                   }
                   System.out.println("\n***********************************");
                   break;
                   
               case 0:
                   System.out.println("Exiting The Menu System.......Goodbye!");                    
                   break;
               default:
                   System.out.println("Invalid Input, Please Try Again Later.");
                                                    
           }   
        }while(ch!=0);
      
    }
    
}


