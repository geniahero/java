// Для каждого числа из заданной последовательности натуральных чисел
// определить, верно ли, что куб суммы его цифр равен квадрату числа.

package lab_1;

public class zad_3 {
    public static void main(String[] args) {
        int numbers[] = {1, 27, 100, 12345, 0, 45915};
        for(int num : numbers) {
            int sumOfDigit = 0;
            int div = num;
            String not = "";

            while (div > 0) {
                sumOfDigit += div % 10;
                div /= 10;
                // Test
                // System.out.println(div);
            }
             
            if (Math.pow(sumOfDigit, 3) != Math.pow(num, 2)) {
               not = " не";
            }

            System.out.println("Число " + num + not + " удовлетворяет условию");
        }
    }
}
