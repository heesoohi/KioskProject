package com.example.KioskChallengeLevel1;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> items = new ArrayList<>();

    public void addItem(MenuItem menuItem) {
        for (CartItem item : items) {
            if (item.getMenuItem().getName().equals(menuItem.getName())) {
                item.addQuantity();
                return;
            }
        }
        items.add(new CartItem(menuItem, 1));
    }

    public void printCart() {
        if (items.isEmpty()) {
            System.out.println("\n [장바구니가 비어 있습니다]");
            return;
        }

        System.out.println("\n [장바구니]");
        double total = 0;
        for (CartItem item : items) {
            System.out.println(item.getMenuItem().getName() + " | W " + item.getMenuItem().getPrice() + " | " + item.getQuantity() + "개");
            total += item.getMenuItem().getPrice() * item.getQuantity();
        }
        System.out.println("\n [Total]" + total);
    }

    public void clearCart() {
        items.clear();
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getTotal() {
        return items.stream().mapToDouble(item -> item.getMenuItem().getPrice() * item.getQuantity()).sum();
    }
}
