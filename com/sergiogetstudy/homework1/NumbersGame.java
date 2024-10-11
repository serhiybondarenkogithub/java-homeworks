package com.sergiogetstudy.homework1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class NumbersGame {
    static String[][] QUESTION_MATRIX = {
            {"1939", "When did the World War II begin?"},
            {"1981", "What year is recognized as the year the Tim Berners-Lee invented the World Wide Web?"},
            {"1939", "When did the Soviet Union collapse?"},
            {"1789", "When was French Revolution formed?"},
        };
    static int ANSWER_POSITION = 0;
    static int QUESTION_POSITION = 1;

    public static void main(String[] args) {
        Random random = new Random();
        int randomNum = random.nextInt(QUESTION_MATRIX.length);

        String randomQuestion = QUESTION_MATRIX[randomNum][QUESTION_POSITION];
        int answerToQuestion = Integer.parseInt(QUESTION_MATRIX[randomNum][ANSWER_POSITION]);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Let the game begin!");
        System.out.print("Enter your name: ");
        String name = scanner.next();
        System.out.println(randomQuestion);

        int[] inputNumbersLog = new int[1];

        while (true) {

            while (!scanner.hasNextInt()) {
                System.out.println("Wrong year format...");
                scanner.next();
            }

            int userNum = scanner.nextInt();

            inputNumbersLog[inputNumbersLog.length - 1] = userNum;

            if(userNum < answerToQuestion) {
                System.out.println("Your number is too small. Please, try again.");
            } else if(userNum > answerToQuestion) {
                System.out.println("Your number is too big. Please, try again.");
            } else {
                System.out.printf("Congratulations, %s%n", name);

                Arrays.sort(inputNumbersLog);

                System.out.printf("Your numbers: %s", Arrays.toString(inputNumbersLog));
                break;
            }
            inputNumbersLog = Arrays.copyOf(inputNumbersLog, inputNumbersLog.length + 1);
        }
    }
}
