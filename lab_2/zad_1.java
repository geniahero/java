// Дана матрица A(n,m). Найти количество отрицательных и нулевых
// элементов в каждой строке. Отсортировать строки матрицы по количеству
// отрицательных элементов. Если есть строки у которых число отрицательных
// элементов совпадает, то их дополнительно упорядочить по количеству нулевых
// элементов в строке
package lab_2;

import java.util.Random;
import java.util.Scanner;

public class zad_1 {
    
    static int countOfNegative(int[][] arr, int row){
        int count = 0;
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] < 0) {
                count++;
            }
        }
        return count;
    }

    static int countOfZero(int[][] arr, int row){
        int count = 0;
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] == 0) {
                count++;
            }
        }
        return count;
    }

    //void printCountOfZeroAndNegative(int[][] arr, int row)
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;

        do {
            System.out.print("Пожалуйста, введите число: ");
            n = scanner.nextInt();
        
            if (n < 0) {
                System.out.println("Пожалуста, введите положительное число");
            }
        } while(n < 0); 

        System.out.println("\nСпасибо! Это число подходит");

        int[][] matrix = new int[n][n];

        System.out.println("\nМеню");
        System.out.println("0 - заполнить массив случайными числами");
        System.out.println("1 - заполнить массив вручную");

        int choice = scanner.nextInt();

        do { 
            if(choice == 0){
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = random.nextInt(3) - 1;
                    }
                }
            }

            if(choice == 1){
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print("matrix[" + i + "][" + j + "] = ");
                        matrix[i][j] = scanner.nextInt();
                    }
                }
            }

            if (choice != 1 && choice != 0) {
                System.out.println("Нет, либо 1, либо 0. Просто выбери один вариант");
            }
        } while (choice != 1 && choice != 0);

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            int countOfZero = 0;
            int countOfNegative = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) {countOfNegative++;}
                if(matrix[i][j] == 0) {countOfZero++;}
            }
            System.out.println("\nВ строке " + i + ":");
            System.out.println(countOfNegative + " негативных элемента.");
            System.out.println(countOfZero + " нулевых элемента.");
        }

        //создать функции countOfNegative и countOfZero
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                int countOfNegativeIncurrentRow = countOfNegative(matrix, j);
                int countOfNegativeInnextRow = countOfNegative(matrix, j + 1);

                if(countOfNegativeIncurrentRow < countOfNegativeInnextRow || 
                (
                    countOfNegativeIncurrentRow == countOfNegativeInnextRow
                    && countOfZero(matrix, j) < countOfZero(matrix, j + 1)
                )){
                    int[] temp = matrix[j];
                    matrix[j] = matrix[j + 1];
                    matrix[j + 1] = temp;
                }
            }
        }
        
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }

        for (int i = 0; i < n; i++) {
            int countOfZero = 0;
            int countOfNegative = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < 0) {countOfNegative++;}
                if(matrix[i][j] == 0) {countOfZero++;}
            }
            System.out.println("\nВ строке " + i + ":");
            System.out.println(countOfNegative + " негативных элемента.");
            System.out.println(countOfZero + " нулевых элемента.");
        }
    }
}
