import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Race {
    private static final double FPS = 10.0;
    private static final int infoInterval = 5;
    private ArrayList<Lap> laps;
    private ArrayList<Car> cars;
    private Car winner;
    private double totalDistance;
    private int frame;

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

    public double getTotalDistance(){
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance){
        this.totalDistance = totalDistance;
    }

    public int getFrame(){
        return frame;
    }

    public void setFrame(int frame){
        this.frame = frame;
    }

    public void run(){
        double totalDistance = 0;
        for (int i = 0; i < getLaps().size(); i++){
            totalDistance += getLaps().get(i).getLength();
        }
        setTotalDistance(totalDistance);
        setFrame(0);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                if (update() == false){
                    this.cancel();
                    timer.cancel();
                }
            }
        };
        // le timertask a besoin d'une durée en millisecondes
        long FPMS = (long) (1000 / FPS);
        timer.schedule(task, 0, FPMS);
    }

    public boolean update(){
        setFrame(getFrame() + 1);
        double totalSeconds = getFrame() / Race.FPS;
        double secondPerFrame = 1 / Race.FPS;

        // mise à jour de la vitesse et de la distance parcourue et vérification winner
        for (int i = 0; i < getCars().size(); i ++){
            getCars().get(i).update(getFrame(), totalSeconds, secondPerFrame);
            if (isWinner(getCars().get(i))){
                return false;
            }
        }
        // affichage informations
        if (getFrame() == 1 || totalSeconds % Race.infoInterval == 0){
            System.out.println("-------- Temps écoulé : " + totalSeconds + " secondes --------");
            for (int i = 0; i < getCars().size(); i ++){
                getCars().get(i).showDistance();
            }
            System.out.println("----------------------------------------------");
        }
        return true;
    }

    public boolean isWinner(Car car){
        for (int i = 0; i < getCars().size(); i++) {
            if (car.getDistance() >= getTotalDistance()){
                winner = car;
                System.out.println("---------------------------------------");
                winner.showDistance();
                System.out.println(winner.getPilot() + " remporte la course");
                return true;
            }
        }
        return false;
    }
}
