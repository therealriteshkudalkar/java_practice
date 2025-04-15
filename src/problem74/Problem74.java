package problem74;

import java.util.*;

public class Problem74 {
    public int[] getOrderOptimized(int[][] tasks) {
        // Sort tasks according to enqueue time, processing time, orders available and sort them accordingly
        record Triple(int enqueueTime, int processingTime, int batchId) {}
        int[][] orderedTasks = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            int[] task = tasks[i];
            orderedTasks[i][0] = task[0];
            orderedTasks[i][1] = task[1];
            orderedTasks[i][2] = i;
        }
        Arrays.sort(orderedTasks, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) {
                    return o1[2] - o2[2];
                }
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Triple> readyQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.processingTime == o2.processingTime) {
                return o1.batchId - o2.batchId;
            }
            return o1.processingTime - o2.processingTime;
        });

        int timestamp = 0;
        int orderedTaskIndex = 0;
        List<Integer> taskIndexList = new ArrayList<>();

        while(orderedTaskIndex < tasks.length || !readyQueue.isEmpty()) {

            if (readyQueue.isEmpty() && timestamp < orderedTasks[orderedTaskIndex][0]) {
                timestamp = orderedTasks[orderedTaskIndex][0];
            }

            while(orderedTaskIndex < tasks.length && orderedTasks[orderedTaskIndex][0] <= timestamp) {
                readyQueue.add(new Triple(orderedTasks[orderedTaskIndex][0], orderedTasks[orderedTaskIndex][1], orderedTasks[orderedTaskIndex][2]));
                orderedTaskIndex++;
            }

            Triple currentlyProcessingTask = readyQueue.poll();
            timestamp += currentlyProcessingTask.processingTime;
            taskIndexList.add(currentlyProcessingTask.batchId);
        }
        return taskIndexList.stream().mapToInt(i -> i).toArray();
    }

    public int[] getOrder(int[][] tasks) {
        // Create a priority queue that contains all the tasks assigned according to the enqueue time
        // While the queue is not empty enqueue a task and process it
        // The tasks need to be ordered in the following way:
        // 1. enqueueTime
        // 2. processingTime
        // 3. batchId
        // Doing so we now have tasks coming in order of enqueue
        // Now pick the first task i.e. remove it from processing queue and add it into the available queue
        // so ticker starts from the enqueue time of this task
        // Now by enqueue + processing time, remove all the tasks from the tasks queue
        // for which enqueueTime <= (enqueueTime + processingTime of currentTask) and put it into available queue
        // In the available queue, the tasks need to be ordered in the following way:
        // 1. processingTime
        // 2. batchId
        record Triple(int enqueueTime, int processingTime, int batchId) {}
        PriorityQueue<Triple> sortedTasks = new PriorityQueue<>((o1, o2) -> {
            if (o1.enqueueTime == o2.enqueueTime) {
                if (o1.processingTime == o2.processingTime ) {
                    return Integer.compare(o1.batchId, o2.batchId);
                }
                return Integer.compare(o1.processingTime, o2.processingTime);
            }
            return Integer.compare(o1.enqueueTime, o2.enqueueTime);
        });
        PriorityQueue<Triple> availableQueue = new PriorityQueue<>((o1, o2) -> {
            if (o1.processingTime == o2.processingTime) {
                return Integer.compare(o1.batchId, o2.batchId);
            }
            return Integer.compare(o1.processingTime, o2.processingTime);
        });

        int i = 0;
        for(int[] task: tasks) {
            sortedTasks.add(new Triple(task[0], task[1], i++));
        }
        int[] processedTasks = new int[tasks.length];

        int timeStamp = 0;
        int index = 0;
        while(!sortedTasks.isEmpty()) {
            Triple newlyAddedTask = sortedTasks.poll();
            // Add this task to the available queue
            availableQueue.add(newlyAddedTask);

            // Add all the tasks from
            while(!availableQueue.isEmpty()) {
                Triple taskToBeProcessed = availableQueue.poll();
                processedTasks[index++] = taskToBeProcessed.batchId;

                // Update the timestamp so that
                // Here there can be different cases
                // One where timestamp is less than the enqueue time in which case, we select the max out of them
                timeStamp = Math.max(timeStamp, taskToBeProcessed.enqueueTime) + taskToBeProcessed.processingTime;

                // From the processing queue add all the task to available task queue if their enqueueTime is greater than
                while(!sortedTasks.isEmpty() && timeStamp >= sortedTasks.peek().enqueueTime) {
                    availableQueue.add(sortedTasks.poll());
                }
            }
        }

        return processedTasks;
    }
}
