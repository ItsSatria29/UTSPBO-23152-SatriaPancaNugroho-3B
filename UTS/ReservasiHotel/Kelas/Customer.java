package UTS.ReservasiHotel.Kelas;
import UTS.ReservasiHotel.Interface.*;

public class Customer extends User implements Interface {
    private Kamar kamarDipesan;

    public Customer(String nama) {
        super(nama);
    }

    public void cekKetersediaanKamar() {
        System.out.println("\nKamar tersedia:");
        for (Kamar kamar : Database.kamarList) {
            if (kamar.isTersedia()) {
                System.out.println("Kamar No: " + kamar.getNomor() + " - " + kamar.getTipe() + " - Harga: " + kamar.getHarga());
            }
        }
    }

    public void pesanKamar(int nomorKamar) {
        for (Kamar kamar : Database.kamarList) {
            if (kamar.getNomor() == nomorKamar && kamar.isTersedia()) {
                kamar.setTersedia(false);
                this.kamarDipesan = kamar;
                System.out.println("Kamar No: " + nomorKamar + " berhasil dipesan.");
                System.out.println("Selamat menikmati fasilitas yang tersedia ^_^");
                return;
            }
        }
        System.out.println("Kamar tidak tersedia.");
    }

    @Override
    public void lihatDetailPesanan() {
        if (kamarDipesan != null) {
            System.out.println("Kamar No: " + kamarDipesan.getNomor() + " - " + kamarDipesan.getTipe() + " - Harga: " + kamarDipesan.getHarga());
        } else {
            System.out.println("Tidak ada pesanan.");
        }
    }
}
