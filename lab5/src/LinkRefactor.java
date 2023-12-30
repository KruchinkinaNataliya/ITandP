import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkRefactor {
    public static void main(String[] args) {
        String text= "link izhlife.ru/psychology/karty-taro-istoriya-poyavleniya-i-kak-gadat-onlayn.html , " +
                "other link skillbox.ru/media/design/figma-files-1/";
        Pattern pattern = Pattern.compile("[a-z0-9-.]+\\.[a-z.]{2,5}(/[a-z0-9%-_.?=&@#]*)?");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()){
            String link = "https://"+matcher.group();
            text=text.replace(matcher.group(),link);
        }
        System.out.println(text);
    }
}

