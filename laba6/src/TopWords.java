import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopWords {
    public static void main(String[] args) {

        File currentFile = new File("C:\\Users\\natak\\IdeaProjects\\laba6\\src\\one.txt");
        String word = "";
        Map<String, Integer> map = new HashMap<>();
        try(Scanner scanner = new Scanner(currentFile)) {
            while (scanner.hasNext()) {
                word = scanner.next();
                word = word.replaceAll("[^A-Za-zА-Яа-я0-9ёЁ]", "").trim().toLowerCase();
                if (map.containsKey(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    map.put(word, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Integer> count = new ArrayList<>(map.values());
        Collections.sort(count);
        int i =0;
        while (i<10){
            for(String key: map.keySet()){ //перебирает все ключи мар
                if(map.get(key).equals(count.get(count.size()-1))){ //значение в мар с последнем элементом в списке count
                    System.out.println(key);
                    map.remove(key);
                    i++;
                    count.remove(count.size()-1);
                    break;
                }
            }
        }

    }
}
