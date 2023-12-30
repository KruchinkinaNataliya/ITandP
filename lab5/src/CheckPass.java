import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckPass {
    public static void main(String[] args) {
        String password = "Awsdeses1";
        Pattern pattern = Pattern.compile("^[A-Za-z\\d]{8,16}$");
        Matcher matcher = pattern.matcher(password);
        Pattern pattern1 = Pattern.compile(".*[A-Z].*");
        Matcher matcher1 = pattern1.matcher(password);
        Pattern pattern2 = Pattern.compile(".*\\d+.*");
        Matcher matcher2 = pattern2.matcher(password);
        System.out.println(matcher.find() && matcher1.find() && matcher2.find());
    }
}
