package com.christmas;

import sun.java2d.opengl.WGLSurfaceData;

public class Elf extends Thread {
    private Workshop workshop;
    private int id;
    private int giftCounter = 0;

    public Elf(int id, Workshop workshop) {
        this.id = id;
        this.workshop = workshop;
    }

    /**
     * Gets a wish from the backlog and creates the wanted gift.
     **/
    public void craftGift() throws InterruptedException {
        Gift gift = this.workshop.nextGift();
        if(gift!=null){
            Thread.sleep(gift.getCraftTime());
            giftCounter++;
            System.out.println("Gift " + gift.getType() + " was created.");
        }
    }

    @Override
    public void run() {
        try {
            while ((!workshop.isChristmasTime) || (!workshop.checkGiftWishes())) {
                craftGift();
            }
            System.out.println("Privet, az " + id + " napuavih " + giftCounter + " podauci.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
