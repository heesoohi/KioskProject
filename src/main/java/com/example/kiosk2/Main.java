package com.example.kiosk2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();

        MenuItem menuItem1 = new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem2 = new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거");
        MenuItem menuItem3 = new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거");
        MenuItem menuItem4 = new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거");

        // add 함수를 통해 new MenuItem(이름, 가격, 설명) menuItems 에 삽입
        menuItems.add(menuItem1);
        menuItems.add(menuItem2);
        menuItems.add(menuItem3);
        menuItems.add(menuItem4);

        Scanner scanner = new Scanner(System.in); // Scanner 선언
        boolean isRunning = true;

        while (isRunning) {
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i+1) + "." + menuItems.get(i).getMenuItem());
            }

            System.out.println("원하는 메뉴의 번호를 입력하세요");
            int choice = scanner.nextInt();

            // 입력된 번호에 따라 로직 실행
            switch (choice) {
                case 1:
                    System.out.println("선택한 메뉴 : 1. " + menuItem1.getMenuItem());
                    break;
                case 2:
                    System.out.println("선택한 메뉴 : 2." + menuItem2.getMenuItem());
                    break;
                case 3:
                    System.out.println("선택한 메뉴 : 3. " + menuItem3.getMenuItem());
                    break;
                case 4:
                    System.out.println("선택한 메뉴 : 4. " + menuItem4.getMenuItem());
                    break;
                case 0:
                    System.out.println("\n프로그램이 종료됩니다.");
                    isRunning = false;
                    break;
                default:
                    System.out.println("\n잘못된 입력입니다. 다시 시도하세요.");
            }
        }

    }
}