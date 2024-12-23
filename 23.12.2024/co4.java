import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int gcd = a;
        int tempB = b;

        while (tempB != 0) {
            int temp = tempB;
            tempB = gcd % tempB;
            gcd = temp;
        }

        int lcm = (a * b) / gcd;
        System.out.println("LCM: " + lcm);
    }
}
