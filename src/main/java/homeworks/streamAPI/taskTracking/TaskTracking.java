package homeworks.streamAPI.taskTracking;

//6 Дана мапа, где ключ – id задачи, а значение – список записей о работе.
//Запись о работе содержит id сотрудника и время, затраченное на задачу.
//Подсчитайте общее время выполнения каждой задачи.
//Подсчитайте суммарное время выполнения всех задач.

import homeworks.streamAPI.Utils;

import java.util.*;
import java.util.stream.Collectors;

public class TaskTracking {
    private static Map<Integer, List<OperatingTime>> taskIdToTasks = new HashMap<>();

    public static Map<Integer, Integer> getTimePerTask() {
        return taskIdToTasks.entrySet().stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                v -> v.getValue().stream().mapToInt(el -> el.getTimeInSec()).sum()
                        ));
    }

    public static int getSumTime() {
        return taskIdToTasks.values()
                .stream().flatMap(Collection::stream)
                .mapToInt(OperatingTime::getTimeInSec)
                .sum();
    }

    public static void main(String[] args) {
        taskIdToTasks.put(1, new ArrayList<>());
        taskIdToTasks.put(2, new ArrayList<>());
        taskIdToTasks.put(3, new ArrayList<>());
        taskIdToTasks.put(4, new ArrayList<>());
        taskIdToTasks.put(5, new ArrayList<>());
        for (int i = 0; i < 20; i++) {
            List<OperatingTime> operatingTimes = taskIdToTasks.get(Utils.FAKER.number().numberBetween(1, 6));
            operatingTimes.add(new OperatingTime(i, Utils.FAKER.number().randomDigit()));
        }
        System.out.println(taskIdToTasks);
        System.out.println(getTimePerTask());
        System.out.println(getSumTime());
    }
}
