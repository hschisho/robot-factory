package com.robot;

import java.util.ArrayList;
import java.util.List;

public class RobotImpl implements Robot {

    private String name;
    private String type;
    private List<String> tasks;
    private int points;

    public RobotImpl(String name, String type) {
        if (name == null || type == null) {
            throw new IllegalArgumentException("Name and type are required to build a robot. Exiting Bot-O-Mat.");
        }
        if (!type.toLowerCase().equals("unipedal")
                && !type.toLowerCase().equals("bipedal")
                && !type.toLowerCase().equals("quadrupedal")
                && !type.toLowerCase().equals("arachnid")
                && !type.toLowerCase().equals("radial")
                && !type.toLowerCase().equals("aeronautical")) {
            throw new IllegalArgumentException("Invalid type. Exiting Bot-O-Mat.");
        }
        this.name = name;
        this.type = type.toLowerCase();
        this.tasks = new ArrayList<>();
        this.points = 0;
    }


    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public List<String> getTasks() {
        return this.tasks;
    }

    @Override
    public int getPoints() {
        return this.points;
    }

    @Override
    public void setTasks(String input) {
        if (tasks.size() >= 5) {
            System.out.println("Maximum tasks reached. Your robot already has 5 tasks!");
            return;
        }
        if (input.equals("dishes")) {
            tasks.add("do the dishes");
        } else if (input.equals("sweep")) {
            tasks.add("sweep the house");
        } else if (input.equals("laundry")) {
            tasks.add("do the laundry");
        } else if (input.equals("recycling")) {
            tasks.add("take out the recycling");
        } else if (input.equals("lunch")) {
            tasks.add("make a sammich");
        } else if (input.equals("mow")) {
            tasks.add("mow the lawn");
        } else if (input.equals("rake")) {
            tasks.add("rake the leaves");
        } else if (input.equals("dog")) {
            tasks.add("give the dog a bath");
        } else if (input.equals("bake")) {
            tasks.add("bake some cookies");
        } else if (input.equals("carwash")) {
            tasks.add("wash the car");
        } else {
            System.out.println("Task not recognized, try again!");
            return;
        }

        System.out.println("Task added successfully! Task count: " + tasks.size());

    }

    @Override
    public void doTask() throws InterruptedException {
        String description = tasks.get(0);
        tasks.remove(0);
        if (description.equals("do the dishes")) {
            System.out.println("Doing the dishes...");
            Thread.sleep(1000);
            System.out.println("Task complete!");
            this.points++;
        } else if (description.equals("sweep the house")) {
            System.out.println("Sweeping the house...");
            Thread.sleep(3000);
            System.out.println("Task complete!");
            this.points += 3;
        } else if (description.equals("do the laundry")) {
            System.out.println("Doing the laundry...");
            Thread.sleep(10000);
            System.out.println("Ahh, the smell of those clean clothes.");
            this.points += 10;
        } else if (description.equals("take out the recycling")) {
            System.out.println("Taking out the recycling...");
            Thread.sleep(4000);
            System.out.println("Task complete!");
            this.points += 4;
        } else if (description.equals("make a sammich")) {
            System.out.println("Making a sammich...");
            Thread.sleep(7000);
            System.out.println("Mm, grilled cheese. My favorite!");
            this.points += 7;
        } else if (description.equals("mow the lawn")) {
            System.out.println("Mowing the lawn...");
            Thread.sleep(20000);
            System.out.println("Task complete!");
            this.points += 20;
        } else if (description.equals("rake the leaves")) {
            System.out.println("Raking the leaves...");
            Thread.sleep(18000);
            System.out.println("Task complete! Wanna jump in the leaf pile?");
            this.points += 18;
        } else if (description.equals("give the dog a bath")) {
            System.out.println("Giving the dog a bath...");
            Thread.sleep(14500);
            System.out.println("Task complete!");
            this.points += 14;
        } else if (description.equals("bake some cookies")) {
            System.out.println("Baking some cookies...");
            Thread.sleep(8000);
            System.out.println("Hot and fresh out of the oven...delicious!");
            this.points += 8;
        } else if (description.equals("wash the car")) {
            System.out.println("Washing the car...");
            Thread.sleep(20000);
            System.out.println("Squeaky clean!");
            this.points += 20;
        } else {
            System.out.println("Oops! Something went wrong...");
        }
    }
}

