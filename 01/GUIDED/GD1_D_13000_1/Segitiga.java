
/**
 * Write a description of class Segitiga here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Segitiga
{
    // instance variables - replace the example below with your own
    private double alas;
    private double tinggi;
    
    public Segitiga()
    {
        alas = 10.2;
        tinggi = 12.4;
    }
    
    public Segitiga(double alas, double tinggi)
    {
        this.alas = alas;
        this.tinggi = tinggi;
    }
    //Accessor Mutator
    public void setAlas(double alas){this.alas = alas;}
    public void setTinggi(double tinggi){this.tinggi = tinggi;}
    public double getAlas(){return alas;}
    public double getTinggi(){return tinggi;}
    //Method
    public double luas(){
        return alas *  tinggi / 2;
    }
    
    public double pythagoras(){
        return Math.sqrt(alas * alas + tinggi * tinggi);
    }
}
