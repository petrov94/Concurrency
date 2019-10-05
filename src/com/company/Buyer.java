package com.company;

import javax.swing.plaf.TableHeaderUI;
import java.util.Random;

public class Buyer extends Thread {

    private static Shop shop;

    private Random rand = new Random();

    public Buyer(String name, Shop shop) {
        super(name);
        Buyer.shop = shop;
    }


    public void run() {
        while (true) {
            byte fruit = (byte) (rand.nextInt(shop.getProducts().size()));
            try {
                shop.buy(shop.getProducts().get(fruit),rand.nextInt(3)+1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
