package main;

import java.util.ArrayList;
import java.util.ListIterator;

public class ShoppingCart {

    ArrayList<Item> item;
    double totalAmount;
    double payableAmount;
    double discount;
    double tax;
    String coupon;

    ShoppingCart() {
        this.item = new ArrayList<Item>();
        this.totalAmount = 0;
        this.payableAmount = 0;
        this.discount = 0;
        this.tax = 0;
        this.coupon = "";
    }

    public void addToCart(Item item){
        this.item.add(item);
    }
    public void showCart(){
        ListIterator<Item> iterator = item.listIterator();
        while (iterator.hasNext()){
            Item item1 = iterator.next();
            System.out.println(item1);
        }
//        System.out.println("Show Cart" + item);
    }

    public void removeFromCart(Item i){

        ListIterator<Item> iterator1 = item.listIterator();
        while (iterator1.hasNext()){
            Item item2 = iterator1.next();
            if (item2.getProductName() == i.getProductName()){
                this.item.remove(i);
                break;
            }
        }
//        System.out.println("Item removed from cart" + item);

    }

    public double getTotalAmount() {
        ListIterator<Item> iterator2 = item.listIterator();
        this.totalAmount = 0;
        while (iterator2.hasNext()){
            Item item3 = iterator2.next();
            this.totalAmount = this.totalAmount + (item3.getQuantity() * item3.getUnitPrice());
        }
        return this.totalAmount;
    }

    public void applyCoupon(String coupon){
        this.coupon = coupon;
        if (this.coupon.equals("IND10")){
            this.discount = this.totalAmount * 0.10;
            this.totalAmount = this.totalAmount - this.discount;
//            System.out.println("Discount applied: " + this.discount);
        } else {
            this.totalAmount = this.totalAmount;
        }
//        System.out.println("Total Amount after Discount 10%: "+ this.totalAmount);
    }

    public double getPayableAmount() {
        this.payableAmount = 0;
        this.tax = this.totalAmount * 0.14;
        this.payableAmount = this.totalAmount + this.tax;
        return this.payableAmount;
    }

    public void printInvoice(){
        ListIterator<Item> iterator3 = item.listIterator();
        System.out.println("Name\t Quantity\t Price\t Total");
        while (iterator3.hasNext()){
            Item item4 = iterator3.next();
            System.out.println(String.format("%-5s",item4.getProductName())+"\t\t"+item4.getQuantity()+"\t\t"+item4.getUnitPrice()+"\t\t"+(item4.getQuantity()* item4.getUnitPrice()));
        }
        System.out.println("\t\t\t Total Amount: "+ this.getTotalAmount());
        this.applyCoupon(this.coupon);
        System.out.println("\t\t\t Discount: "+ this.discount);
        this.getPayableAmount();
        System.out.println("\t\t\t Tax:"+ String.format("%.2f",this.tax));
        System.out.println("\t\t\t Total:"+ this.getPayableAmount());

    }
}
