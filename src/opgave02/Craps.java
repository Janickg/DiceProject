package opgave02;

import java.util.Scanner;

public class Craps {

    private static int point = 0;//felt variabel der gemmer summen fra første kast og bruger den i continueGame metode
    private static int wins = 0;
    private static int losses = 0;

    public static void main(String[] args) {
        playCrabs(); //metode der starter spillet
        printStats();
    }

    public static int[] rollDice() {
        int[] rolls = new int[2]; //array der gemmer terninge kast
        rolls[0] = (int) (Math.random() * 6 + 1); //terninger
        rolls[1] = (int) (Math.random() * 6 + 1);
        return rolls;
    }

    public static void playCrabs() {
        String answer1 = playAgain();

        while (!answer1.equals("nej")) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tryk enter for at starte");
            String answer = scanner.nextLine(); //scanner der registrer user input for at slå terning

            int[] rolls1 = rollDice();

            int rollsSum = rolls1[0] + rolls1[1];
            if (rollsSum == 7 || rollsSum == 11) { //Win condition på første slag
                System.out.println("Du slog: " + rolls1[0] + " og " + rolls1[1] + " = " + rollsSum + ", du vandt!");
                answer1 = playAgain();
                wins++;
            } else if (rollsSum == 2 || rollsSum == 3 || rollsSum == 12) { //lose condtion på første slag
                System.out.println("Du slog: " + rolls1[0] + " og " + rolls1[1] + " = " + rollsSum + ", du tabte!");
                answer1 = playAgain();
                losses++;
            } else {
                point = rollsSum;
                System.out.println("Du slog " + rolls1[0] + " og " + rolls1[1] + ", du skal nu ramme " + rollsSum + " point.");
                if (!continuegame(point)) {
                    answer1 = playAgain();
                }
            }//metode for at fortsætte spillet hvis hverken win eller lose condition opfyldes retunere false hvis spillet skal stoppes
        }
    }

    public static String playAgain () {
        System.out.println("Vil du spille igen? (ja/nej)");
        Scanner input = new Scanner(System.in);
        String answer1 = input.nextLine();
        return answer1;
    }

    public static boolean continuegame(int point) { //metode for at fortsætte spillet
        Scanner scan = new Scanner(System.in); //scanner der tager user input kører spillet videre
        System.out.println("Tryk enter for at rulle videre. ");
        String answer = scan.nextLine();

        while (answer == "") { //loop der slår terning hver gang der registrers user input
            int[] faces = rollDice(); //array som gemmer terningkast
            System.out.println("Terning 1: " + faces[0]); //printer terning slag ud
            System.out.println("Terning 2: " + faces[1]);

            int sum = faces[0] + faces[1]; //integer der gemmer summen af begge slag

            if (sum == point) { //win condtioin
                System.out.println("Du slog " + faces[0] + " og " + faces[1] + " = " + sum + ", du har vundet! ");
                wins++;
                return false;
            } else if (sum == 7) {//lose condition
                System.out.println("Du slog " + faces[0] + " og " + faces[1] + " = " + sum + ", du har tabt! ");
                losses++;
                return false;
            }
            System.out.println("Tryk enter for at rulle. ");
            answer = scan.nextLine();
        }
        return true;
    }

    public static void printStats() {
        System.out.println("Antal wins: " + wins);
        System.out.println("Antal losses: " + losses);
    }
}