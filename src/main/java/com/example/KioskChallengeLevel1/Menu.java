package com.example.KioskChallengeLevel1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    // MenuItem 클래스를 관리하는 클래스
    // 버거, 음료 등 각 카테고리 내에 여러 MenuItem 을 포함
    private final String categoryName;
    private final List<MenuItem> menuItems = new ArrayList<>();


    public Menu(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }

    public void printMenu(Cart cart, Scanner scanner, Boolean isRunning) {
        while (isRunning) {
            System.out.println("[ " + categoryName.toUpperCase() + " MENU ]");
            for (int i = 0; i < menuItems.size(); i++) {
                MenuItem item = menuItems.get(i);
                System.out.println((i + 1) + ". " + item.getName() + " | W " + item.getPrice() + " | " + item.getDescription());
            }
            System.out.println("0. 뒤로 가기");

            System.out.println("\n원하는 메뉴 아이템 번호를 입력하세요");

            try {
                int choice = scanner.nextInt();

                // 입력된 번호에 따라 로직 실행
                if (choice == 0) {
                    return;
                } else if (choice > 0 && choice <= menuItems.size()) {
                    // 선택된 메뉴의 인덱스 가져오기
                    MenuItem selectedItem = menuItems.get(choice - 1);
                    // 해당 메뉴의 상세 정보 출력
                    System.out.println(choice + "." + selectedItem.getName() + " | W " + selectedItem.getPrice() + " | " + selectedItem.getDescription());
                    System.out.println("장바구니에 추가하시겠습니다? \n1. 확인   2. 취소");
                    int choice2 = scanner.nextInt();
                    if (choice2 == 0) {
                        return;
                    } else if (choice2 == 1) {
                        cart.addItem(selectedItem);
                        System.out.println(selectedItem.getName() + "이(가) 장바구니에 추가되었습니다.");
                    } else if (choice2 == 2) {
                        System.out.println("취소되었습니다.");
                    } else {
                        System.out.println("\n잘못된 입력입니다. 다시 시도하세요.");
                    }
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
