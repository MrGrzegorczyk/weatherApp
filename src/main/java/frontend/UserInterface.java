package frontend;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;


public class UserInterface {

    public void run() {
        System.out.println("Application started successfuly\n");

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Hey. Wanna know current forecast?");
            System.out.println("Welcome to Brand New Weather App");

            System.out.println("Choose one option");
            System.out.println("1: Add new location to database");
            System.out.println("2: Show all locations");
            System.out.println("3: Download forecast data");
            System.out.println("0: Close app");

            int option = sc.nextInt();

            switch (option) {
                case 1:
                    createLocation();
                    break;
                case 2:
                    getAllLocations();
                    break;
                case 3:
                    getWeatherForecast();
                    break;
                case 0:
                    return;
            }
            System.out.println();
        }

    }

    private void createLocation() {
        //here will be code of this method
    }

    private void getAllLocations(){
        //here will be code of this method
    }

    private void getWeatherForecast() {
        //here will be code of this method
    }
}
