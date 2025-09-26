/*
Code Example: Activity Selection Problem
This is a classic problem where a greedy algorithm is proven to work optimally.

Problem: You are given a list of n activities. Each activity has a start time (start[i]) and a finish time (end[i]). How do you select the maximum number of activities that can be performed by a single person, assuming the person can only work on one activity at a time?

The Greedy Insight: The optimal strategy is to always pick the next activity that finishes first. This leaves the most time available for future activities.

Steps:

Sort all activities by their finish time.

Select the first activity from the sorted list.

For each subsequent activity, if its start time is greater than or equal to the finish time of the previously selected activity, then select it.
 */

import java.util.*;

// Class to represent an activity
class Activity {

    int start;
    int end;

    // Constructor
    public Activity(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}

public class GreedyActivitySelection {

    public static void selectActivities(List<Activity> activities) {
        // 1. Sort activities by their end time (greedy choice: earliest finish first)
        activities.sort(Comparator.comparingInt(a -> a.end));
        // This line does the same thing:
        // activities.sort((a1, a2) -> a1.end - a2.end);

        System.out.println("Activities sorted by finish time: " + activities);

        // 2. The first activity is always selected
        List<Activity> selected = new ArrayList<>();
        selected.add(activities.get(0));
        int lastSelectedIndex = 0;

        // 3. Iterate through the remaining activities
        for (int i = 1; i < activities.size(); i++) {
            // If this activity starts after the last selected activity finishes...
            if (activities.get(i).start >= activities.get(lastSelectedIndex).end) {
                // ...then select it!
                selected.add(activities.get(i));
                lastSelectedIndex = i; // update the index of the last selected activity
            }
        }

        // Print the result
        System.out.println("Selected activities: " + selected);
        System.out.println("Maximum number of non-conflicting activities: " + selected.size());
    }

    public static void main(String[] args) {
        // Create a list of activities: (start, end)
        List<Activity> activities = new ArrayList<>();
        activities.add(new Activity(1, 4));
        activities.add(new Activity(3, 5));
        activities.add(new Activity(0, 6));
        activities.add(new Activity(5, 7));
        activities.add(new Activity(3, 9));
        activities.add(new Activity(5, 9));
        activities.add(new Activity(6, 10));
        activities.add(new Activity(8, 11));
        activities.add(new Activity(8, 12));
        activities.add(new Activity(2, 14));
        activities.add(new Activity(12, 16));

        selectActivities(activities);
    }
}
