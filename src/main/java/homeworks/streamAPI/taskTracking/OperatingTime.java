package homeworks.streamAPI.taskTracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class OperatingTime {
    private int employeeId;
    private int timeInSec;
}
