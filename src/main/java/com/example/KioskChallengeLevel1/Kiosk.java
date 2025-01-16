package com.example.KioskChallengeLevel1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus = new ArrayList<>();
    private final Cart cart = new Cart();

    public void add(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < menus.size(); i++) {
            System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
        }
        System.out.println((menus.size()+1) + ". 장바구니");
        System.out.println((menus.size()+2) + ". 취소");
        System.out.println("0. 종료");

        while (isRunning) {
            try {
                System.out.println("원하는 메뉴 번호를 선택하세요: ");
                int mainChoice = scanner.nextInt();

                if (mainChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                } else if (mainChoice > 0 && mainChoice <= menus.size()) {
                    menus.get(mainChoice - 1).printMenu(cart, scanner, isRunning);
                } else if(mainChoice == menus.size() + 1 && !cart.isEmpty()) {
                    cart.printCart();
                    System.out.println("\n1. 주문    2. 메뉴");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        System.out.println("주문 완료! 총 금액 : "+ cart.getTotal());
                        cart.clearCart();
                    } else if (choice == 2) {
                        return;
                    }
                } else if (mainChoice == menus.size() + 2){
                    if (!cart.isEmpty()) {
                        cart.clearCart();
                        System.out.println("진행 중인 주문이 취소되었습니다.");
                    }
                }else {
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
