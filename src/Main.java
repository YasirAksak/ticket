import calculator.Calculator;
import check.ClickFile;
import cities.City;
import exception.FindFileException;
import exception.ValueException;


import java.util.List;
import java.util.Scanner;

public class Main {
    private static int age;
    private static int passengerType;
    private static String city;
    private static String placeCity;

    private static List<String> cityText;

    public static void main(String[] args) {



        Scanner scanner=new Scanner(System.in);

        System.out.print("Olduğunuz şehri söyleyin :");
        placeCity=scanner.next();

        ClickFile clickFile=new ClickFile(placeCity);
        Boolean click;
        try{
            click=clickFile.clickFileText();
            if (click==true){
                String[][] city1=clickFile.getCity1();


                int s = 1;
                while(s==1){

                    System.out.print("Yaşınızı giriniz :");
                    try {
                        age= scanner.nextInt();
                        if (age>0){

                        }
                        else {
                            throw new IllegalArgumentException("Pozitif sayı girin");
                        }
                    }
                    catch (IllegalArgumentException e){
                        e.getMessage();
                        continue;

                    }
                    System.out.print("Gideceğiniz şehri söyleyiniz:");

                    try {
                        String checkCity="";
                        city=scanner.next();
                        for (int i = 0; i < clickFile.getSize(); i++) {
                            for (int j = 0; j < 2; j++){
                                if (city1[i][j].equals(city)){

                                    checkCity=city1[i][j];
                                }

                            }
                        }
                        if(checkCity!=""){

                        }
                        else {
                            throw new IllegalArgumentException("Yanlış bilgi girişi");
                        }
                    }
                    catch (IllegalArgumentException e){
                        e.getMessage();
                        continue;
                    }



                    System.out.print("Yolculuk tipini giriniz (1 => Tek Yön , 2 => Gidiş Dönüş ) :");
                    try {

                        passengerType= scanner.nextInt();
                        if (passengerType==1 || passengerType==2){

                        }
                        else{
                            throw new ValueException("Yanlış bilgi girişi yaptınız");
                        }
                    }
                    catch (ValueException e) {
                        System.out.println(e.getMessage());
                        continue ;
                    }


                    City city2=new City(placeCity);
                    Calculator calculator=new Calculator(passengerType,age,city,city2);
                    calculator.findDistance();
                    calculator.calculator();

                    al:
                    for(;;) {
                        System.out.print("Devam etmek istemiyorsaniz=0 ama devam etmek istiyorsaniz=1 basin:");
                        int a=scanner.nextInt();
                        if(a==0 || a==1) {
                            s=a;
                            break;
                        }
                        else {
                            System.out.println("Lutfen 0 veya 1 giriniz!");
                            continue al;
                        }
                    }
                }
                clickFile.clickFileTextIn();
            }
            else {
                throw new FindFileException("Böyle bir dosya bulunamadı");
            }
        }
        catch (FindFileException e){
            System.out.println(e.getMessage());;
        }



    }
}