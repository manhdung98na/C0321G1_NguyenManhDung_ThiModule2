package view;

import controller.MainController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                Thread.sleep(250);
                //Hiển thị MENU chức năng
                MainController.displayMainMenu();
                //chọn chức năng
                System.out.print("Nhập chức năng: ");
                int chucNang = Integer.parseInt(sc.nextLine());
                switch (chucNang) {
                    case 1:
                        MainController.addBankAccount();
                        break;
                    case 2:
                        MainController.deleteBankAccount();
                        break;
                    case 3:
                        MainController.showAll();
                        break;
                    case 4:
                        MainController.search();
                        break;
                    case 5:
                        System.exit(1);

                    default:
                        System.err.println("Vui lòng chọn chức năng có trong Menu");
                }
            } catch (NumberFormatException | InterruptedException e) {
                System.err.println("Không hợp lệ! Vui lòng nhập KÍ TỰ SỐ!");
            }
        } while (true);
    }
}
