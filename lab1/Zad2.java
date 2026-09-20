// Найти и вывести все пятизначные числа из заданной последовательности чисел,
// средняя цифра которых равна сумме крайних цифр. Подсчитать их количество.
package lab1;

import java.util.ArrayList;
import java.util.List;

public class Zad2 {
    public static void main(String[] args) {
        List<Integer> necessaryNumbers = new ArrayList<>();
        int numbers[] = {12345, 10201, 45915, 30000, 95900, 71234};

        for (int num : numbers) {
            if (10000 <= num && num <= 99999) {
                    int startDigit = num / 10000;
                    int endDigit = num % 10;
                    int midelDigit = (num % 1000) / 100;
                    // Test
                    // System.out.println(startDigit);
                    // System.out.println(midelDigit);
                    // System.err.println(endDigit + "|");
                    if (startDigit + endDigit == midelDigit) { 
                        necessaryNumbers.add(num);
                    }
            }
        }

        System.out.println("Найденные числа: " + necessaryNumbers);
        System.out.println("Их количество: " + necessaryNumbers.size());
    }
}
