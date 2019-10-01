package com.company;

import java.util.Random;

public class Buyer extends Thread {

    private static Shop shop;

    public Buyer(String name, Shop shop) {
        super(name);
        Buyer.shop = shop;
    }


    public void run() {
        while (true) {
            shop.buy();
        }
    }


}
