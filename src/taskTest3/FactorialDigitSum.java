package taskTest3;

import java.math.BigInteger;

public class FactorialDigitSum {
    public static void main(String[] args) {
        // Compute 100!
        BigInteger factorial = BigInteger.ONE;
        for (int i = 2; i <= 100; i++) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        // Convert the factorial to a string to sum the digits
        String factorialString = factorial.toString();
        int digitSum = 0;

        for (char digit : factorialString.toCharArray()) {
            digitSum += Character.getNumericValue(digit);
        }

        // Output the result
        System.out.println("The sum of the digits in 100! is: " + digitSum);
    }
}
