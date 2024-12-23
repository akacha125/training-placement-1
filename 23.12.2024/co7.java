import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base: ");
        int base = scanner.nextInt();
        System.out.print("Enter exponent: ");
        int exponent = scanner.nextInt();

        long result = 1;
        for (int i = 1; i <= exponent; i++) {
            result *= base;
        }

        System.out.println("Result: " + result);
    }
}
