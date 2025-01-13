package problem82;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Problem82 {
    static class Task {
        private final char name;
        private int count;
        private int secondsTillNextSchedule;

        public Task(char name, int count) {
            this.name = name;
            this.count = count;
            this.secondsTillNextSchedule = 0;
        }

        public char getName() {
            return name;
        }

        public int getCount() {
            return count;
        }

        public int getSecondsTillNextSchedule() {
            return secondsTillNextSchedule;
        }

        public void incrementCount() {
            this.count++;
        }

        public void decrementCount() {
            this.count--;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public void setSecondsTillNextSchedule(int secondsTillNextSchedule) {
            this.secondsTillNextSchedule = secondsTillNextSchedule;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        TreeMap<Task, Integer> taskQueueMap = new TreeMap<>(((o1, o2) -> {
            if (o1.secondsTillNextSchedule == o2.secondsTillNextSchedule) {
                return -Integer.compare(o1.count, o2.count);
            }
            return Integer.compare(o1.secondsTillNextSchedule, o2.secondsTillNextSchedule);
        }));
        HashMap<Character, Task> taskNameMap = new HashMap<>();
        for (char task: tasks) {
            if (taskNameMap.containsKey(task)) {
                taskNameMap.get(task).incrementCount();
            } else {
                taskNameMap.put(task, new Task(task, 1));
            }
        }
        int secondsPassed = 0;
        while(!taskQueueMap.isEmpty()) {
            secondsPassed++;
        }
        return secondsPassed;
    }
}
