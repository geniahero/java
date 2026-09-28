// Дана матрица A(n,m). Найти количество отрицательных и нулевых
// элементов в каждой строке. Отсортировать строки матрицы по количеству
// отрицательных элементов. Если есть строки у которых число отрицательных
// элементов совпадает, то их дополнительно упорядочить по количеству нулевых
// элементов в строке
package lab2;

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
        int n = MatrixUtils.inputMatrixSize(scanner);
        int[][] matrix = new int[n][n];

        //Меню
        MatrixUtils.fillMatrixMenu(scanner, matrix);

        //Информация о массиве до сортировки
        MatrixUtils.printMatrix(matrix);
        printCountOfZeroAndNegative(matrix);

        //Сортировка
        bubbleSortRowsByNegativeAndZeroCount(matrix);
        
        //Информация о массиве после сортировки
        MatrixUtils.printMatrix(matrix);
        printCountOfZeroAndNegative(matrix);
    }
}
