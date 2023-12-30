import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IPCheck {
    public static void main(String[] args) {
        String password= "000.195.225.225";
        Pattern pattern = Pattern.compile("^(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})" +
                "(\\.(25[0-5]|2[0-4][0-9]|[0-1]?[0-9]{1,2})){3}$");
        Matcher matcher = pattern.matcher(password);
        if(matcher.find()){
            System.out.println(matcher.group());
        }else System.out.println("IP некорректен");
    }
}

