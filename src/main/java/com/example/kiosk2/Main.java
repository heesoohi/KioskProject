package com.example.kiosk2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>();
        boolean isRunning = true;

        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner scanner = new Scanner(System.in); // Scanner 선언

        System.out.println("메뉴: ");
        for (int i = 0; i < menuItems.size(); i++) {
            MenuItem item = menuItems.get(i);
            System.out.println((i + 1) + "." + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
        }
        System.out.println("0. 프로그램 종료");
        System.out.println("\n원하는 메뉴의 번호를 입력하세요");

        while (isRunning) {
            try {
                int choice = scanner.nextInt();

                // 입력된 번호에 따라 로직 실행
                if (choice == 0) {
                    System.out.println("\n프로그램이 종료됩니다.");
                    isRunning = false;
                } else if (choice > 0 && choice <= menuItems.size()) {
                    // 선택된 메뉴의 인덱스 가져오기
                    MenuItem selectedItem = menuItems.get(choice - 1);
                    // 해당 메뉴의 상세 정보 출력
                    System.out.println(choice + "." + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                    isRunning = false;
                } else {
                    System.out.println("\n잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (InputMismatchException e) {
                // 숫자가 아닌 값을 입력했을 경우 예외 처리
                System.out.println("\n숫자만 입력해주세요.");
                scanner.nextLine(); // 사용자가 숫자가 아닌 값을 입력했을 때 버퍼에 남아있는 잘못된 값을 처리하고, 새로운 입력 받기
            }
        }
    }
}