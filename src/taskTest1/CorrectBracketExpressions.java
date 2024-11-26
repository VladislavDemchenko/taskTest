package taskTest1;

import java.util.Scanner;

public class CorrectBracketExpressions {
    public static void main(String[] args) {

        // Input n number from console
        int N = numberInsertHandler();

        // Count the number of variations
        int result = countCorrectBracketExpressions(N);

        // Result
        System.out.println("Number of valid parenthetical expressions for N = " + N + " : " + result);


    }

    private static int numberInsertHandler() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Insert a number: ");
        int N = -1;
        while(N < 0) {
            N = scanner.nextInt();
        }
        return N;
    }


    // Method for calculating the number of valid parenthetical expressions (Catalan number)
    public static int countCorrectBracketExpressions(int N) {

        //for zero parenthetical - zero combinations
        if (N == 0) {
            return 0;
        }

        // Initializing array
        int[] catalan = new int[N + 1];
        catalan[0] = 1;

        // Count Catalan numbers C(1), C(2), ..., C(N)
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }
        return catalan[N];
    }



}
