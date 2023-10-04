package main;

public class Invoice {
    public static void main(String[] args) {

        Item i1 = new Item("Pen",2,20);
        Item i2 = new Item("Pencil",2,15);
        Item i3 = new Item("Note",2,10);
        Item i4 = new Item("Bag",1,800);
        Item i5 = new Item("Box",1,30);

//        System.out.println(i1);
//        System.out.println(i2);
//        System.out.println(i3);
//        System.out.println(i4);
//        System.out.println(i5);

        ShoppingCart cart = new ShoppingCart();

        cart.addToCart(i1);
        cart.addToCart(i2);
        cart.addToCart(i3);
        cart.addToCart(i4);
        cart.addToCart(i5);

        cart.showCart();

//        cart.removeFromCart(i2);

//        double totalAmount = cart.getTotalAmount();
//        System.out.println("Total Amount: " + totalAmount);
//
//        cart.applyCoupon("IND10");
//
//        double payableAmount = cart.getPayableAmount();
//        System.out.println("Payable Amount: " + payableAmount);

        cart.applyCoupon("IND50");
        cart.printInvoice();
        cart.addToCart(new Item("Cycle",1,5000));
        cart.applyCoupon("IND10");
        cart.printInvoice();


    }
}
