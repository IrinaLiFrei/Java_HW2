package Java_HW2;
// К калькулятору из предыдущего дз добавить логирование.

import java.io.IOException;
import java.util.logging.Logger;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.XMLFormatter;

public class CalculatorAndLogging {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int a = in.nextInt();
        System.out.print("Enter the second number: ");
        int b = in.nextInt();
        System.out.printf("%d + %d = %d", a, b, getSum(a, b));
        System.out.printf("\n%d - %d = %d", a, b, getSubtraction(a, b));
        System.out.printf("\n%d * %d = %d", a, b, getProduct(a, b));
        System.out.printf("\n%d : %d = %.2f", a, b, getDivision(a, b));
    }

    public static int getSum(int num1, int num2){
        return num1 + num2;
    }

    public static int getSubtraction(int num1, int num2){
        return num1 - num2;
    }

    public static int getProduct(int num1, int num2){
        return num1 * num2;
    }

    public static double getDivision(int num1, int num2){
        double a = num1;
        double b = num2;
        if (num2 == 0){ 
            System.out.println("\nError! Can't devide by zero!");
            toLog();
            return 0;
        } else {
           double div = a/b;
           return (div);
        }   
    }

    public static void toLog() {
        Logger logger = Logger.getLogger (CalculatorAndLogging.class.getName());
        FileHandler fh;
        try {
            fh = new FileHandler("HW2Log2.xml");
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