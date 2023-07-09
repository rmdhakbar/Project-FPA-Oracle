package TugasBesar;

public class ModelJadwal {
    private String nama;
    private String tempat;
    private String waktu;
    private String barang;

    public ModelJadwal(String nama,String tempat,String waktu,String barang){
        this.nama = nama;
        this.tempat = tempat;
        this.waktu = waktu;
        this.barang = barang;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setTempat(String tempat){
        this.tempat = tempat;
    }

    public void setWaktu(String waktu){
        this.waktu = waktu;
    }

    public void setBarang(String barang){
        this.barang = barang;
    }

    public String getNama(){
        return nama;
    }

    
    public String getTempat(){
        return tempat;
    }

    
    public String getWaktu(){
        return waktu;
    }

    
    public String getBarang(){
        return barang;
    }




    
}