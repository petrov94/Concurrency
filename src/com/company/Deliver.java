package com.company;

class Deliver extends Thread {

    public static final byte DELIVERY_AMOUNT = 20;

    private static Shop shop;

    public Deliver(String name, Shop shop){
        super(name);
        Deliver.shop = shop;
    }


   public void run(){
        while(true) {
            shop.deliver();
        }
   }
}