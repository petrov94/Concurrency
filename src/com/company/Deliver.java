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
            try {
                System.out.println("Waiting for a deliver.");
                shop.deliver();
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
   }
}