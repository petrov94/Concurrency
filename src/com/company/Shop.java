package com.company;

import java.util.*;

public class Shop {

    private HashMap<String,Integer> products = new HashMap<>();

    private Set<String> deficitProducts = new HashSet<>();

    public static final byte MIN_QUANTITY=5;

    public static final byte MAX_QUANTITY=100;

    public Shop(){
        products.put("Orange",13);
        products.put("Banana",12);
        products.put("Apple",15);
    }

    public synchronized void buy(String product , Integer amount) throws InterruptedException {
        if (products.get(product) < MIN_QUANTITY) {
            deficitProducts.add(product);
            wait();
        }else {
            products.put(product, products.get(product) - amount);
            System.out.println("Buyer " + Thread.currentThread().getName() + " bought " + amount + " of " + product + ". Left : " + products.get(product));
            notifyAll();
        }
    }

    public synchronized void deliver() throws InterruptedException {
        if(deficitProducts.size()>0){
            for (String product : deficitProducts) {
                if((products.get(product)+Deliver.DELIVERY_AMOUNT)<MAX_QUANTITY)
                products.put(product,products.get(product)+Deliver.DELIVERY_AMOUNT);
                System.out.println("Deliver " + Thread.currentThread().getName() + " brought " + product);
            }
            notifyAll();
        }else {
            wait();
        }
    }

    public List<String> getProducts() {
        return new ArrayList<>(products.keySet());
    }
}
