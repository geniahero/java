package lab2;

import java.util.Random;
import java.util.Scanner;

class MatrixUtils {
    public static void printMatrix(int[][] arr) {
        for (int[] row : arr) {
            for (int val : row) {
                System.out.printf("%5d", val);
            }
            System.out.println();
        }
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

    public static void fillMatrixMenu(Scanner scanner, int[][] matrix) {
        int choice;
        do { 
            System.out.println("\nМеню");
            System.out.println("0 - заполнить массив случайными числами");
            System.out.println("1 - заполнить массив вручную");
            System.out.print("Ваш выбор: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 0 -> fillMatrixWithRandom(matrix);
                case 1 -> fillMatrixWithManually(scanner, matrix);
                default -> System.out.println("Нет, либо 1, либо 0. Просто выбери один вариант");
            }
        } while (choice != 1 && choice != 0);
    }

    private static void fillMatrixWithRandom(int[][] matrix){
        Random random = new Random();
        for (int[] row : matrix) {
            for (int j = 0; j < row.length; j++) {
                row[j] = random.nextInt(3) - 1;
            }
        }
    }

    private static void fillMatrixWithManually(Scanner scanner, int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print("matrix[" + i + "][" + j + "] = ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }
}
