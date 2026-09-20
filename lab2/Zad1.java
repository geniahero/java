// Дана матрица A(n,m). Найти количество отрицательных и нулевых
// элементов в каждой строке. Отсортировать строки матрицы по количеству
// отрицательных элементов. Если есть строки у которых число отрицательных
// элементов совпадает, то их дополнительно упорядочить по количеству нулевых
// элементов в строке
package lab2;

import java.util.Random;
import java.util.Scanner;

public class Zad1 {
    
    private static int countOfNegative(int[][] arr, int row){
        int count = 0;
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] < 0) {
                count++;
            }
        }
        return count;
    }

    private static int countOfZero(int[][] arr, int row){
        int count = 0;
        for (int j = 0; j < arr[row].length; j++) {
            if (arr[row][j] == 0) {
                count++;
            }
        }
        return count;
    }

    private static void printCountOfZeroAndNegative(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println("\nВ строке " + i + ":");
            System.out.println(countOfNegative(arr, i) + " негативных элемента.");
            System.out.println(countOfZero(arr, i) + " нулевых элемента.");
        }
    }

    private static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
    }

    private static void bubbleSortRowsByNegativeAndZeroCount(int[][] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            boolean isSwapper = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                int countOfNegativeIncurrentRow = countOfNegative(arr, j);
                int countOfNegativeInnextRow = countOfNegative(arr, j + 1);

                if(countOfNegativeIncurrentRow < countOfNegativeInnextRow || 
                (
                    countOfNegativeIncurrentRow == countOfNegativeInnextRow
                    && countOfZero(arr, j) < countOfZero(arr, j + 1)
                )){
                    int[] temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isSwapper = true;
                }
            }
            if(!isSwapper) break;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = inputMatrixSize(scanner);
        int[][] matrix = new int[n][n];

        //Меню
        fillMatrixMenu(scanner, matrix, n);

        //Информация о массиве до сортировки
        printMatrix(matrix);
        printCountOfZeroAndNegative(matrix);

        //Сортировка
        bubbleSortRowsByNegativeAndZeroCount(matrix);
        
        //Информация о массиве после сортировки
        printMatrix(matrix);
        printCountOfZeroAndNegative(matrix);
    }

    public static int inputMatrixSize(Scanner scanner) {
        int n;

        do {
            System.out.print("Пожалуйста, введите размерность массива: ");
            n = scanner.nextInt();
        
            if (n <= 0) {
                System.out.println("Пожалуста, введите положительное число");
            }
        } while(n <= 0); 

        System.out.println("\nСпасибо! Это число подходит");

        return n;
    }

    public static void fillMatrixMenu(Scanner scanner, int[][] matrix, int n) {
        int choice;
        do { 
            System.out.println("\nМеню");
            System.out.println("0 - заполнить массив случайными числами");
            System.out.println("1 - заполнить массив вручную");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> fillMatrixWithRandom(matrix, n);
                case 1 -> fillMatrixWithManually(scanner, matrix, n);
                default -> System.out.println("Нет, либо 1, либо 0. Просто выбери один вариант");
            }
        } while (choice != 1 && choice != 0);
    }

    private static void fillMatrixWithRandom(int[][] matrix, int n){
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                  matrix[i][j] = random.nextInt(3) - 1;
            }
        }
    }

    private static void fillMatrixWithManually(Scanner scanner, int[][] matrix, int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
