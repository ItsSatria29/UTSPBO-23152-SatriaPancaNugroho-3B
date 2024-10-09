package UTS.ReservasiHotel.Kelas;
import java.util.ArrayList;

public class Admin extends User {

    public Admin(String nama, String password) {
        super(nama);
    }

    public void tambahKamar(Kamar kamar) {
        Database.kamarList.add(kamar);
        System.out.println("Kamar " + kamar.getNomor() + " ditambahkan oleh admin.");
    }

    @Override
    public void lihatDetailPesanan() {
        System.out.println("Admin tidak memiliki pesanan untuk ditampilkan.");
    }
}
