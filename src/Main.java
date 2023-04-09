import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner in = new Scanner(System.in);
        WeatherStation ws = new WeatherStation();
        ws.measure();

        Display[] display = new Display[3];
        display[0] = new CurrentConditions(ws);
        display[1] = new StatisticsDisplay(ws);
        display[2] = new ForecastDisplay(ws);

        while(true){
           for(Display d: display){
               d.update();
               d.display();
           }
           System.out.println("\nWould you like to compare this to the weather right now?\t\t\tEnter Y to compare, anything else to exit");
           String response = in.nextLine();
           if (!response.equalsIgnoreCase("Y")){
               break;
           }
        }
    }
}
