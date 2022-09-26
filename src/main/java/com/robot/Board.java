package com.robot;

import java.util.*;

public interface Board {

    List<RobotImpl> getRobots();

    void addRobot(RobotImpl ro);

    void showLeaderboard();

}
