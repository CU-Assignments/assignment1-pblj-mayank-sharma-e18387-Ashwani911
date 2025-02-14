import java.util.Scanner;

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get matrix dimensions
        System.out.print("Enter the number of rows and columns for the matrices: ");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        // Initialize matrices
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];

        // Input matrices
        System.out.println("Enter Matrix 1 elements:");
        inputMatrix(scanner, matrix1);
        
        System.out.println("Enter Matrix 2 elements:");
        inputMatrix(scanner, matrix2);

        // Perform operations
        System.out.println("\nAddition:");
        printMatrix(addMatrices(matrix1, matrix2));

        System.out.println("\nSubtraction:");
        printMatrix(subtractMatrices(matrix1, matrix2));

        // Multiplication is valid only if cols of first = rows of second
        System.out.println("\nMultiplication:");
        printMatrix(multiplyMatrices(matrix1, matrix2));

        scanner.close();
    }

    // Method to take matrix input
    public static void inputMatrix(Scanner scanner, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    // Method for addition
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    // Method for subtraction
    public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
        int rows = matrix1.length, cols = matrix1[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] - matrix2[i][j];
            }
        }
        return result;
    }

    // Method for multiplication
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length, cols1 = matrix1[0].length;
        int rows2 = matrix2.length, cols2 = matrix2[0].length;

        // Check if multiplication is possible
        if (cols1 != rows2) {
            System.out.println("Multiplication not possible (Columns of Matrix 1 must match Rows of Matrix 2).");
            return new int[0][0]; // Return empty matrix
        }

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }
        return result;
    }

    // Method to print a matrix
    public static void printMatrix(int[][] matrix) {
        if (matrix.length == 0) return;

        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
