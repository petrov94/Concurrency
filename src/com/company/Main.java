package com.company;

public class Main {

    public static void main(String args[]){

        Shop pernikGlaven = new Shop();
        Deliver vankata = new Deliver("VANKATA", pernikGlaven);
        Deliver pepi = new Deliver("PEPI", pernikGlaven);
        Buyer nikolinka = new Buyer("Nikolinka", pernikGlaven);
        Buyer stanoicho = new Buyer("stanoicho", pernikGlaven);


        vankata.start();
        pepi.start();
        nikolinka.start();
        stanoicho.start();
    }
}
