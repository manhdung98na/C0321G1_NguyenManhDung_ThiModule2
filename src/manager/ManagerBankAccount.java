package manager;

import common.ValidateBankAccount;
import common.WriteAndReadFunc;
import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import model.TaiKhoanTietKiem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerBankAccount {
    WriteAndReadFunc readWrite = new WriteAndReadFunc();
    ValidateBankAccount validate = new ValidateBankAccount();

    public TaiKhoanNganHang themTaiKhoanThanhToan() {
        Scanner sc = new Scanner(System.in);
        int idTaiKhoan = 1;
        String maNganHang;
        String tenChuTaiKhoan;
        String ngayTao;
        String soThe;
        int tienTrongTaiKhoan;
        try {
            System.out.println("---Thêm mới tài khoản thanh toán---");
            List<TaiKhoanNganHang> listTaiKhoanNganHang = readWrite.readCSVFile();
            if (listTaiKhoanNganHang.size() == 0) {
                idTaiKhoan = 1;
            } else {
                idTaiKhoan = listTaiKhoanNganHang.get(listTaiKhoanNganHang.size() - 1).getIdTaiKhoan() + 1;
            }
            System.out.print("\tID: " + idTaiKhoan + "\n");
            System.out.print("\tMã ngân hàng: ");
            maNganHang = sc.nextLine();
            do {
                System.out.print("\tTên chủ tài khoản: ");
                tenChuTaiKhoan = sc.nextLine();
                if (!validate.validateName(tenChuTaiKhoan)) {
                    System.err.println("Tên sai định dạng");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            do {
                System.out.print("\tNgày tạo: ");
                ngayTao = sc.nextLine();
                if (!validate.validateDate(ngayTao)) {
                    continue;
                }
                break;
            } while (true);
            System.out.print("\tSố thẻ: ");
            soThe = sc.nextLine();
            do {
                try {
                    System.out.print("\tTiền trong tài khoản: ");
                    tienTrongTaiKhoan = Integer.parseInt(sc.nextLine());
                    if (tienTrongTaiKhoan < 0) {
                        System.err.println("Tiền trong tài khoản phải là số dương");
                        Thread.sleep(250);
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Định dạng nhập vào không hợp lệ");
                    Thread.sleep(250);
                }
            } while (true);
            TaiKhoanThanhToan themTaiKhoan = new TaiKhoanThanhToan(idTaiKhoan, maNganHang, tenChuTaiKhoan, ngayTao, soThe, tienTrongTaiKhoan);
            listTaiKhoanNganHang.add(themTaiKhoan);
            readWrite.writeToCSVFile(listTaiKhoanNganHang, false);
            return themTaiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoanNganHang themTaiKhoanTietKiem() {
        Scanner sc = new Scanner(System.in);
        int idTaiKhoan = 1;
        String maNganHang, tenChuTaiKhoan, ngayTao, ngayGui;
        int tienTrongTaiKhoan, soTienGui, thoiHan;
        float laiSuat;
        try {
            System.out.println("---Thêm mới tài khoản tiết kiệm---");
            List<TaiKhoanNganHang> listTaiKhoanNganHang = readWrite.readCSVFile();
            if (listTaiKhoanNganHang.size() == 0) {
                idTaiKhoan = 1;
            } else {
                idTaiKhoan = listTaiKhoanNganHang.get(listTaiKhoanNganHang.size() - 1).getIdTaiKhoan() + 1;
            }
            System.out.print("\tID: " + idTaiKhoan + "\n");
            System.out.print("\tMã ngân hàng: ");
            maNganHang = sc.nextLine();
            do {
                System.out.print("\tTên chủ tài khoản: ");
                tenChuTaiKhoan = sc.nextLine();
                if (!validate.validateName(tenChuTaiKhoan)) {
                    System.err.println("Tên sai định dạng");
                    Thread.sleep(250);
                    continue;
                }
                break;
            } while (true);
            do {
                System.out.print("\tNgày tạo: ");
                ngayTao = sc.nextLine();
                if (!validate.validateDate(ngayTao)) {
                    continue;
                }
                break;
            } while (true);
            do {
                try {
                    System.out.print("\tSố tiền gửi: ");
                    soTienGui = Integer.parseInt(sc.nextLine());
                    if (soTienGui < 0) {
                        System.err.println("Số tiền gửi phải là số dương");
                        Thread.sleep(250);
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Định dạng nhập vào không hợp lệ");
                    Thread.sleep(250);
                }
            } while (true);
            do {
                System.out.print("\tNgày gửi: ");
                ngayGui = sc.nextLine();
                if (!validate.validateDate(ngayGui)) {
                    continue;
                }
                break;
            } while (true);
            do {
                try {
                    System.out.print("\tLãi suất: ");
                    laiSuat = Float.parseFloat(sc.nextLine());
                    if (laiSuat < 0) {
                        System.err.println("Lãi suất phải là số dương");
                        Thread.sleep(250);
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Định dạng nhập vào không hợp lệ");
                    Thread.sleep(250);
                }
            } while (true);
            do {
                try {
                    System.out.print("\tThời hạn (tháng): ");
                    thoiHan = Integer.parseInt(sc.nextLine());
                    if (thoiHan < 0) {
                        System.err.println("Thời hạn phải là số dương");
                        Thread.sleep(250);
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Định dạng nhập vào không hợp lệ");
                    Thread.sleep(250);
                }
            } while (true);

            TaiKhoanTietKiem themTaiKhoan = new TaiKhoanTietKiem(idTaiKhoan, maNganHang, tenChuTaiKhoan, ngayTao, soTienGui, ngayGui, laiSuat, thoiHan);
            listTaiKhoanNganHang.add(themTaiKhoan);
            readWrite.writeToCSVFile(listTaiKhoanNganHang, false);
            return themTaiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public TaiKhoanNganHang xoaTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        String maNganHang;
        System.out.println("--Xóa tài khoản ngân hàng--");
        do {
            try {
                System.out.print("\tNhập mã ngân hàng: ");
                maNganHang = sc.nextLine();
                List<TaiKhoanNganHang> list = readWrite.readCSVFile();
                for (int i = 0; i < list.size(); i++) {
                    if (maNganHang.equals(list.get(i).getMaNganHang())) {
                        TaiKhoanNganHang xoaTaiKhoan = list.remove(i);
                        readWrite.writeToCSVFile(list, false);
                        System.out.println("Xóa thành công!");
                        showAll();
                        return xoaTaiKhoan;
                    }
                }
                System.out.println("Mã ngân hàng không tồn tại");
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (true);
    }

    public void showAll() {
        List<TaiKhoanNganHang> list = null;
        System.out.println("---Danh sách ngân hàng---");
        try {
            list = readWrite.readCSVFile();
            for (int i = 0; i < list.size(); i++) {
                list.get(i).showInfo();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public List<TaiKhoanNganHang> search() {
        List<TaiKhoanNganHang> listResult = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String infoTimKiem = "";
        do {
            try {
                List<TaiKhoanNganHang> list = readWrite.readCSVFile();
                System.out.println("---Tìm kiếm---");
                System.out.println("\t1. Tìm theo Mã tài khoản");
                System.out.println("\t2. Tìm theo Tên chủ tài khoản");
                System.out.println("\t3. Quay lại!");
                System.out.print("\tChọn: ");
                infoTimKiem = sc.nextLine();
                switch (infoTimKiem) {
                    case "1":
                        System.out.print("\tMã tài khoản tìm kiếm: ");
                        String maTaiKhoan = sc.nextLine();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getMaNganHang().contains(maTaiKhoan)){
                                listResult.add(list.get(i));
                            }
                        }
                        return listResult;
                    case "2":
                        System.out.print("\tTên chủ tài khoản tìm kiếm: ");
                        String chuTaiKhoan = sc.nextLine();
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getTenChuTaiKhoan().contains(chuTaiKhoan)){
                                listResult.add(list.get(i));
                            }
                        }
                        return listResult;
                    case "3":
                        return null;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } while (true);

    }
}
