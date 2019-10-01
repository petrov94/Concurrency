package com.company;

import java.util.Random;

public class Shop {

    private byte orange;

    private byte banana;

    private byte apple;

    public static final byte MIN_QUANTITY=5;

    private Random rand = new Random();

    public static final byte MAX_QUANTITY=100;

    public Shop(){
        this.orange=13;
        this.banana =12;
        this.apple=17;
    }

    public void buy(){
        byte fruit = (byte) (rand.nextInt((3 - 1) + 1) + 1);
        switch (fruit) {
            case 1:
                byte quantityOrange = (byte) (rand.nextInt((3 - 1) + 1) + 1);
                if (this.orange > quantityOrange) {
                    synchronized (this) {
                        this.orange -= quantityOrange;
                        System.out.println("Buyer " + Thread.currentThread().getName() + " bought " + quantityOrange + " oranges.");
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
                if (this.banana > quantityBanana) {
                    synchronized (this) {
                        this.banana -= quantityBanana;
                        System.out.println("Buyer " + Thread.currentThread().getName() + " bought " + quantityBanana + " bananas.");
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
                if (this.apple > quantityApple) {
                    synchronized (this) {
                        this.apple -= quantityApple;
                        System.out.println("Buyer " + Thread.currentThread().getName() + " bought " + quantityApple + " apples.");
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

    public synchronized void deliverBananas(){
        this.banana +=Deliver.DELIVERY_AMOUNT;
    }

    public synchronized void deliverApples(){
        this.apple+=Deliver.DELIVERY_AMOUNT;
    }

    public synchronized void deliverOranges(){
        this.orange+=Deliver.DELIVERY_AMOUNT;
    }

    public void deliver(){
        if (this.apple <= Shop.MIN_QUANTITY && (this.apple + Deliver.DELIVERY_AMOUNT) < Shop.MAX_QUANTITY) {
            System.out.println("Deliver " + Thread.currentThread().getName() + " brought 20 apples.");
            deliverApples();
        }
        if (this.banana <= Shop.MIN_QUANTITY && (this.banana + Deliver.DELIVERY_AMOUNT) < Shop.MAX_QUANTITY) {
            System.out.println("Deliver " + Thread.currentThread().getName() + " brought 20 bananas.");
            deliverBananas();
        }
        if (this.orange <= Shop.MIN_QUANTITY && (this.orange + Deliver.DELIVERY_AMOUNT) < Shop.MAX_QUANTITY) {
            System.out.println("Deliver " + Thread.currentThread().getName() + " brought 20 oranges.");
            deliverOranges();
        }
    }
}
