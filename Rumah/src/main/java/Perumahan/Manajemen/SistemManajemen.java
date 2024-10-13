package Perumahan.Manajemen;

import Perumahan.interfaces.ManajemenRumah;
import Perumahan.data.Rumah;
import Perumahan.data.BlokA;
import Perumahan.data.BlokB;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemManajemen implements ManajemenRumah {
    public String namaPengelola;
    public String lokasiPerumahan;
    public ArrayList<Rumah> daftarRumah;

    public SistemManajemen(String namaPengelola, String lokasiPerumahan) {
        this.namaPengelola = namaPengelola;
        this.lokasiPerumahan = lokasiPerumahan;
        this.daftarRumah = new ArrayList<>();
        daftarRumah.add(new BlokA(23, "Tipe 36", 300000000)); // No rumah, tipe, harga
        daftarRumah.add(new BlokA(24, "Tipe 40", 450000000));
        daftarRumah.add(new BlokB(35, "Tipe 36", 350000000));
        daftarRumah.add(new BlokB(45, "Tipe 60", 550000000));
    }

    @Override
    public void tambahRumah(Rumah rumah) {
        daftarRumah.add(rumah);
        System.out.println("Rumah berhasil ditambahkan!");
    }

    @Override
    public void tampilkanRumah() {
        if (daftarRumah.isEmpty()) {
            System.out.println("Tidak ada rumah yang terdaftar.");
        } else {
            System.out.println("Perumahan di: " + lokasiPerumahan);
            System.out.println("Pengelola: " + namaPengelola);
            for (Rumah rumah : daftarRumah) {
                rumah.tampilkanInfo();
                System.out.println("------------------------");
            }
        }
    }

    @Override
    public void hapusRumah(int noRumah) {
        boolean ditemukan = false;
        for (Rumah rumah : daftarRumah) {
            if (rumah.getNoRumah() == noRumah) {
                daftarRumah.remove(rumah);
                System.out.println("Rumah dengan No. " + noRumah + " berhasil dihapus.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Rumah dengan No. tersebut tidak ditemukan.");
        }
    }

    @Override
    public void updateRumah(int noRumah) { 
        boolean ditemukan = false;
        for (Rumah rumah : daftarRumah) {
            if (rumah.getNoRumah() == noRumah) { 
                Scanner scanner = new Scanner(System.in);
                System.out.print("Masukkan tipe baru: ");
                rumah.setTipe(scanner.nextLine());
                System.out.print("Masukkan harga baru: ");
                rumah.setHarga(scanner.nextInt());
                System.out.println("Data rumah berhasil diupdate.");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Rumah dengan No. tersebut tidak ditemukan.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nama pengelola: ");
        String namaPengelola = scanner.nextLine();
        System.out.print("Masukkan lokasi perumahan: ");
        String lokasiPerumahan = scanner.nextLine();

        SistemManajemen manajemen = new SistemManajemen(namaPengelola, lokasiPerumahan);

        int pilihan;
        do {
            System.out.println("===== Sistem Manajemen Perumahan =====");
            System.out.println("1. Tambah Rumah");
            System.out.println("2. Tampilkan Semua Rumah");
            System.out.println("3. Hapus Rumah");
            System.out.println("4. Update Rumah");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  // Membersihkan newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan blok rumah (A/B): ");
                    String blok = scanner.nextLine();
                    System.out.print("Masukkan No. rumah: ");
                    int noRumah = scanner.nextInt(); 
                    scanner.nextLine(); // Membersihkan newline
                    System.out.print("Masukkan tipe rumah: ");
                    String tipe = scanner.nextLine();
                    System.out.print("Masukkan harga rumah: ");
                    int harga = scanner.nextInt();

                    Rumah rumah;
                    if (blok.equalsIgnoreCase("A")) {
                        rumah = new BlokA(noRumah, tipe, harga);
                    } else if (blok.equalsIgnoreCase("B")) {
                        rumah = new BlokB(noRumah, tipe, harga);
                    } else {
                        System.out.println("Blok tidak valid. Rumah tidak ditambahkan.");
                        break;
                    }

                    manajemen.tambahRumah(rumah);
                    break;
                case 2:
                    manajemen.tampilkanRumah();
                    break;
                case 3:
                    System.out.print("Masukkan No. rumah yang akan dihapus: ");
                    int noRumahHapus = scanner.nextInt(); 
                    manajemen.hapusRumah(noRumahHapus);
                    break;
                case 4:
                    System.out.print("Masukkan No. rumah yang akan diupdate: ");
                    int noRumahUpdate = scanner.nextInt(); 
                    manajemen.updateRumah(noRumahUpdate);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan sistem.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 5);
    }
}