package common;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class ValidateBankAccount {
    public boolean validateName(String name){
        String regex = "^\\p{Lu}\\p{Ll}*(\\s\\p{Lu}\\p{Ll}*)*$";
        return Pattern.matches(regex,name);
    }

    public boolean validateDate(String str) throws InterruptedException {
        String formatDOB = "^[0-9]{2}/[0-9]{2}/[0-9]{4}$";
        if (!Pattern.matches(formatDOB, str)) {
            System.err.println("---Sai định dạng dd/mm/yyyy---");
            Thread.sleep(250);
            return false;
        }
        int year = Integer.parseInt(str.substring(6, 10));
        int month = Integer.parseInt(str.substring(3, 5));
        int day = Integer.parseInt(str.substring(0, 2));
        //tháng sinh < 0 || tháng sinh > 12
        if (month < 0 || month > 12){
            System.err.println("---Sai tháng---");
            Thread.sleep(250);
            return false;
        }
        //kiểm tra tháng 2
        if (month == 2 && (day < 1 || day > 29)){
            System.err.println("---Tháng " + month + " chỉ có nhiều nhất 29 ngày---");
            Thread.sleep(250);
            return false;
        }
        //tháng có 31 ngày
        if (month == 1 ||month == 3 || month == 5 ||month == 7 ||month == 8 ||month == 10 ||month == 12){
            if (day < 1 || day > 31){
                System.err.println("---Tháng " + month + " chỉ có 31 ngày---");
                Thread.sleep(250);
                return false;
            }
        }
        //tháng 30 ngày
        if (month == 4 ||month == 6 || month == 9 ||month == 11){
            if (day < 1 || day > 30){
                System.err.println("---Tháng " + month + " chỉ có 30 ngày---");
                Thread.sleep(250);
                return false;
            }
        }
        return true;
    }


}
