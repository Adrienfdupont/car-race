import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Race {

    private int length;
    private ArrayList<Car> cars = new ArrayList<Car>();
    private Car winner;
    public Race(){};

    public Race(int length, ArrayList<Car> cars, Car winner) {
        this.length = length;
        this.cars = cars;
        this.winner = winner;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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

    public void start(){
        for (int i = 0; i < cars.size(); i++){
            cars.get(i).run();
        }

        System.out.println("La course vient de commencer");

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                checkWinner();
            }
        };
        timer.schedule(task, 0, 100);
    }

    public void checkWinner(){
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getDistance() >= length){
                winner = cars.get(i);
                System.out.println(winner.getPilot());
            }
        }
    }
}
