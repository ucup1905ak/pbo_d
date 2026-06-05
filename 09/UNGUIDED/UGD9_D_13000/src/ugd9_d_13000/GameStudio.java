package ugd9_d_13000;

import java.util.ArrayList;

public class GameStudio {

    private String namaStudio;
    private String publisher;

    private ArrayList<Developer> listDeveloper = new ArrayList<>();

    public GameStudio(String namaStudio, String publisher) {
        this.namaStudio = namaStudio;
        this.publisher = publisher;
    }
    
    
    public void tampilGameStudio() {
        System.out.println("----------<" + this.namaStudio + ">----------------------------");
        System.out.println("Publisher: " + this.publisher);
        int count = 0;
        for (Developer d : listDeveloper) {
            count++;
            System.out.println("Developer ke-" + count);
            d.tampilDeveloper();
        }
    }

    public void setDeveloper(Developer dev){
        listDeveloper.add(dev);
    }
}
