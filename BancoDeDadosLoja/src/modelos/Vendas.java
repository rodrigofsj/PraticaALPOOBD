package modelos;

import java.util.Date;

public class Vendas {
    
    private int codVenda;
    private Date data;
    private String hora;
    private double total;
    private Clientes clientes;
    
    public Vendas(){
    }
    
    public Vendas(Date data, String hora, double total, Clientes clientes){
        this.data = data;
        this.hora = hora;
        this.total = total;
        this.clientes = clientes;
    }
    
    public int getCodVenda() {
        return codVenda;
    }

    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }
    
    public Date getData() {
        return data;
    }
    
    public void setData(Date data) {
        this.data = data;
    }

    public double getTotal() {
        return total;
    }
    
    public void setTotal(double total) {
        this.total = total;
    }   

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
