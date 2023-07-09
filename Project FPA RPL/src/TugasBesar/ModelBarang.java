package TugasBesar;

public class ModelBarang {
    private String nama;
    private String barang;
    private String alamat;
    private String nomor;

    public ModelBarang(String nama, String alamat, String barang, String nomor){
        this.nama = nama;
        this.barang = barang;
        this.alamat = alamat;
        this.nomor = nomor;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setBarang(String barang){
        this.barang = barang;
    }

    public void setAlamat(String alamat){
        this.alamat = alamat;
    }

    public void setNomor(String nomor){
        this.nomor = nomor;
    }

    public String getAlamat(){
        return alamat;
    }

    public String getNomor(){
        return nomor;
    }

    public String getNama(){
        return nama;
    }

    public String getBarang(){
        return barang;
    }
}
