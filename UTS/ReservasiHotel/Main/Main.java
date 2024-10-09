package UTS.ReservasiHotel.Main;
import UTS.ReservasiHotel.Kelas.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Admin
        Admin admin = new Admin("admin1", "1234");

        // Menambahkan kamar oleh Admin
        admin.tambahKamar(new Kamar(101, "Single", 500000));
        admin.tambahKamar(new Kamar(102, "Double", 700000));
        admin.tambahKamar(new Kamar(103, "Suite", 1000000));

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nHaloo! Wellcome to Satria's hotel!");
            System.out.println("Dengan siapakah disana?");
            System.out.println("============================");
            System.out.println("|1. Masuk sebagai Admin    |");
            System.out.println("|2. Masuk sebagai Customer |");
            System.out.println("|3. Keluar                 |");
            System.out.println("============================");
            System.out.print("Silahkan pilih menu(1/2/3): ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1: // Login sebagai Admin
                    System.out.print("Masukkan username admin: ");
                    String adminUsername = scanner.next();
                    System.out.print("Masukkan password admin: ");
                    String adminPassword = scanner.next();

                    if (adminUsername.equals(admin.getNama()) && adminPassword.equals("1234")) {
                        // Admin berhasil login
                        boolean adminRunning = true;
                        while (adminRunning) {
                            System.out.println("\nHaloo admin!");
                            System.out.println("Mau ngapain nih?");
                            System.out.println("==================");
                            System.out.println("|   Menu Admin   |");
                            System.out.println("==================");
                            System.out.println("|1. Tambah Kamar |");
                            System.out.println("|2. Keluar       |");
                            System.out.println("==================");
                            System.out.print("Silahkan pilih menu: ");
                            int adminChoice = scanner.nextInt();

                            switch (adminChoice) {
                                case 1:
                                    System.out.print("Masukkan nomor kamar: ");
                                    int nomorKamar = scanner.nextInt();
                                    System.out.print("Masukkan tipe kamar: ");
                                    String tipeKamar = scanner.next();
                                    System.out.print("Masukkan harga kamar: ");
                                    int hargaKamar = scanner.nextInt();
                                    admin.tambahKamar(new Kamar(nomorKamar, tipeKamar, hargaKamar));
                                    break;
                                case 2:
                                    adminRunning = false; // Keluar dari menu admin
                                    break;
                                default:
                                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                            }
                        }
                    } else {
                        System.out.println("Username atau password salah.");
                    }
                    break;

                case 2: // Login sebagai User
                    System.out.print("Masukkan nama Customer: ");
                    String namaUser = scanner.next();
                    Customer customer = new Customer(namaUser); // Membuat objek Customer

                    boolean customerRunning = true;
                    while (customerRunning) {
                        System.out.println("\nHaloo! Ada yang bisa dibantu?");
                        System.out.println("============================");
                        System.out.println("|   Menu User (Customer)   |");
                        System.out.println("============================");
                        System.out.println("|1. Cek ketersediaan kamar |");
                        System.out.println("|2. Pesan kamar            |");
                        System.out.println("|3. Lihat detail pesanan   |");
                        System.out.println("|4. Keluar                 |");
                        System.out.println("============================");
                        System.out.print("Silahkan pilih menu: ");
                        int customerChoice = scanner.nextInt();

                        switch (customerChoice) {
                            case 1:
                                customer.cekKetersediaanKamar();
                                System.out.println("Ada kamar yang ingin anda pesan?");
                                break;
                            case 2:
                                System.out.print("Masukkan nomor kamar yang ingin dipesan: ");
                                int nomorKamarPesan = scanner.nextInt();
                                customer.pesanKamar(nomorKamarPesan);
                                break;
                            case 3:
                                System.out.println("Detail Pesanan:");
                                System.out.println("Nama customer: " + namaUser);
                                customer.lihatDetailPesanan();
                                break;
                            case 4:
                                customerRunning = false; // Keluar dari menu customer
                                break;
                            default:
                                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                        }
                    }
                    break;

                case 3: // Keluar
                    running = false; // Keluar dari aplikasi
                    System.out.println("\nTerima kasih telah mengunjungi Satria's Hotel");
                    System.out.println("Sampai jumpa lagi!");
                    System.out.println("Semoga harimu menyenangkan ^_^");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }
        scanner.close();
    }
}