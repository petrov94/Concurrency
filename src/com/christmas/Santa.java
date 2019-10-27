package com.christmas;

import java.util.ArrayList;
import java.util.List;

public class Santa extends Thread {

    private Workshop workshop;
    private List<Gift> sledge;

    public Santa(Workshop workshop) {
        this.workshop = workshop;
    }

    @Override
    public void run() {
        while (true) {
            if (workshop.getWishCount() > 100) {
                sledge = workshop.prepareSledge();
                System.out.println("Otivam da zaradvam decata s : ");
                System.out.println(sledge.toString());
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
