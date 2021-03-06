package com.g2d.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {

    private Map<Product, Integer> cart = new HashMap<>();
    private Customer user;

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }

    public void add(Product p, int q) throws IllegalAccessException {
        if (q <= 0) {
            throw new IllegalAccessException("數字必須大於0");

        } else {
            Integer oldQ = cart.get(p);
            if (oldQ == null) {
                cart.put(p, q);
            } else {
                cart.put(p, oldQ + q);
            }
        }

    }

    public int getQuantity(Product p) {
        Integer q = cart.get(p);
        return (q == null ? 0 : q);
    }

    public void add(Product p) throws IllegalAccessException {
        add(p, 1);
    }

    public Set<Product> keySet() {
        return cart.keySet();
    }

    public void update(Product p, int q) throws IllegalAccessException {

        if (q <= 0) {
            throw new IllegalAccessException("數量必須大於0");
        } else {
            cart.put(p, q);

        }
    }

    public void remove(Product p) {
        cart.remove(p);
    }

    public int size() {
        return cart.size();
    }

    public boolean isEmpty() {
        return cart.isEmpty();
    }

    public int getTotalQuantity() {
        int totalQuantity = 0;
        for (Product p : cart.keySet()) {
            Integer q = cart.get(p);
            totalQuantity = totalQuantity + q;
        }

        return totalQuantity;
    }

    public double getTotalAmount() {
        double totalAmount = 0;
        for (Product p : cart.keySet()) {
            Integer q = cart.get(p);
            totalAmount = totalAmount + (p.getUntiPrice() * (q == null ? 0 : q));
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "購物車{" + " user=" + user + ",\ncart=" + cart + "}\n共有" + cart.size() + "種商品,"
                + "總共件數:" + getTotalQuantity() + ",實際總金額: " + getTotalAmount() + ".\n" ;
    }

}
