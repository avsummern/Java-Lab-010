import java.io.IOException;

public class StatisticsDisplay implements Display {
    private WeatherStation ws;
    private float temperatureMin;
    private float temperatureMax;
    private float temperatureTotal;
    private int numReadings;
    public StatisticsDisplay(WeatherStation ws){
        this.ws = ws;
        this.temperatureMin = ws.getTemperature();
        this.temperatureMax = ws.getTemperature();
        this.temperatureTotal = ws.getTemperature();
        this.numReadings = 1;
    }

    @Override
    public void update() throws IOException { //update method should update instance variables temperatureMin, temperatureMax, tempRunningTotal, and numReadings
        ws.measure();
        this.numReadings += 1;
        float holdingTemp = ws.getTemperature();
        this.temperatureTotal += holdingTemp;
        if(holdingTemp>this.temperatureMax)
        {
            this.temperatureMax = holdingTemp;
        }
        if (holdingTemp<this.temperatureMin){
            this.temperatureMin = holdingTemp;
        }
        //display();
    }
    @Override
    public void display() {//{display method should print out the min, max, and average temperature values.
        System.out.printf("The temperature max is %.2f\tThe temperature min is %.2f\tThe average of all temperatures is %.2f\n", this.temperatureMax, this.temperatureMin, (this.temperatureTotal/this.numReadings));
    }
}
