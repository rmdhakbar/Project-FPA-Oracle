package TugasBesar;

public class ModelAkun{
    private String Nama;
    private String Alamat;
    private String Nohp;
    private String Email;
    private String Username;
    private String Password;
    private boolean pilih;

    public ModelAkun(String Nama, String Alamat, String Nohp, String Email, String Username, String Password, boolean pilih){
    this.Nama = Nama;
    this.Alamat = Alamat;
    this.Nohp = Nohp;
    this.Email = Email;
    this.Username = Username;
    this.Password = Password;
    this.pilih = pilih;
    }

    public void setNama(String Nama){
        this.Nama = Nama;
    }

    public void setNohp(String Nohp){
        this.Nohp = Nohp;
    }

    public void setAlamat(String Alamat){
        this.Alamat = Alamat;
    }

    public void setEmail(String Email){
        this.Email = Email;
    }

    public void setUsername(String Username){
        this.Username = Username;
    }

    public void setPassword(String Password){
        this.Password = Password;
    }

    public void setpilih(boolean pilih){
        this.pilih = pilih;
    }

    public boolean getpilih(){
        return pilih;
    }

    public String getNama(){
        return Nama;
    }

    public String getAlamat(){
        return Alamat;
    }

    public String getNohp(){
        return Nohp;
    }

    public String getEmail(){
        return Email;
    }

    public String getUsername(){
        return Username;
    }

    public String getPassword(){
        return Password;
    }
}

