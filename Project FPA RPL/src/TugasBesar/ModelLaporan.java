package TugasBesar;

public class ModelLaporan {
    private String nama;
    private String tempat;
    private String waktu;
    private String isi;
    private String kritik;

    public ModelLaporan(String nama, String tempat, String waktu, String isi, String kritik){
        this.nama = nama;
        this.tempat = tempat;
        this.waktu= waktu;
        this.isi = isi;
        this.kritik = kritik;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public void setTempat(String tempat){
        this.tempat=tempat;
    }

    public void setWaktu(String waktu){
        this.waktu = waktu;
    }

    public void setIsi(String isi){
        this.isi = isi;
    }

    public void setKritik(String kritik){
        this.kritik = kritik;
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

    public String getIsi(){
        return isi;
    }

    public String getKritik(){
        return kritik;
    }
}
