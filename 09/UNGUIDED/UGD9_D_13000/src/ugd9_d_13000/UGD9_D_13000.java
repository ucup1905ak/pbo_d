package ugd9_d_13000;

public class UGD9_D_13000 {
    public static void main(String[] args) {
        
        GameDesigner abi = new GameDesigner("Unity", 85.9, "Abi Mountbatten Windsor", 4780.0);
        Programmer alex = new Programmer("C#", "Resient Evil 9: Requiem", "Alexander George", 5582.0);
        
        
        GameStudio capcom = new GameStudio("CAPCOM Studio Tokyo", "Capcom Game Publisher Group");
        capcom.setDeveloper(abi);
        capcom.setDeveloper(alex);
        
        abi.menciptakanKarakter();
        abi.pengecekanRating();
        alex.coding();
        
        System.out.println("");
        capcom.tampilGameStudio();
    }
    
}
