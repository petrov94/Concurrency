package com.christmas;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Workshop workshop = new Workshop();
        Santa santa = new Santa(workshop);
        santa.setPriority(10);
        santa.start();
        Kid[] kids = new Kid[10];

        for (int i = 0; i < 10; i++) {
            kids[i] = new Kid(workshop);
            kids[i].start();
        }
        Thread.sleep(90000);
        workshop.isChristmasTime = true;

        for (int i = 0; i < 10; i++) {
            kids[i].join();
        }
        santa.join();
        System.out.println("Puaznuvame koledaaaaaaaaaaaaa.");
        System.out.println(workshop.getWishCount() + "  Broi");

    }
}
