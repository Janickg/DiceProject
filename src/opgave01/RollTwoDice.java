package opgave01;

import java.util.Scanner;

public class RollTwoDice {
    private static int sum = 0;
    private static int sameFaces = 0;
    private static int biggestThrow = 0;
    private static int[] amountFace = new int[6];

    public static void main(String[] args) {
        playDice(rollDice());
        printStats();
    }

    public static int[] rollDice() {
        int[] rolls = new int[2];
        rolls[0] = (int) (Math.random() * 6 + 1);
        rolls[1] = (int) (Math.random() * 6 + 1);
        return rolls;
    }

    public static void playDice(int[] dice) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Rul en terning? ('ja/nej') ");
        String answer = scanner.nextLine();
        while (!answer.equals("nej")) {
            int[] faces = rollDice();
            System.out.println("Terning 1: " + faces[0]);
            System.out.println("Terning 2: " + faces[1]);

            Updatestats(faces);

            System.out.print("Rul en terning? ('ja/nej') ");
            answer = scanner.nextLine();
        }
    }

    public static void Updatestats(int[] faces) {
        sum += faces[0] + faces[1];
        if (faces[0] == faces[1]) {
            sameFaces++;
        }

        int sumOfTwoDices = faces[0] + faces[1];
        for (int index = 0; index < faces.length; index++) {
            if (sumOfTwoDices > biggestThrow) {
                int largestSumOfTwoDices = faces[0] + faces[1];
                biggestThrow = largestSumOfTwoDices;
            }
            amountFace[faces[index] - 1]++;
        }
    }

    public static void printStats() {
        System.out.println("Summen af terningerne for alle kast: " + sum);
        System.out.println("Antallet af kast med samme øjne: " + sameFaces);
        System.out.println("Største antal øjne i ét kast: " + biggestThrow);
        for (int index = 0; index < amountFace.length; index++) {
            System.out.println("Tallet " + (index + 1) + ": " +amountFace[index] + " gange");
        }
    }
}