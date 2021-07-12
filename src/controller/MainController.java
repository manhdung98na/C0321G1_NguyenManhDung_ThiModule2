package controller;

import manager.ManagerBankAccount;
import model.TaiKhoanNganHang;

import java.util.List;
import java.util.Scanner;

public class MainController {
    static ManagerBankAccount managerBankAccount = new ManagerBankAccount();

    public static void displayMainMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ TÀI KHOẢN NGÂN HÀNG---");
        System.out.println("\tChọn chức năng theo số để tiếp tục:");
        System.out.println("\t1.Thêm mới");
        System.out.println("\t2.Xóa");
        System.out.println("\t3.Xem danh sách các tài khoản ngân hàng");
        System.out.println("\t4.Tìm kiếm");
        System.out.println("\t5.Thoát");
    }

    public static void addBankAccount() {
        Scanner sc = new Scanner(System.in);
        do {
            try {
                System.out.println("---Thêm mới---");
                System.out.println("\t1. Tài khoản thanh toán");
                System.out.println("\t2. Tài khoản tiết kiệm");
                System.out.println("\t3. Quay lại!");
                System.out.println("Chọn chức năng để tiếp tục: ");
                String choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        managerBankAccount.themTaiKhoanThanhToan();
                        break;
                    case "2":
                        managerBankAccount.themTaiKhoanTietKiem();
                        break;
                    case "3":
                        return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public static TaiKhoanNganHang deleteBankAccount() {
        TaiKhoanNganHang obj = managerBankAccount.xoaTaiKhoan();
        return obj;
    }

    public static void showAll() {
        managerBankAccount.showAll();
    }

    public static void search() {
        List<TaiKhoanNganHang> listSearch = managerBankAccount.search();
        if (listSearch.size() == 0) {
            System.out.println("KHÔNG TÌM THẤY KẾT QUẢ");
            return;
        }
        System.out.println("DANH SÁCH TÌM THẤY");
        for (int i = 0; i < listSearch.size(); i++) {
            listSearch.get(i).showInfo();
        }
    }
}
