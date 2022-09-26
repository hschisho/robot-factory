package com.robot;

import java.util.List;

public interface Robot {

    String getName();

    String getType();

    List<String> getTasks();

    int getPoints();

    void setTasks(String input);

    void doTask() throws InterruptedException;


}
