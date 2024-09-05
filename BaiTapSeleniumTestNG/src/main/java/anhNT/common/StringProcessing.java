package anhNT.common;

import java.text.Normalizer;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringProcessing {

    /*Xóa kí tự dặc biệt khỏi chuỗi và vẫn giữ nguyên chữ tiếng việt*/
    public static String DeleteSpecialCharacters(String string){
        return string.replaceAll("[^\\p{L}0-9\\s]", "");
    }

    /*chỉ lấy giá trị là số*/
    public static String extractNumbers(String str) {
        // Biểu thức chính quy để tìm các số
        String regex = "\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        StringBuilder result = new StringBuilder();
        while (matcher.find()) {
            result.append(matcher.group()).append(" ");
        }
        return result.toString().trim();
    }
    /* Kiểm tra xem chuỗi có phải là số không */
    public static boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    /*Bỏ dấu của chữ*/
    public static String Unsigned(String str){
        switch (str){
            case "đ":
                str = "d";
                break;
            case "ê":
                str = "e";
                break;
            case "ư":
                str = "u";
                break;
            case "ô", "ơ":
                str = "o";
                break;
            case"ă", "â":
                str = "a";
                break;
        }
        return str;
    }
    public static String getDateOfWeek(){
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        // Chuyển đổi từ tiếng Anh sang tiếng Việt
        return removeAccent(today.getDisplayName(
                java.time.format.TextStyle.FULL_STANDALONE,
                new Locale("vi")
        ).toLowerCase().replaceAll("\\s+", ""));
    };
    /*Xóa dấu huyển, sắc, hỏi, nặng... và bỏ dấu của chữ tiếng việt*/
    public static String removeAccent(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d");
    }
    /*Xóa dấu tiếng việt, hạ về chữ thường, bỏ khoảng trống*/
    public static String removeAccentAndSpace(String s) {
        String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        temp = pattern.matcher(temp).replaceAll("");
        return temp.replaceAll("đ", "d").toLowerCase().replaceAll(" ","");
    }
    public static void sleep(double second) {
        try {
            Thread.sleep((long) (1000 * second));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
