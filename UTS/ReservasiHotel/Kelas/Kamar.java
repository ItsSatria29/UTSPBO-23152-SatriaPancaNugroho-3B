package UTS.ReservasiHotel.Kelas;

public class Kamar {
    private int nomor;
    private String tipe;
    private int harga;
    private boolean tersedia;

    public Kamar(int nomor, String tipe, int harga) {
        this.nomor = nomor;
        this.tipe = tipe;
        this.harga = harga;
        this.tersedia = true;
    }

    public int getNomor() {
        return nomor;
    }

    public String getTipe() {
        return tipe;
    }

    public int getHarga() {
        return harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}
