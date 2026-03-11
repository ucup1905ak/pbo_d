
package tgs1_d_13000;

public class LatarBelakang
{
   
    private static int timeOfDay; //secconds after midnight
    private String lokasi;
    private String cuaca;
    private double temperature; //celcious
    private double humidity; //%
    public LatarBelakang()
    {
        this.timeOfDay = 68400; 
        this.lokasi = "Dapur";
        this.cuaca = "Cerah";
        this.temperature = 25.9;
        this.humidity = 75; //percent
    }
    public LatarBelakang(int timeOfday, String lokasi, String cuaca, double temperature, double humidity)
    {
        this.timeOfDay = timeOfDay;
        this.lokasi = lokasi;
        this.cuaca = cuaca;
        this.temperature = temperature;
        this.humidity = humidity;
    }
    
    public void setTimeOfDay(int timeOfDay){this.timeOfDay = timeOfDay;}
    public void setLokasi(String lokasi){this.lokasi = lokasi;}
    public void setCuaca(String cuaca){this.cuaca = cuaca;}
    public void setTemperature(double temperature){this.temperature = temperature;}
    public void setHumidity(double humidity){this.humidity = humidity;}
    
    
    public int getTimeOfDay(){return timeOfDay;}
    public String getLokasi(){return lokasi;}
    public String getCuaca(){return cuaca;}
    public double getTemperature(){return temperature;}
    public double getHumidity(){return humidity;}
    
    public void advanceTime(){
        timeOfDay = (timeOfDay + 3600) % 86400;  
    }
    
    public void printTime(){
        int timeH = (timeOfDay - (timeOfDay % 3600)) / 3600;
        int timeM = ((timeOfDay % 3600) - (timeOfDay % 60)) / 60;
        int timeS = (timeOfDay % 60);
        System.out.println( timeH + " : " + timeM + " : " + timeS);
    }
    
    public void hujan(){
        temperature = 18.5;
        humidity = 95;
        cuaca = "Hujan";
    }
    
}
