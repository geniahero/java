// Найти наибольший среди локальных максимумов. (Элемент матрицы
// называется локальным максимумом, если он строго больше всех своих
// соседей).

package lab2;

import java.util.Scanner;

public class Zad2 {

    public static boolean isLocalMaximum(int[][] arr, int i, int j) {
        int element = arr[i][j];
    
        // Перебираем строки соседей от i-1 до i+1
        for (int p = i - 1; p <= i + 1; p++) {
            // Перебираем столбцы соседей от j-1 до j+1
            for (int q = j - 1; q <= j + 1; q++) {
            
            // 1. Проверяем выход за границы матрицы (подходит для прямоугольных матриц!)
                if (p < 0 || p >= arr.length || q < 0 || q >= arr[p].length) {
                    continue;
                }
            
            // 2. Пропускаем сам центральный элемент, его с самим собой сравнивать не надо
                if (p == i && q == j) {
                    continue;
                }
            
            // 3. Главное условие: если сосед больше или равен нашему элементу,
            // то наш элемент уже НЕ является СТРОГИМ локальным максимумом.
                if (arr[p][q] >= element) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static int minElementMatrix(int[][] arr) {
        int min = arr[0][0];
        for (int[] row : arr) {
            for (int elem : row) {
                if(min > elem) min = elem;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = MatrixUtils.inputMatrixSize(scanner);
        int[][] matrix = new int[n][n];

        //Меню
        MatrixUtils.fillMatrixMenu(scanner, matrix);

        //Информация о массиве до сортировки
        MatrixUtils.printMatrix(matrix);

        int minElement = minElementMatrix(matrix);
        int localMax = minElement;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(isLocalMaximum(matrix, i, j)){
                    if(localMax < matrix[i][j]){
                        localMax = matrix[i][j];
                    }
                }
            }
        }


        if(localMax != minElement) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(localMax == matrix[i][j]){
                        if(isLocalMaximum(matrix, i, j)){
                            System.out.println("Число matrix[" + i + "][" + j + "] = " + matrix[i][j] + " является наибольшим среди локальных максимумов");
                        }
                    }
                }
            }
        } else System.out.println("Не хочу тебя расстраивать, но в массиве нет локальных максимумов");
    }   
}
