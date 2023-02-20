// 3* . Дана json строка (можно сохранить в файл и читать из файла)
// [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4",
// "предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
// Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
// Пример вывода:
// Студент Иванов получил 5 по предмету Математика.
// Студент Петрова получил 4 по предмету Информатика.
// Студент Краснов получил 5 по предмету Физика.

package Java_HW2;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ParseString {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\airin\\Desktop\\Studies\\0. Workshop\\Java\\Java_HW2\\ParseString.json"))) {
            String data;
            while ((data = br.readLine()) != null) {
                sb.append(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Catch");
        } finally {
            System.out.println("End");
        }

        Map<String, String> dictionary = new HashMap<>();
        String[] keys = sb.toString().replace("{", "").
                replace("[", "").
                replace("]", "").
                replace("\"", "").
                replaceAll("\\s", "").
                split("},");
        
        for (String data : keys) {
            String[] student = data.split(",");
            for (String keyValues : student) {
                String[] keyValue = keyValues.replace("}", "").split(":");
                String key = keyValue[0];
                String value = keyValue[1];
                dictionary.put(key, value);
    }
        String surname = dictionary.get("surname");
        String mark = dictionary.get("mark");
        String subject = dictionary.get("subject");
        System.out.printf("\nStudent %s received %s in %s", surname, mark, subject);
    }
}
}
