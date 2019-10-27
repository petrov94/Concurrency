package com.christmas;

public class Kid extends Thread{

    private Workshop workshop;

    public Kid(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public void run() {
        try {
            while (!workshop.isChristmasTime) {
                Thread.sleep(1000);
                Gift gift = Gift.getGift();
                makeWish(gift);
                System.out.println("Izbrah si podaruk " + gift.toString() + " i sum mnogo shtasliv.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Sends a wish for the given gift to Santa's workshop.
     **/
    public void makeWish(Gift gift) {
        this.workshop.postWish(gift);
    }
}
