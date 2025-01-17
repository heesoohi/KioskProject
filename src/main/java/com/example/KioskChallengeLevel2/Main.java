package com.example.KioskChallengeLevel2;

public class Main {
    public static void main(String[] args) {

        // 메뉴, 메뉴 아이템 추가
        Menu burgers = new Menu("Burgers");
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        drinks.addMenuItem(new MenuItem("Coke", 2.5, "콜라"));
        drinks.addMenuItem(new MenuItem("Sprite", 2.5, "사이다"));

        Menu desserts = new Menu("Desserts");
        desserts.addMenuItem(new MenuItem("Ice Cream", 3.3, "바닐라맛"));
        desserts.addMenuItem(new MenuItem("Milk Shake", 3.5, "카라멜맛"));

        Kiosk kiosk = new Kiosk();
        kiosk.add(burgers);
        kiosk.add(drinks);
        kiosk.add(desserts);

        kiosk.start();

    }
}
