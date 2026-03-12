import java.util.Arrays;

public class ArraysAdvanced {

    // Matrix multiplication
    static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length, m = B[0].length, k = B.length;
        int[][] C = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                for (int p = 0; p < k; p++) C[i][j] += A[i][p] * B[p][j];
        return C;
    }

    static void printMatrix(int[][] m, String label) {
        System.out.println(label);
        for (int[] row : m) System.out.println("  " + Arrays.toString(row));
    }

    // Spiral matrix traversal
    static int[] spiralOrder(int[][] matrix) {
        int top=0, bottom=matrix.length-1, left=0, right=matrix[0].length-1, idx=0;
        int[] res = new int[matrix.length * matrix[0].length];
        while (top<=bottom && left<=right) {
            for (int i=left;  i<=right;  i++) res[idx++] = matrix[top][i];   top++;
            for (int i=top;   i<=bottom; i++) res[idx++] = matrix[i][right]; right--;
            if (top<=bottom) { for (int i=right; i>=left; i--) res[idx++] = matrix[bottom][i]; bottom--; }
            if (left<=right) { for (int i=bottom;i>=top;  i--) res[idx++] = matrix[i][left];  left++; }
        }
        return res;
    }

    public static void main(String[] args) {
        // Sorting and searching
        System.out.println("=== Sort & Binary Search ===");
        int[] data = {64, 34, 25, 12, 22, 11, 90, 42};
        System.out.println("Before: " + Arrays.toString(data));
        Arrays.sort(data);
        System.out.println("After:  " + Arrays.toString(data));
        int idx = Arrays.binarySearch(data, 42);
        System.out.println("binarySearch(42) → index " + idx);

        // Matrix multiply
        int[][] A = {{1,2,3},{4,5,6}};
        int[][] B = {{7,8},{9,10},{11,12}};
        printMatrix(A, "\nMatrix A (2x3):");
        printMatrix(B, "Matrix B (3x2):");
        printMatrix(multiply(A,B), "A × B (2x2):");

        // Spiral
        int[][] spiral = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println("\nSpiral order of 3x3 matrix:");
        System.out.println(Arrays.toString(spiralOrder(spiral)));
    }
}
