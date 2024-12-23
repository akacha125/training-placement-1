import java.util.Random;

public class RandomNumber {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNum = random.nextInt(100); // Generate a number between 0 and 99
        System.out.println("Random Number: " + randomNum);
    }
}
