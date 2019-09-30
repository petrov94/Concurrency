package com.company;

class Deliver extends Thread {

    private final byte amount = 20;

    private static Shop shop;

    private String name;

    public Deliver(String name, Shop shop){
        this.name = name;
        Deliver.shop = shop;
    }

    public synchronized void deliverBananas(){
        shop.banan+=amount;
    }

    public synchronized void deliverApples(){
        shop.apple+=amount;
    }

    public synchronized void deliverOranges(){
        shop.orange+=amount;
    }

   public void run(){
        while(true) {
            if (shop.apple <= Shop.MIN_QUANTITY && (shop.apple + amount) < Shop.MAX_QUANTITY) {
                System.out.println("Deliver" + this.name + " brought 20 apples.");
                deliverApples();
            }
            if (shop.banan <= Shop.MIN_QUANTITY && (shop.banan + amount) < Shop.MAX_QUANTITY) {
                System.out.println("Deliver" + this.name + " brought 20 bananas.");
                deliverBananas();
            }
            if (shop.orange <= Shop.MIN_QUANTITY && (shop.orange + amount) < Shop.MAX_QUANTITY) {
                System.out.println("Deliver" + this.name + " brought 20 oranges.");
                deliverOranges();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
   }
}