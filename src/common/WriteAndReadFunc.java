package common;

import model.TaiKhoanNganHang;
import model.TaiKhoanThanhToan;
import model.TaiKhoanTietKiem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFunc<E> {

    //ghi vào file
    public void writeToCSVFile(List<TaiKhoanNganHang> list, boolean status) {
        final String PATH = "src/data/bank_accounts.csv";
        try {
            //ghi vào file
            FileWriter fileWriter = new FileWriter(PATH, status);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (TaiKhoanNganHang object : list) {
                bufferedWriter.write(object.toString() + "\n");
            }
            bufferedWriter.close();
            System.out.println("\n---Thêm vào file thành công!---");
        } catch (FileNotFoundException fileNotFoundException) {
            System.err.println("File không tồn tại!!!");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    //kiểm tra đã tồn tại ID hay chưa
//    public boolean isIdExist(String id, String fileName) {
//        switch (fileName) {
//            case "customers.csv": {
//                List<Customer> list = readCustomersFile();
//                for (Customer o : list) {
//                    if (o.getId().equals(id)) {
//                        return true;
//                    }
//                }
//                break;
//            }
//        }
//        return false;
//    }

    //show customers.csv
    public List<TaiKhoanNganHang> readCSVFile() throws InterruptedException {
        final String PATH = "src/data/bank_accounts.csv";
        List<TaiKhoanNganHang> list = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(PATH);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                String[] words = line.split("\\,");
                if (words.length == 8) {
                    list.add(new TaiKhoanTietKiem(Integer.parseInt(words[0]), words[1], words[2], words[3], Integer.parseInt(words[4]), words[5], Float.parseFloat(words[6]), Integer.parseInt(words[7])));
                } else {
                    list.add(new TaiKhoanThanhToan(Integer.parseInt(words[0]), words[1], words[2], words[3], words[4], Integer.parseInt(words[5])));
                }
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Không tìm thấy file!!!");
        } catch (Exception e) {
            System.err.println("Dữ liệu file không khả dụng!!!");
            Thread.sleep(250);
        }
        return list;
    }

//    //search by ID
//    public Services searchServiceById(String id) {
//        String typeOfService = id.substring(0, 4);
//        if (typeOfService.equals("SVVL")) {
//            List<Villa> list = readVillasFile();
//            for (Villa villa : list) {
//                if (villa.getId().equals(id)) {
//                    return villa;
//                }
//            }
//            return null;
//        } else if (typeOfService.equals("SVHO")) {
//            List<House> list = readHousesFile();
//            for (House house : list) {
//                if (house.getId().equals(id)) {
//                    return house;
//                }
//            }
//            return null;
//        } else if (typeOfService.equals("SVRO")) {
//            List<Room> list = readRoomsFile();
//            for (Room room : list) {
//                if (room.getId().equals(id)) {
//                    return room;
//                }
//            }
//            return null;
//        } else {
//            System.out.println("---LỖI: ID tìm kiếm không hợp lệ---");
//            return null;
//        }
//    }

//    public Map<Integer, Employee> readEmployeeFile(){
//        final String PATH = "src/data/employee.csv";
//        Map<Integer, Employee> map = new LinkedHashMap<>();
//        try {
//            FileReader fileReader = new FileReader(PATH);
//            BufferedReader bufferedReader = new BufferedReader(fileReader);
//            String line = "";
//            int i = 1;
//            while((line = bufferedReader.readLine()) != null){
//                String[] words = line.split("\\|");
//                Employee employee = new Employee(words[0], Integer.parseInt(words[1]), words[2]);
//                map.put(i++, employee);
//            }
//            bufferedReader.close();
//        } catch (FileNotFoundException fileNotFoundException) {
//            System.err.println("---Không tìm thấy file!---");
//        } catch (IOException ioException) {
//            System.err.println("---Lỗi đọc file!---");
//        }
//        return map;
//    }
}
