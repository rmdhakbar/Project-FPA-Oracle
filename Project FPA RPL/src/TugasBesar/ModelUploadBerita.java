package TugasBesar;

public class ModelUploadBerita {
    private String judul;
    private String isi;

    public ModelUploadBerita(String judul, String isi) {
        this.judul =  judul;
        this.isi = isi;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    
    }

    public void setIsi(String isi) {
        this.isi = isi;

    }
    
    public String getJudul() {
        return judul;

    }

    public String getIsi() {
        return isi;

    }
}
