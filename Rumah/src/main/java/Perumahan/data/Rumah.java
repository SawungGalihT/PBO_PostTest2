package Perumahan.data;

public abstract class Rumah {
    public final int noRumah;
    public String tipe; 
    public int harga; 
    public String blok; 

    public static int jumlahRumah = 0;


    public Rumah(int noRumah, String blok, String tipe, int harga) {
        this.noRumah = noRumah;
        this.blok = blok; 
        this.tipe = tipe;
        this.harga = harga;
        jumlahRumah++;
    }

    public abstract void infoTambahan();

    public void tampilkanInfo() {
        System.out.println("No Rumah: " + noRumah);
        System.out.println("Blok: " + blok); 
        System.out.println("Tipe: " + tipe);
        System.out.println("Harga: Rp " + harga);
        infoTambahan();
    }

    // Getter untuk blok
    public String getBlok() {
        return blok;
    }

    public int getNoRumah() {
        return noRumah;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
