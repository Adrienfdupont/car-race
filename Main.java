public class Main {
    public static void main(String[] args) {
        
        Race race = new Race();
        
        for (int i = 0; i < 3; i++){
            race.addLap(new Lap(13));
        }

        race.addCar(new Car(130, 312, "Adrien"));
        race.addCar(new Car(138, 303, "Simba"));

        race.start();
    }
}