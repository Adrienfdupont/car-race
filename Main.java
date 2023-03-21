public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        race.setLength(4);

        Car car1 = new Car(130, 312, "Adrien");
        Car car2 = new Car(138, 303, "Simba");

        race.addCar(car1);
        race.addCar(car2);

        race.start();
    }
}