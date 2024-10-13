package Perumahan.data;

public class BlokA extends Rumah {
    public final String fasilitas;

    public BlokA(int noRumah, String tipe, int harga) {
        super(noRumah, "A", tipe, harga); 
        this.fasilitas = "Dekat taman bermain";
    }

    @Override
    public void infoTambahan() {
        System.out.println("Fasilitas: " + fasilitas);
    }
}
