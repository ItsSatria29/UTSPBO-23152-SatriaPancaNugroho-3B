package UTS.ReservasiHotel.Kelas;

public abstract class User {
    private String nama;

    public User (String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public abstract void lihatDetailPesanan();
}

