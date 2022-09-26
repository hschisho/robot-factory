package com.robot;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        boolean runMain = true;
        boolean hasExited = false;
        Board leaderboard = new BoardImpl();
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the 'Bot-O-Mat'");
        System.out.println("Create your robot and make it do tasks!");

        while (runMain) {

            System.out.println("\nWhat do you want to name your robot?");
            String name = scan.next();
            Thread.sleep(500);
            System.out.println("\nWhat type of robot are you creating?");
            Thread.sleep(500);
            System.out.println(
                    "Please enter one of the choices below:\n"
                            + "Unipedal\n"
                            + "Bipedal\n"
                            + "Quadrupedal\n"
                            + "Arachnid\n"
                            + "Radial\n"
                            + "Aeronautical\n");
            Scanner scan2 = new Scanner(System.in);
            String type = scan2.next().toLowerCase();

            RobotImpl newBot = new RobotImpl(name, type);
            System.out.println("Meet your robot, " + name + ", a swanky " + type + " robot!");
            Thread.sleep(1000);

            System.out.println(name + " the " + type + " robot can perform a series of tasks.");
            Thread.sleep(500);
            System.out.println("You can add 5 tasks to your robot's to-do list.");
            Thread.sleep(1000);

            // tasks
            boolean adding = true;
            while (adding) {
                System.out.println("Choose a task to add:");
                Thread.sleep(500);
                System.out.println(
                        "Enter 'dishes' to do the dishes\n"
                                + "Enter 'sweep' to sweep the house\n"
                                + "Enter 'laundry' to do the laundry\n"
                                + "Enter 'recycling' to take out the recycling\n"
                                + "Enter 'lunch' to make a sammich\n"
                                + "Enter 'mow' to mow the lawn\n"
                                + "Enter 'rake' to rake the leaves\n"
                                + "Enter 'dog' to give the dog a bath\n"
                                + "Enter 'bake' to bake some cookies\n"
                                + "Enter 'carwash' to wash the car\n");
                Scanner scan3 = new Scanner(System.in);
                String t = scan3.next();
                newBot.setTasks(t);
                Thread.sleep(1000);
                if (newBot.getTasks().size() == 5) {
                    adding = false;
                    System.out.println("Maximum tasks reached. Your robot has 5 tasks!");
                }
            }

            Thread.sleep(500);
            System.out.println("Now that " + name + " has some tasks to do, let's proceed.");
            Thread.sleep(1000);
            System.out.println("Your robot " + name + " can earn points by doing tasks.");
            Thread.sleep(500);
            System.out.println("Tasks that take longer to complete will earn more points.");

            boolean isPlaying = true;
            while (isPlaying) {
                System.out.println("\nWhat do you want to do? Type \"help\" for options.");
                String str = scan.next();
                switch (str.toLowerCase()) {
                    case "quit":
                    case "exit":
                        System.out.println("Thanks for visiting the Bot-O-Mat. Come back soon!");
                        isPlaying = false;
                        hasExited = true;
                        break;
                    case "task":
                        newBot.doTask();
                        break;
                    case "help":
                        System.out.println("\nTry typing one the following commands:");
                        printCommands();
                        break;
                    case "view":
                        System.out.println(name + " has these tasks left to complete:");
                        System.out.println(newBot.getTasks());
                        break;
                    case "points":
                        if (newBot.getPoints() == 1) {
                            System.out.println(name + " has " + newBot.getPoints() + " point.");
                        } else {
                            System.out.println(name + " has " + newBot.getPoints() + " points.");
                        }
                        break;
                    case "leaderboard":
                        if (leaderboard.getRobots().size() == 0) {
                            System.out.println("No robots have been added to the leaderboard yet.");
                        } else {
                            System.out.println("Bot-O-Mat Leaderboard:");
                            leaderboard.showLeaderboard();
                        }
                        break;
                    default:
                        System.out.println("Input not recognized. Type 'help' to see all commands.");
                        break;
                }
                if (newBot.getTasks().size() == 0) { // tasks complete
                    System.out.println("Congratulations, " + name + " has completed all the tasks!");

                    System.out.println("Would you like to add your robot to the leaderboard? Enter 'yes' or 'no':");
                    String strin = scan.next();
                    switch (strin.toLowerCase()) {
                        case "yes":
                            leaderboard.addRobot(newBot);
                            System.out.println("Successfully added " + name + " to the leaderboard!");
                            leaderboard.showLeaderboard();
                            break;
                        case "no":
                            break;
                        default:
                            System.out.println("Input not recognized. Type 'help' to see all commands.");
                            break;
                    }

                    isPlaying = false;
                }
            }
            if (!hasExited) {
                System.out.println("Would you like to make another robot? Enter 'yes' or 'no':");
                String str = scan.next();
                switch (str.toLowerCase()) {
                    case "yes":
                        break;
                    case "no":
                        System.out.println("Thanks for visiting the Bot-O-Mat. Come back soon!");
                        runMain = false;
                        break;
                    default:
                        System.out.println("Input not recognized. Type 'help' to see all commands.");
                        break;
                }
            } else {
                runMain = false;
            }
        }
        scan.close();
    }
    public static void printCommands() {
        System.out.printf("%-10s %s %n", "'task'", "| do a task");
        System.out.printf("%-10s %s %n", "'view'", "| view remaining tasks");
        System.out.printf("%-10s %s %n", "'points'", "| view this robot's points");
        System.out.printf("%-10s %s %n", "'leaderboard'", "| view Bot-O-Mat leaderboard");
        System.out.printf("%-10s %5s %n", "'exit'", "| exit Bot-O-Mat");
    }
}
