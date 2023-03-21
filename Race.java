import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Race {

    private ArrayList<Lap> laps;
    private ArrayList<Car> cars;
    private Car winner;
    private boolean running;

    public Race(){
        laps = new ArrayList<Lap>();
        cars = new ArrayList<Car>();
    };

    public Race(ArrayList<Car> cars, ArrayList<Lap> laps, Car winner) {
        this.laps = new ArrayList<Lap>();
        this.cars = new ArrayList<Car>();
        this.cars = cars;
        this.laps = laps;
        this.winner = winner;
    }

    public ArrayList<Lap> getLaps(){
        return laps;
    }

    public void setLaps(ArrayList<Lap> laps){
        this.laps = laps;
    }

    public void addLap(Lap lap){
        if (!laps.contains(lap)){
            laps.add(lap);
        }
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        if (!cars.contains(car)){
            cars.add(car);
        }
    }

    public Car getWinner() {
        return winner;
    }

    public void setWinner(Car winner) {
        this.winner = winner;
    }

    public boolean isRunning(){
        return running;
    }

    public void setRunning(boolean running){
        this.running = running;
    }

    public void start(){
        setRunning(true);
        for (int i = 0; i < cars.size(); i++){
            cars.get(i).run();
        }

        System.out.println("La course vient de commencer");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (checkWinner()){
                    setRunning(false);
                }
            }
        };
        timer.schedule(task, 0, 100);
    }

    public boolean checkWinner(){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getDistance() >= getRaceLength()){
                winner = cars.get(i);
                System.out.println("Le vainqueur est " + winner.getPilot());
                return true;
            }
        }
        return false;
    }

    public int getRaceLength(){
        int totalDistance = 0;
        for (int i = 0; i < laps.size(); i++){
            totalDistance += laps.get(i).getLength();
        }
        return totalDistance;
    }
}
