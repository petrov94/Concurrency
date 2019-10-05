package com.company;

public class Main {

    public static void main(String args[]){

        Shop pernikGlaven = new Shop();
        Deliver deliver1 = new Deliver("deliver1",pernikGlaven);
        Deliver deliver2 = new Deliver("deliver2", pernikGlaven);
        Buyer buyer1 = new Buyer("buyer1", pernikGlaven);
        Buyer buyer2 = new Buyer("buyer2", pernikGlaven);


        deliver1.start();
        deliver2.start();
        buyer1.start();
        buyer2.start();
    }
}
