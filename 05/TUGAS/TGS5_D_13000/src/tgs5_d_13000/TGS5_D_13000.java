/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tgs5_d_13000;

public class TGS5_D_13000 {

    public static void main(String[] args) {
        DataMobil<MobilSport> dataMobilSport = new DataMobil<>();
        dataMobilSport.addMobil(new MobilSport("Ferrari F8", "Ferrari", 12000000, true, 340));
        dataMobilSport.addMobil(new MobilSport("Lamborghini Huracan", "Lamborghini", 11000000, false, 325));
        dataMobilSport.addMobil(new MobilSport("Porsche 911", "Porsche", 10500000, false, 310));
        dataMobilSport.addMobil(new MobilSport("Nissan GTR", "Nissan", 13000000, false, 315));
        dataMobilSport.addMobil(new MobilSport("Chevrolet Corvette", "Chevrolet", 12500000, true, 312));

        DataMobil<MobilKeluarga> dataMobilKeluarga = new DataMobil<>();
        dataMobilKeluarga.addMobil(new MobilKeluarga("Avanza", "Toyota", 1000000, false, 7));
        dataMobilKeluarga.addMobil(new MobilKeluarga("Innova", "Toyota", 1500000, true, 7));
        dataMobilKeluarga.addMobil(new MobilKeluarga("Ertiga", "Suzuki", 2000000, true, 7));

        RentalMobil<Mobil, Pelanggan> rentalA = new RentalMobil<>("Rental Mobil A", dataMobilKeluarga);
        rentalA.addPelanggan(new PelangganVIP("Sinta", "3512345678900001", 21, "Tambakrejo", "Free sewa 1 hari"));
        rentalA.addPelanggan(new PelangganVIP("Arvan", "3512345678900002", 21, "Bekasi", "Gratis sopir"));
        rentalA.addPelanggan(new PelangganReguler("Nico", "3512345678900003", 22, "Medan", "3 hari"));
        rentalA.addPelanggan(new PelangganVIP("Michele", "3512345678900004", 20, "Maguwo", "Free cuci mobil"));
        rentalA.addPelanggan(new PelangganVIP("Ayes", "3512345678900005", 24, "Kalimantan", "Gratis bensin"));
        rentalA.addPelanggan(new PelangganReguler("Rafael", "3512345678900006", 17, "Janti", "5 hari"));
        rentalA.addPelanggan(new PelangganVIP("Kenzie", "3512345678900007", 30, "Medan", "Upgrade unit"));
        rentalA.addPelanggan(new PelangganReguler("Mekel", "3512345678900008", 26, "Semarang", "3 hari"));
        rentalA.displayAll();
//        
        rentalA.getPelanggan(1).sewaMobil(dataMobilSport.getMobil(2));
        rentalA.getPelanggan(2).sewaMobil(dataMobilSport.getMobil(0));
        rentalA.getPelanggan(4).sewaMobil(dataMobilSport.getMobil(1));
        rentalA.getPelanggan(2).sewaMobil(dataMobilSport.getMobil(0));
        rentalA.getPelanggan(6).sewaMobil(dataMobilKeluarga.getMobil(2));
    }
}


// NPM : 240713000 - FARELINO ALEXANDER KIM

