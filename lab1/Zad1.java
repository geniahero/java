// Найти все четырёхзначные числа из заданной последовательности натуральных
// чисел, кратные 45, две средние цифры которых равны 7 и 9, и посчитать их количество.
package lab1;

public class Zad1 {
    public static void main(String[] args) {
        int numbers[] = {1795, 4795, 4790, 8795, 9792, 12345, 790, 3795, 2790};
        int count = 0;

        for (int num : numbers) {
            if (1000 <= num && num <= 9999) {
                if (num % 45 == 0) {
                    int secondNum = (num % 1000) / 100;
                    int trirdNum = (num % 100) / 10;
                    if (secondNum == 7 && trirdNum == 9) { 
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}