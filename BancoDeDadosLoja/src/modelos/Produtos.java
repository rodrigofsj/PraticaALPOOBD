package modelos;

import java.util.Date;

public class Produtos {
    
    private int codProduto;
    private double precoVenda;
    private String descricao;
    private Date dataValidade;
    private double precoCusto;
    private int estoque;
    private Distribuidores distribuidores;
    
    public Produtos (){       
    }
    
    public Produtos (double precoVenda, String descricao, Date dataValidade, double precoCusto, int estoque, Distribuidores distribuidores) {
       this.precoVenda = precoVenda;
       this.descricao = descricao;
       this.dataValidade = dataValidade;
       this.precoCusto = precoCusto;
       this.estoque = estoque;
       this.distribuidores = distribuidores;
    }
    
    public int getCodProduto() {
        return codProduto;
    }

    public void setCodProduto(int codProduto) {
        this.codProduto = codProduto;
    }
    
    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(double precoCusto) {
        this.precoCusto = precoCusto;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }   
    
    public Distribuidores getDistribuidores(){
        return distribuidores;
    }
    
    public void SetDistribuidores (Distribuidores distribuidores){
        this.distribuidores = distribuidores;
    }
}
