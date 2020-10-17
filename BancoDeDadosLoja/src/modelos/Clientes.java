package modelos;

import java.util.Date;

public class Clientes {
    
    private int codCliente;
    private String nome;
    private Date dataNasc;
    private String endereco;
    private String telefone;
    private String email;
    
    public Clientes(){        
    }
    
    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public Date getDataNasc(){
        return dataNasc;
    }
    
    public void setDataNasc(Date dataNasc){
        this.dataNasc = dataNasc;
    }
    
    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
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