public class Lap {
    
    private double kilometers;

    public Lap(){};

    public Lap(int kilometers){
        this.kilometers = kilometers;
    }

    public double getLength(){
        return kilometers;
    }

    public void setLength(double kilometers){
        this.kilometers = kilometers;
    }
}
