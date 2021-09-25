package com.jobSolutions.model;

import java.util.ArrayList;
import java.util.List;

public class BreakSequence {
    private final List<Break> breakSequence;

    public BreakSequence() {
        this.breakSequence = new ArrayList<>();
    }

    public List<Break> getBreakSequence() {
        return breakSequence;
    }

    //TODO: method reading data from files e.g from csv file

    public void createExampleDataForPreviousBreakSequence() {
        //Example breaks creation
        Break break1 = new Break();
        break1.setPaidBreakTime(0, 20)
                .setRequiredWorkingTime(5, 0)
                .setUntil(2020, 5, 13);
        Break break2 = new Break();
        break2.setPaidBreakTime(0, 15)
                .setFrom(2020, 5, 23)
                .setUntil(2020, 9, 13);
        Break break3 = new Break();
        break3.setPaidBreakTime(0, 20)
                .setFrom(2020, 9, 23);

        this.breakSequence.add(break1);
        this.breakSequence.add(break2);
        this.breakSequence.add(break3);
    }

    public void createExampleDataForNewBreakSequence() {
        //Example breaks creation
        Break break4 = new Break();
        break4.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 30)
                .setUntil(2021, 1, 15);
        Break break5 = new Break();
        break5.setPaidBreakTime(0, 10)
                .setRequiredWorkingTime(2, 0)
                .setFrom(2021, 1, 25)
                .setUntil(2021, 8, 15);
        Break break6 = new Break();
        break6.setPaidBreakTime(0, 20)
                .setFrom(2021, 8, 25);

        this.breakSequence.add(break4);
        this.breakSequence.add(break5);
        this.breakSequence.add(break6);
    }

    public void createExampleOverlapingDataForNewBreakSequence() {
        //Example breaks creation
        Break break7 = new Break();
        break7.setPaidBreakTime(0, 15)
                .setRequiredWorkingTime(7, 0)
                .setUntil(2021, 2, 15);
        Break break8 = new Break();
        break8.setPaidBreakTime(0, 10)
                .setRequiredWorkingTime(2, 0)
                .setFrom(2021, 1, 25)
                .setUntil(2021, 8, 15);
        Break break9 = new Break();
        break9.setPaidBreakTime(0, 20)
                .setFrom(2021, 8, 25);

        this.breakSequence.add(break7);
        this.breakSequence.add(break8);
        this.breakSequence.add(break9);
    }
}
