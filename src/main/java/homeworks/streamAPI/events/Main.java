package homeworks.streamAPI.events;

import homeworks.streamAPI.Utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//4 Дан список событий с полями name и date. Найдите ближайшее к текущей дате событие.
public class Main {

    public static void main(String[] args) {
        List<Event> eventList = generateEvents(10);

        System.out.println(getLatestEvent(eventList));
    }

    private static List<Event> generateEvents(int count){
        List<Event> eventList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            eventList.add(
                    new Event(Utils.FAKER.aquaTeenHungerForce().character(),
                            LocalDate.of(1990 + count, 6, 20))
            );
        }

        return eventList;
    }

    private static Event getLatestEvent(List<Event> eventList) {
        return eventList.stream()
                .max((o1, o2)-> o2.getDate().compareTo(o1.getDate()))
                .get();
    }
}
