import java.io.IOException;

public class CurrentConditions implements Display {
    private WeatherStation ws;
    private float temperature;
    private float humidity;
    public CurrentConditions(WeatherStation ws){
        this.ws = ws;
        this.temperature = ws.getTemperature();
        this.humidity = ws.getHumidity();
    }
    @Override
    public void update() throws IOException {
        ws.measure();
        this.temperature = ws.getTemperature();
        this.humidity = ws.getHumidity();
        //display();
    }
    @Override
    public void display() {
        System.out.printf("Current Conditions...\tTemperature: %.2f\tHumidity: %.2f\n", this.temperature, this.humidity);
    }
}
