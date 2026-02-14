import java.util.Random;

public class Matrix {
    private int[][] data;

    // Constructor: rows x cols
    public Matrix(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and cols must be > 0");
        }
        data = new int[rows][cols];
    }

    // Constructor: from existing 2D array (deep copy)
    public Matrix(int[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new IllegalArgumentException("Invalid data array");
        }
        int rows = data.length;
        int cols = data[0].length;

        // check rectangular
        for (int r = 0; r < rows; r++) {
            if (data[r] == null || data[r].length != cols) {
                throw new IllegalArgumentException("Array must be rectangular");
            }
        }

        this.data = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                this.data[r][c] = data[r][c];
            }
        }
    }

    public void populateRandom() {
        Random rand = new Random();
        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[0].length; c++) {
                data[r][c] = rand.nextInt(10) + 1; // 1 to 10
            }
        }
    }

    public Matrix add(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix is null");
        }

        if (this.data.length != other.data.length || this.data[0].length != other.data[0].length) {
            throw new IllegalArgumentException("Matrices must have same dimensions to add");
        }

        int rows = data.length;
        int cols = data[0].length;
        Matrix result = new Matrix(rows, cols);

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                result.data[r][c] = this.data[r][c] + other.data[r][c];
            }
        }

        return result;
    }

    public Matrix multiply(Matrix other) {
        if (other == null) {
            throw new IllegalArgumentException("Other matrix is null");
        }

        int aRows = this.data.length;
        int aCols = this.data[0].length;
        int bRows = other.data.length;
        int bCols = other.data[0].length;

        if (aCols != bRows) {
            throw new IllegalArgumentException("Invalid dimensions for multiplication: "
                    + aRows + "x" + aCols + " cannot multiply " + bRows + "x" + bCols);
        }

        Matrix result = new Matrix(aRows, bCols);

        for (int r = 0; r < aRows; r++) {
            for (int c = 0; c < bCols; c++) {
                int sum = 0;
                for (int k = 0; k < aCols; k++) {
                    sum += this.data[r][k] * other.data[k][c];
                }
                result.data[r][c] = sum;
            }
        }

        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int r = 0; r < data.length; r++) {
            sb.append("[ ");
            for (int c = 0; c < data[0].length; c++) {
                sb.append(String.format("%3d", data[r][c]));
                if (c < data[0].length - 1) sb.append(" ");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }
}
