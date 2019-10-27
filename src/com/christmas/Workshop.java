package com.christmas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class Workshop {

    private BlockingQueue<Gift> requestedGifts = new LinkedBlockingQueue<>();
    private CopyOnWriteArrayList<Gift> producedGifts = new CopyOnWriteArrayList<>();
    private Elf[] elfes = new Elf[20];
    protected volatile boolean isChristmasTime;

    public Workshop(){
        for(int i=0;i<20;i++){
            elfes[i] = new Elf(i+1,this);
            elfes[i].start();
        }
    }
    /**
     * Adds a gift to the elves' backlog.
     **/
    public void postWish(Gift gift) {
        if(gift!=null){
            requestedGifts.add(gift);
        }
    }

    /**
     * Returns the next gift from the elves' backlog that has to be manufactured.
     **/
    public Gift nextGift() {
        Gift gift = requestedGifts.poll();
        if(gift!=null){
                producedGifts.add(gift);
        }
        return gift;
    }

    public boolean checkGiftWishes(){
        return this.requestedGifts.isEmpty();
    }

    /**
     * Returns the total number of wishes sent to Santa's workshop by the kids.
     **/
    public synchronized int getWishCount() {
            return producedGifts.size();
    }

    public List<Gift> prepareSledge(){
            List<Gift> sledge = producedGifts.subList(0, 100);
            producedGifts.subList(0, 100).clear();
            return sledge;
    }
}
