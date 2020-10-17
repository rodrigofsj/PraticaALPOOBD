package modelos;

public class ItensVendas {
    
    private int quantidade;
    private double subTotal;
    private Vendas vendas;
    private Produtos produtos;
    private Clientes clientes;
    
    public ItensVendas(){        
    }
    
    public ItensVendas(int quantidade, double subTotal, Vendas vendas, Produtos produtos, Clientes clientes){
        this.quantidade = quantidade;
        this.subTotal = subTotal;
        this.vendas = vendas;
        this.produtos = produtos;
        this.clientes = clientes;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal  = subTotal;
    }   

    public Vendas getVendas() {
        return vendas;
    }

    public void setVendas(Vendas vendas) {
        this.vendas = vendas;
    }

    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }
}
