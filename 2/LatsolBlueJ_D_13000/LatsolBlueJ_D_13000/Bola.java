

public class Bola
{

    private final double PI = 3.14;
    private int radius;
    public Bola(int radius){
        this.radius = radius;
    }
    public double getVolume(){
        return PI * radius * radius * radius * 4/3;
    }


}
