package module1.arrays;

// Two-dimensional arrays - matrix representation
public class TwoDimensionalArray {
    public static void main(String[] args) {
        // 2D array (3 rows, 3 columns)
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Matrix:");
        // Nested loop to traverse 2D array
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        // Accessing specific element
        System.out.println("\nElement at [1][2]: " + matrix[1][2]);
    }
}
