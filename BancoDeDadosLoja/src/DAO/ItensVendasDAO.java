package DAO;

import conexaoJDBC.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.ItensVendas;
import modelos.Produtos;
import modelos.Vendas;

public class ItensVendasDAO {
    
    public void create (ItensVendas i) {
       Connection con = JDBC.getConnection();
       PreparedStatement stmt = null; 
       
       try {
            stmt = con.prepareStatement("INSERT INTO ITENS_VENDA (QUANTIDADE, SUB_TOTAL, IDFK_VENDA, IDFK_PRODUTO) VALUES (?,?,?,?)");
            stmt.setInt(1,i.getQuantidade());
            stmt.setDouble(2,i.getSubTotal());
            stmt.setInt(3,i.getVendas().getCodVenda());
            stmt.setInt(4,i.getProdutos().getCodProduto());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Item salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
    }
    public List<ItensVendas> read(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<ItensVendas> iList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM ITENS_VENDA");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                ItensVendas i = new ItensVendas();
                
                i.setQuantidade(rs.getInt("QUANTIDADE"));
                i.setSubTotal(rs.getDouble("SUB_TOTAL"));
                
                Vendas vendas = new Vendas();
                i.setVendas(vendas);
                
                Produtos produtos = new Produtos();
                i.setProdutos(produtos);
                
                iList.add(i);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return iList;
    }
}
