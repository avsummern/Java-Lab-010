import java.io.IOException;

public class ForecastDisplay implements Display{
    private WeatherStation ws;
    private float currentPressure;
    private float lastPressure;
    public ForecastDisplay(WeatherStation ws){
        this.ws = ws;
        this.currentPressure = ws.getPressure();
        this.lastPressure = ws.getPressure();
    }

    @Override
    public void update() throws IOException {
        ws.measure();
        this.lastPressure = this.currentPressure;
        this.currentPressure = ws.getPressure();
    }

    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }
}
