package cities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class City {

    private List<String> lines;
    private String placeCity;




    public City(String placeCity) {

        this.placeCity = placeCity;
        getCity();
    }

    public void getCity(){

        String filePath = "C:\\Users\\acer\\Desktop\\BusTicketPriceCalculator\\src\\cities\\"+placeCity+".txt";

        try {
            lines = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public List<String> getLines() {
        return lines;
    }

}
