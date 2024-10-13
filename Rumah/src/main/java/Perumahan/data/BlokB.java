package Perumahan.data;

public class BlokB extends Rumah {
    public final String fasilitas;

    public BlokB(int noRumah, String tipe, int harga) {
        super(noRumah, "B", tipe, harga); 
        this.fasilitas = "Dekat kolam renang";
    }

    @Override
    public void infoTambahan() {
        System.out.println("Fasilitas: " + fasilitas);
    }
}
