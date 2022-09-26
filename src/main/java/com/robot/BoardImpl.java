package com.robot;

import java.util.*;

public class BoardImpl implements Board {

    private List<RobotImpl> robots;

    public BoardImpl() {
        this.robots = new ArrayList<>();
    }


    @Override
    public List<RobotImpl> getRobots() {
        return this.robots;
    }

    @Override
    public void addRobot(RobotImpl ro) {
        for (int i = 0; i < this.robots.size(); i++) {
            if (ro.getPoints() > robots.get(i).getPoints()) {
                this.robots.add(i, ro);
                return;
            }
        }
        this.robots.add(ro);
    }

    @Override
    public void showLeaderboard() {
        System.out.printf("%-10s %s %n", "Robot", "| Points");

        for (RobotImpl r : this.robots) {
            System.out.printf("%-10s %s %n", r.getName() + " the " + r.getType() + " robot", "| " + r.getPoints());
        }
    }
}

