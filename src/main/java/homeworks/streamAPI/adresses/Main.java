package homeworks.streamAPI.adresses;

import homeworks.streamAPI.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//5 Дан список адресов с полями street, city и zipCode. Создайте список уникальных городов.
public class Main {

    private static Set<String> getUnique(List<Adress> adressList) {
       return adressList.stream()
                .map(Adress::getCity)
                .collect(Collectors.toSet());
    }

    private static List<Adress> generateAddresses(int count){
        List<Adress> addressList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            addressList.add(
                    new Adress(
                            Utils.FAKER.address().streetName(),
                            Utils.FAKER.address().city(),
                            Utils.FAKER.address().zipCode()
                    )
            );
        }

        return addressList;
    }

    public static void main(String[] args) {
        List<Adress> adressList = generateAddresses(100);
        System.out.println(getUnique(adressList));

    }
}
