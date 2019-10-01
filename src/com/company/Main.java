package com.company;

public class Main {

    public static void main(String args[]){

        Shop pernikGlaven = new Shop();
        Deliver vankata = new Deliver("Magitoooo da se ne surdi",pernikGlaven);
        Deliver pepi = new Deliver("TOQ E ZLE", pernikGlaven);
        Buyer nikolinka = new Buyer("tonkata", pernikGlaven);
        Buyer stanoicho = new Buyer("antoncho", pernikGlaven);


        vankata.start();
        pepi.start();
        nikolinka.start();
        stanoicho.start();
    }
}
