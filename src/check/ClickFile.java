package check;

import cities.City;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ClickFile {
    private String placeCity;
    private String[][] city1;
    private int size;

    public ClickFile(String placeCity) {
        this.placeCity = placeCity;
    }

    public  boolean clickFileText(){

        String klasorYolu = "C:\\Users\\acer\\Desktop\\BusTicketPriceCalculator\\src\\cities"; // Kontrol edilecek klasörün yolu
        File klasor = new File(klasorYolu);
        List<String> fileText=new ArrayList<>();
        Boolean click=false;

        if (klasor.isDirectory()) {
            File[] dosyalar = klasor.listFiles();

            if (dosyalar != null) {
                for (File dosya : dosyalar) {
                    if (dosya.isFile() && dosya.getName().endsWith(".txt")) {
                        fileText.add(dosya.getName().replace(".txt",""));
                    }
                }
            }
        }
        for (int i=0;i<fileText.size();i++){

            if (fileText.get(i).equals(placeCity)){
                click=true;
                break;
            }

        }
        return click;
    }
    public void clickFileTextIn(){
        City cityCLass=new City(placeCity);


        size = cityCLass.getLines().size();

        city1 = new String[size][2];

        for (int i = 0; i < size; i++) {
            String[] lineElements = cityCLass.getLines().get(i).split(",");
            for (int j = 0; j < 2; j++) {
                city1[i][j] = lineElements[j].replace(" ","");
            }
        }
    }

    public int getSize() {
        return size;
    }

    public String[][] getCity1() {
        return city1;
    }
}
