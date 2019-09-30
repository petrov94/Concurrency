package com.company;

import java.util.Random;

public class Buyer extends Thread {

    private String name;

    private static Shop shop;

    private Random rand = new Random();

    public Buyer(String name, Shop shop) {
        this.name = name;
        Buyer.shop = shop;
    }

    public void buy() {
        while (true) {
            byte fruit = (byte) (rand.nextInt((3 - 1) + 1) + 1);
            switch (fruit) {
                case 1:
                    byte quantityOrange = (byte) (rand.nextInt((3 - 1) + 1) + 1);
                    if (shop.orange > quantityOrange) {
                        synchronized (shop) {
                            shop.orange -= quantityOrange;
                            System.out.println("Buyer" + this.name + "bought " + quantityOrange + " oranges.");
                        }
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    byte quantityBanana = (byte) (rand.nextInt((3 - 1) + 1) + 1);
                    if (shop.banan > quantityBanana) {
                        synchronized (shop) {
                            shop.banan -= quantityBanana;
                            System.out.println("Buyer" + this.name + "bought " + quantityBanana + " bananas.");
                        }
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    byte quantityApple = (byte) (rand.nextInt((3 - 1) + 1) + 1);
                    if (shop.apple > quantityApple) {
                        synchronized (shop) {
                            shop.apple -= quantityApple;
                            System.out.println("Buyer" + this.name + "bought " + quantityApple + " apples.");
                        }
                    } else {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
        }
    }

    public void run() {
        buy();
    }


}
