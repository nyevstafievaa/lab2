import java.util.Scanner;
import java.util.Random;

public class MatrixOperations {
    private static final int MAX_SIZE = 20;
    private static final int RANDOM_MIN = 0;
    private static final int RANDOM_MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть спосіб створення матриці:");
        System.out.println("1. Ввести матрицю з клавіатури");
        System.out.println("2. Згенерувати матрицю випадковим чином");
        System.out.print("Ваш вибір: ");
        int choice = scanner.nextInt();

        int[][] matrix;

        switch (choice) {
            case 1:
                matrix = inputMatrix(scanner);
                break;
            case 2:
                matrix = generateRandomMatrix(scanner);
                break;
            default:
                System.out.println("Невірний вибір");
                return;
        }

        printMatrix(matrix);

        int min = findMin(matrix);
        int max = findMax(matrix);
        double average = calculateAverage(matrix);

        System.out.println("Мінімальний елемент: " + min);
        System.out.println("Максимальний елемент: " + max);
        System.out.println("Середнє арифметичне: " + average);
    }

    private static int[][] inputMatrix(Scanner scanner) {
        System.out.print("Введіть кількість рядків матриці (не більше " + MAX_SIZE + "): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці (не більше " + MAX_SIZE + "): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || rows > MAX_SIZE || cols <= 0 || cols > MAX_SIZE) {
            System.out.println("Некоректні розміри матриці");
            System.exit(1);
        }

        int[][] matrix = new int[rows][cols];

        System.out.println("Введіть елементи матриці:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Елемент [" + (i+1) + "][" + (j+1) + "]: ");
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    private static int[][] generateRandomMatrix(Scanner scanner) {
        System.out.print("Введіть кількість рядків матриці (не більше " + MAX_SIZE + "): ");
        int rows = scanner.nextInt();
        System.out.print("Введіть кількість стовпців матриці (не більше " + MAX_SIZE + "): ");
        int cols = scanner.nextInt();

        if (rows <= 0 || rows > MAX_SIZE || cols <= 0 || cols > MAX_SIZE) {
            System.out.println("Некоректні розміри матриці");
            System.exit(1);
        }

        int[][] matrix = new int[rows][cols];
        Random random = new Random();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(RANDOM_MAX - RANDOM_MIN + 1) + RANDOM_MIN;
            }
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println("Матриця:");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int findMin(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element < min) {
                    min = element;
                }
            }
        }
        return min;
    }

    private static int findMax(int[][] matrix) {
        int max = Integer.MIN_VALUE;
        for (int[] row : matrix) {
            for (int element : row) {
                if (element > max) {
                    max = element;
                }
            }
        }
        return max;
    }

    private static double calculateAverage(int[][] matrix) {
        int sum = 0;
        int count = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sum += element;
                count++;
            }
        }
        return (double) sum / count;
    }
}
