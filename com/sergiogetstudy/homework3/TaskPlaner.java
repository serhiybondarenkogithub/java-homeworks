package com.sergiogetstudy.homework3;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

public class TaskPlaner {
    static Locale LOCALE = Locale.US;
    static final String SUNDAY_CMD = "SUNDAY", MONDAY_CMD = "MONDAY";
    static final String TUESDAY_CMD = "TUESDAY";
    static final String WEDNESDAY_CMD = "WEDNESDAY";
    static final String THURSDAY_CMD = "THURSDAY";
    static final String FRIDAY_CMD = "FRIDAY";
    static final String SATURDAY_CMD = "SATURDAY";
    static final String EXIT_CMD = "EXIT";
    static final String CHANGE_CMD = "CHANGE";
    static final String RESCHEDULE_CMD = "RESCHEDULE";

    static int DAY_INDEX = 0;
    static int TASK_INDEX = 1;

    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        String[] weekdays = new DateFormatSymbols(LOCALE).getWeekdays();

        initializeScedule(schedule, weekdays);

        setTask(schedule, "Sunday", "do home work");
        setTask(schedule, "Monday", "go to courses; watch a film");

        Scanner scanner = new Scanner(System.in);

        boolean isRun = true;
        while(isRun) {
            System.out.print("Please, input the day of the week: ");
            String[] userInput = scanner.nextLine().toUpperCase().split(" ");

            switch (userInput[0]) {
                case SUNDAY_CMD:
                case MONDAY_CMD:
                case TUESDAY_CMD:
                case WEDNESDAY_CMD:
                case THURSDAY_CMD:
                case FRIDAY_CMD:
                case SATURDAY_CMD: {
                    String[] task = getTask(schedule, userInput[0]);
                    System.out.printf("Your tasks for %s: %s%n", task[DAY_INDEX], task[TASK_INDEX]);
                    break;
                }
                case CHANGE_CMD:
                case RESCHEDULE_CMD: {
                    if (userInput.length == 1) continue;

                    switch (userInput[1]) {
                        case SUNDAY_CMD:
                        case MONDAY_CMD:
                        case TUESDAY_CMD:
                        case WEDNESDAY_CMD:
                        case THURSDAY_CMD:
                        case FRIDAY_CMD:
                        case SATURDAY_CMD: {
                            String[] task = getTask(schedule, userInput[1]);
                            System.out.printf("Please, input new tasks for %s: ", task[DAY_INDEX]);
                            String userTask = scanner.nextLine();
                            setTask(schedule, userInput[1], userTask);

                            System.out.println(Arrays.deepToString(schedule));
                            break;
                        }
                        default: {
                            System.out.println("Sorry, I don't understand you, please try again.");
                            break;
                        }
                    }
                    break;
                }
                case EXIT_CMD:{
                    isRun = false;
                    break;
                }
                default: {
                    System.out.println("Sorry, I don't understand you, please try again.");
                }
            }
        }
    }

    public static void initializeScedule(String[][] schedule, String[] weekdays) {
        for (int i = 0; i < schedule.length; i++) {
            schedule[i][DAY_INDEX] = weekdays[i + 1];
        }
    }

    public static String[] getTask(String[][] schedule, String dayOfTheWeek) {
        for (String[] items : schedule) {
            if (Objects.equals(dayOfTheWeek.toUpperCase(), items[DAY_INDEX].toUpperCase())) {
                return new String[]{items[DAY_INDEX], items[TASK_INDEX]};
            }
        }
        return new String[] {"undefined", "null"};
    }

    public static void setTask(String[][] schedule, String dayOfTheWeek, String task) {
        for (int i = 0; i < schedule.length; i++) {
            if(Objects.equals(dayOfTheWeek.toUpperCase(), schedule[i][DAY_INDEX].toUpperCase())) {
                schedule[i][TASK_INDEX] = task;
                break;
            };
        }
    }
}
