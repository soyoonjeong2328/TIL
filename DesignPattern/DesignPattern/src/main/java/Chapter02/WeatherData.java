package Chapter02;

import Chapter02.Subject;

import java.util.*;


public class WeatherData implements Subject {
    private List<Chapter02.Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observers = new ArrayList<Chapter02.Observer>();
    }

    @Override
    public void registerObserver(java.util.Observer o) {
        observers.add((Chapter02.Observer) o);
    }

    @Override
    public void removeObserver(java.util.Observer o) {
        observers.remove(o);
    }

    @Override
    public void registerObserver(Chapter02.Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Chapter02.Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Chapter02.Observer observer: observers){
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged(){
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure){
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }
}
