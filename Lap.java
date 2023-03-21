public class Lap {
    
    private int kilometers;

    public Lap(){};

    public Lap(int kilometers){
        this.kilometers = kilometers;
    }

    public int getLength(){
        return kilometers;
    }

    public void setLength(int kilometers){
        this.kilometers = kilometers;
    }
}
