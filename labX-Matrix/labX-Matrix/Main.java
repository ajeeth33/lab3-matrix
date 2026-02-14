public class Main {
    public static void main(String[] args) {
        // --- Create and populate matrices ---
        Matrix A = new Matrix(2, 3);
        Matrix B = new Matrix(2, 3);
        A.populateRandom();
        B.populateRandom();

        System.out.println("Matrix A (2x3):");
        System.out.println(A);

        System.out.println("Matrix B (2x3):");
        System.out.println(B);

        // --- Add (valid) ---
        Matrix sum = A.add(B);
        System.out.println("A + B:");
        System.out.println(sum);

        // --- Multiply (valid): (2x3) * (3x2) = (2x2) ---
        Matrix C = new Matrix(3, 2);
        C.populateRandom();
        System.out.println("Matrix C (3x2):");
        System.out.println(C);

        Matrix product = A.multiply(C);
        System.out.println("A * C:");
        System.out.println(product);

        // --- Exception handling demo: add invalid sizes ---
        System.out.println("Trying invalid add (A + C)...");
        try {
            Matrix badAdd = A.add(C);
            System.out.println(badAdd); // should not happen
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }

        // --- Exception handling demo: multiply invalid sizes ---
        System.out.println("Trying invalid multiply (B * B)...");
        try {
            Matrix badMult = B.multiply(B);
            System.out.println(badMult); // should not happen
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}
