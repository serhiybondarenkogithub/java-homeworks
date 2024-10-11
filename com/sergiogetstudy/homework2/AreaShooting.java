package com.sergiogetstudy.homework2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class AreaShooting {
    public static int ROWS_NUM = 5;
    public static int COLUMNS_NUM = 5;
    public static int TARGET_SIZE = 3;
    public static char EMPTY_SYMBOL = '-';
    public static char SHOOT_SYMBOL = '*';
    public static char TARGET_SYMBOL = 'x';


    public static void main(String[] args) {
        char[][] gameArea = new char[ROWS_NUM][COLUMNS_NUM];
        for (int i = 0; i < ROWS_NUM; i++) {
            Arrays.fill(gameArea[i], EMPTY_SYMBOL);
        }

        Random random = new Random();
        boolean isVerticalTarget = random.nextBoolean();
        int targetRowNum;
        int targetColNum;
        if(isVerticalTarget) {
            targetRowNum = random.nextInt(ROWS_NUM - TARGET_SIZE + 1);
            targetColNum = random.nextInt(COLUMNS_NUM);
        } else {
            targetRowNum = random.nextInt(ROWS_NUM);
            targetColNum = random.nextInt(COLUMNS_NUM - TARGET_SIZE + 1);
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("All set. Get ready to rumble!");

        int userRowNum;
        int userColNum;

        int hitCount = 0;
        boolean isWin = false;

        while(true) {
            for (int i = 0; i < COLUMNS_NUM + 1; i++) {
                System.out.print(i + " | ");
            }

            System.out.println();

            for (int i = 0; i < ROWS_NUM; i++) {
                System.out.print(i + 1 + " ");
                for (int j = 0; j < COLUMNS_NUM; j++) {
                    System.out.print("| " + gameArea[i][j] + " ");
                    if(j == COLUMNS_NUM - 1) {
                        System.out.print("|");
                    }
                }
                System.out.println();
            }
            if(isWin) break;

            do {
                System.out.print("Enter the row number: ");
                while(!scanner.hasNextInt()) {
                    System.out.print("The number must be an integer: ");
                    scanner.next();
                }
                userRowNum = scanner.nextInt();

                if(userRowNum > 0 && userRowNum <= ROWS_NUM) {
                    break;
                } else {
                    System.out.printf("The number must be an less or than equal %d: ", ROWS_NUM);
                }
            } while(true);

            do {
                System.out.print("Enter the column number: ");
                while(!scanner.hasNextInt()) {
                    System.out.print("The number must be an integer: ");
                    scanner.next();
                }
                userColNum = scanner.nextInt();

                if(userColNum > 0 && userColNum <= ROWS_NUM) {
                    break;
                } else {
                    System.out.printf("The number must be an less or than equal %d: ", COLUMNS_NUM);
                }
            } while(true);

            gameArea[userRowNum - 1][userColNum - 1] = SHOOT_SYMBOL;

            for (int i = 0; i < TARGET_SIZE; i++) {
                if(isVerticalTarget) {
                    if(userRowNum - 1 == targetRowNum + i && userColNum - 1 == targetColNum) {
                        gameArea[userRowNum - 1][userColNum - 1] = TARGET_SYMBOL;
                        hitCount++;
                        if(hitCount == TARGET_SIZE) {
                            System.out.println("You have won!");
                            isWin = true;
                        }
                    }
                } else {
                    if(userRowNum - 1 == targetRowNum && userColNum - 1 == targetColNum + i) {
                        gameArea[userRowNum - 1][userColNum - 1] = TARGET_SYMBOL;
                        hitCount++;
                        if(hitCount == TARGET_SIZE) {
                            System.out.println("You have won!");
                            isWin = true;
                        }
                    }
                }
            }
        }
    }
}