package calculator;

import cities.City;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private  int passengerType;
    private  int age;


    private String city;

    private double distance;
    private  double price=0.10;
    private City city1;


    public Calculator(int passengerType, int age,String city,City city1) {
        this.passengerType = passengerType;
        this.age = age;
        this.city=city;
        this.city1=city1;
    }




    public void findDistance(){

        List<String> lines = city1.getLines();
        int size = lines.size();

        String[][] city = new String[size][2];

        for (int i = 0; i < size; i++) {
            String[] lineElements = lines.get(i).split(",");
            for (int j = 0; j < 2; j++) {
                city[i][j] = lineElements[j].replace(" ","");
            }
        }

        for (int i = 0; i < size; i++) {
           for (int j = 0; j < 2; j++){
               if (city[i][j].equals(this.city)){
                   distance=Double.valueOf(city[i][1]);

               }
           }
        }
    }
    public  void calculator(){
        price=price*distance;
        if(age<12){
            price-= price*0.5;
            if (passengerType==2) {
                price-=price*0.20;
            }
        }
        else if(age>=12 && age<=24){
            price-= price*0.1;
            if (passengerType==2) {
                price-=price*0.20;
            }
        }
        else if (age>=65) {
            price-= price*0.3;
            if (passengerType==2) {
                price-=price*0.20;
            }
        }
        System.out.println("Toplam Tutar "+ price+" TL");
    }
}
