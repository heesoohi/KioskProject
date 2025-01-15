package com.example.kioskLevel4;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus = new ArrayList<>();
    private boolean isRunning;

    public void add(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        isRunning = true;

        while (isRunning) {
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println("0. 종료");

            try{
                System.out.println("원하는 메뉴 번호를 선택하세요: ");
                int mainChoice = scanner.nextInt();

                if (mainChoice == 0 ) {
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                } else if (mainChoice > 0 && mainChoice <= menus.size()) {
                    menus.get(mainChoice-1).printMenu();
                } else {
                    System.out.println("잘못된 입력입니다. 다시 시도하세요.");
                }
            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
