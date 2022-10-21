package at.ac.fhcampuswien;

import java.util.Random;
import java.util.Scanner;

public class App {


    // AUFGABE 1

    public static void oneMonthCalendar(int NumberOfDays, int DayOfStart) {
        int line = 0;
        int row = 0;

        for (int i = 1; i<=7; i++) {
            if (i == DayOfStart) {
                for (int j=1; j<=NumberOfDays; j++) {
                    if (j<=9) {
                        System.out.print(" " + j + " ");
                    } else {
                        System.out.print(j + " ");
                    }
                    line++;
                    if (line % 7 == 0) {
                        if (row <= 4) {
                            System.out.println("");
                        }
                        row++;
                    }
                }
            } else if (line < DayOfStart) {
                System.out.print("   ");
                line++;
            }
            if (NumberOfDays <=2) {
                System.out.print("");
            }
        }
        if (line % 7 != 0) {
            System.out.println();
        }

    }

    // AUFGABE 2

    public static long[] lcg (long xZero) {
        long m = (long) Math.pow(2, 31);
        long a = 1103515245;
        int c = 12345;
        long[] randomArray = new long[10];
        randomArray[0] = (a * xZero + c) % m;

        for (int i = 0; i<=8; i++) {
            randomArray[i+1] = (a * randomArray[i] + c) % m;
        }

        return randomArray;
    }


    // AUFGABE 3

    public static void guessingGame(int numberToGuess) {
        Scanner scanner = new Scanner(System.in);
        int input;

        for (int i = 1; i <= 10; i++) {
            input = scanner.nextInt();
            System.out.print("Guess number " + i + ": ");
            if (input == numberToGuess) {
                System.out.println("You won wisenheimer!");
                break;
            }
            if (input < numberToGuess && i != 10) {
                System.out.println("The number AI picked is higher than your guess.");
            }
            if (input > numberToGuess && i != 10) {
                System.out.println("The number AI picked is lower than your guess.");
            }
            if (i==10) {
                System.out.println("You lost! Have you ever heard of divide & conquer?");
                break;
            }
        }
    }

    public static int randomNumberBetweenOneAndHundred() {
        Random random = new Random();
        int randomNumber = random.nextInt(99) + 1;
        return randomNumber;
    }

    // AUFGABE 4

        // Inspiration von: https://www.java-forum.org/thema/inhalte-von-zwei-arrays-vertauschen.186529/ | last visit: 30.11.2019

     public static boolean swapArrays(int[] array1, int[] array2) {
         boolean comparison = false;

         if (array1.length == array2.length) {
             for (int i = 0; i < array1.length; i++) {
                 array1[i] = array1[i] + array2[i];          // 5 = 5 + 3 / 8
                 array2[i] = array1[i] - array2[i];          // 3 = 8 - 3 / 5
                 array1[i] = array1[i] - array2[i];          // 8 = 8 - 5 / 3

                 comparison = true;

             }
         }
         return comparison;
     }

     // AUFGABE 5

     // dieses Beispiel habe ich leider nicht geschafft

     // AUFGABE 6

        // Quelle für Modulo 11: https://de.wikipedia.org/wiki/Pr%C3%BCfziffer | last visit: 08.04.2022

    public static int checkDigit(int[] code) {
        int sumOfk;
        int sumOfModulo = 0;
        int rest;
        int digit = 0;
        int[]checkArray = new int[code.length];

        if (code.length <= 9 && code.length > 0) {
            for (int i = 0; i< code.length; i++) {          // Schleife für Erstellung des "Prüf-Array"
                checkArray[i] = i + 2;
            }
            for (int k = 0; k < code.length; k++) {         // Schleife für Berechnung
                sumOfk = code[k] * checkArray[k];
                sumOfModulo = sumOfModulo + sumOfk;
            }
            rest = sumOfModulo % 11;
            digit = 11 - rest;

            if (digit == 10) {
                digit = 0;
            } else if (digit == 11) {
                digit = 5;
            }
        }
        return digit;
    }



    public static void main(String[] args) {

        // AUFGABE 1

        oneMonthCalendar(30, 6);

        // AUFGABE 2

        long[] lcgArray;
        lcgArray = lcg(12345);


        // AUFGABE 3

        int randomNumber = randomNumberBetweenOneAndHundred();
        guessingGame(randomNumber);

        // AUFGABE 4

        int[] array1 = {1,2,3,4,5};
        int[] array2 = {100,99,60,44,2};
        swapArrays(array1, array2);

        // AUFGABE 5


       /* String experiment = "das Beispiel ist schwer";
        camelCase(experiment); */


        // AUFGABE 6

        int[] justForTest = {1,5,6,3,8,7,1};
        checkDigit(justForTest);

    }
}