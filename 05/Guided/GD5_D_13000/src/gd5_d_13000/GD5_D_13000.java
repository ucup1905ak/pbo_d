package gd5_d_13000;
public class GD5_D_13000 {
    public static void main(String[] args) {
    GenericClass<String> genericStr = new GenericClass<String>("Farelino Alexander Kim"); 
    System.out.println(genericStr.getValue()); 

    GenericClass<Double> genericDbl = new GenericClass<Double>(3.14);
    System.out.println(genericDbl.getValue()); 
    
    TwoPair<Integer, Integer> twoInt = new TwoPair<Integer, Integer>(1, 2);
    System.out.println(twoInt.getValueK()); 
    System.out.println(twoInt.getValueV()); 

    TwoPair<Integer, String> diffType = new TwoPair<>(1, "ucup");
    System.out.println(diffType.getValueK()); 
    System.out.println(diffType.getValueV()); 

    TwoPair<TwoPair<Integer, String>, Double> inside = new TwoPair<>(diffType, 4.00);
    System.out.println(inside.getValueK().getValueK()); 
    System.out.println(inside.getValueK().getValueV()); 
    System.out.println(inside.getValueV()); 

    GenericList<Integer> npm = new GenericList<>();
    
    npm.add(1);
    npm.add(3);
    npm.add(0);
    npm.add(0);
    npm.add(0);
    npm.print(); // 13000

    GenericList<Character> atma = new GenericList<>();
    atma.add('A');
    atma.add('T');
    atma.add('M');
    atma.add('A');
    atma.print(); // ATMA

    Mahasigma sinay = new Mahasigma("Farel", "2407130000", 3.92);
    Mahasigma alex = new Mahasigma("Rhhexen Thenzie", "240712805", 4.0);
    Mahasigma anda = new Mahasigma("Silvanus Widyatama", "240712992", 4.0);

    GenericList<Mahasigma> mhs = new GenericList<>();
    mhs.add(sinay);
    mhs.add(alex);
    mhs.add(anda);
    mhs.print();
}
}
