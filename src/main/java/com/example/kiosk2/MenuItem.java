package com.example.kiosk2;

public class MenuItem {
    private final String name;
    private final double price;
    private final String description;

    public MenuItem(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getMenuItem() {
        return name + " |  W " + price + " | " + description;
    }
}
