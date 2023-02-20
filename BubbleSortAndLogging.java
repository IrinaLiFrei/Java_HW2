// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
package Java_HW2;


import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class BubbleSortAndLogging {
    public static void main(String[] args) {
        
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = reader.nextInt();
        reader.close();
        int[] randomArray = getArray(number);
        System.out.println(Arrays.toString(randomArray));
        System.out.println(Arrays.toString(sortArray(randomArray)));
        
    }

public static int[] getArray(int num) {
    int[] array = new int[num];
    Random random = new Random();
    for (int i = 0; i < array.length; i++) {
        array[i] = random.nextInt(0, 20);
    }
    return array;
}

public static int[] sortArray(int[] array) {
    for (int i = 0; i < array.length; i++) {
        for(int j = 0; j < array.length-1; j++){
            if(array[j] > array[j+1]) {
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;  
            }
        toLog();            // не работает, создает несколько пустых файлов
        }
    }
    return array;
}
public static void toLog() {
    Logger logger = Logger.getLogger (BubbleSortAndLogging.class.getName());
    FileHandler fh;
    try {
        fh = new FileHandler("HW2Log.xml");
        XMLFormatter xml = new XMLFormatter();
        fh.setFormatter(xml);
        logger.log(Level.WARNING, "Test 1");
    } catch (SecurityException e) {
        System.out.println("Catch1");
        e.printStackTrace();
    } catch (IOException e) {
        System.out.println("Catch2");
        e.printStackTrace();
    }  

}
}
