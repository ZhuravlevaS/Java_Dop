package homeworks.streamAPI.adresses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Adress {
    private String street;
    private String city;
    private String zipCode;
}
