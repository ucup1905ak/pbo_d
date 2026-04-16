package gd5_d_13000;
public class GD5_D_13000 {
    public static void main(String[] args) {
    GenericClass<String> genericStr = new GenericClass<String>("nama praktikan"); //diubah
    System.out.println(genericStr.getValue()); //nama praktikan

    GenericClass<Double> genericDbl = new GenericClass<Double>(3.14);
    System.out.println(genericDbl.getValue()); //3.14

    TwoPair<Integer, Integer> twoInt = new TwoPair<Integer, Integer>(1, 2);
    System.out.println(twoInt.getValueK()); // 1
    System.out.println(twoInt.getValueV()); // 2

    TwoPair<Integer, String> diffType = new TwoPair<>(1, "sinay");
    System.out.println(diffType.getValueK()); // 1
    System.out.println(diffType.getValueV()); // sinay

    TwoPair<TwoPair<Integer, String>, Double> inside = new TwoPair<>(diffType, 4.00);
    System.out.println(inside.getValueK().getValueK()); // 1
    System.out.println(inside.getValueK().getValueV()); // sinay
    System.out.println(inside.getValueV()); // 4.00

    GenericList<Integer> npm = new GenericList<>();
    // masukan 5 digit npm
    npm.add(1);
    npm.add(2);
    npm.add(2);
    npm.add(9);
    npm.add(1);
    npm.print(); // 12291

    GenericList<Character> atma = new GenericList<>();
    atma.add('A');
    atma.add('T');
    atma.add('M');
    atma.add('A');
    atma.print(); // ATMA

    Mahasigma sinay = new Mahasigma("sinay", "230712291", 4.0);
    Mahasigma alex = new Mahasigma("alexander wongso", "230712519", 4.0);
    Mahasigma anda = new Mahasigma("nama praktikan", "npm praktikan", 4.0);

    GenericList<Mahasigma> mhs = new GenericList<>();
    mhs.add(sinay);
    mhs.add(alex);
    mhs.add(anda);
    mhs.print();
}
}
