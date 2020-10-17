package modelos;

public class Distribuidores {
    
    private int codDistribuidor;
    private String nomeFantasia;
    private String razaoSocial;
    private String telefone;
    private String email;    
    
    public Distribuidores(){
    }
    
    public int getCodDistribuidor() {
        return codDistribuidor;
    }

    public void setCodDistribuidor(int codDistribuidor) {
        this.codDistribuidor = codDistribuidor;
    }
    
    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
