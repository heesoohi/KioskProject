package com.example.KioskChallengeLevel2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private final List<Menu> menus = new ArrayList<>();
    private final Cart cart = new Cart();

    // 사용자 유형 별 할인률 관리 위해 Enum 정의
    public enum UserType {
        STUDENT(0.1),
        SOLDIER(0.2),
        GENERAL(0.0);

        private final double discountRatio;

        UserType(double discountRatio) {
            this.discountRatio = discountRatio;
        }

        public double getDiscountRatio() {
            return discountRatio;
        }
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {

            // 키오스크 실행 시 메인 화면 출력
            System.out.println("[ MAIN MENU ]");
            for (int i = 0; i < menus.size(); i++) {
                System.out.println((i + 1) + ". " + menus.get(i).getCategoryName());
            }
            System.out.println((menus.size()+1) + ". 장바구니");
            System.out.println((menus.size()+2) + ". 취소");
            System.out.println("0. 종료");

            try {
                System.out.println("원하는 메뉴 번호를 선택하세요: ");
                int mainChoice = scanner.nextInt();

                // 입력 번호에 적절한 로직 수행
                if (mainChoice == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    isRunning = false;
                } else if (mainChoice > 0 && mainChoice <= menus.size()) { // 메뉴 번호 선택 시 메뉴 아이템 출력
                    menus.get(mainChoice - 1).printMenu(cart, scanner, isRunning);
                } else if(mainChoice == menus.size() + 1 && !cart.isEmpty()) { // 장바구니 선택 시 장바구니 내용 출력
                    cart.printCart();
                    System.out.println("\n1. 주문    2. 메뉴");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 1) {
                        // 사용자 유형 선택
                        System.out.println("[할인] \n1. 학생 \n2. 군인 \n3. 해당 없음");
                        int discountChoice = scanner.nextInt();

                        if(discountChoice == 3){
                            System.out.println("주문 완료! 총 금액 : "+ cart.getTotal());
                            cart.clearCart();
                        } else if (discountChoice == 1 || discountChoice == 2) {
                            UserType userType;
                            switch (discountChoice) {
                                case 1:
                                    userType = UserType.STUDENT;
                                    System.out.println("10% 할인! 총 금액 : "+ cart.getTotal()*(1-userType.getDiscountRatio()));
                                    cart.clearCart();
                                    break;
                                case 2:
                                    userType = UserType.SOLDIER;
                                    System.out.println("20% 할인! 총 금액 : "+ cart.getTotal()*(1-userType.getDiscountRatio()));
                                    cart.clearCart();
                                    break;
                            }
                        }
                    } else if (choice == 2) {
                        return;
                    }
                } else if (mainChoice == menus.size() + 1 && cart.isEmpty()){
                    cart.printCart();
                }else if (mainChoice == menus.size() + 2){
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
