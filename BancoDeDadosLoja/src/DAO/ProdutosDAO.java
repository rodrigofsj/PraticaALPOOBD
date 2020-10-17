package DAO;

import conexaoJDBC.JDBC;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Distribuidores;
import modelos.Produtos;

public class ProdutosDAO {
    
    public void create (Produtos p) {
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO PRODUTOS (COD_PRODUTO, PRECO_VENDA, DESCRICAO, DATA_VALIDADE, PRECO_CUSTO, ESTOQUE, IDFK_DISTRIBUIDOR) VALUES (?,?,?,?,?,?,?)");
            stmt.setInt(1,p.getCodProduto());
            stmt.setDouble(2,p.getPrecoVenda());
            stmt.setString(3,p.getDescricao());
            stmt.setDate(4, (Date) p.getDataValidade());
            stmt.setDouble(5,p.getPrecoCusto());
            stmt.setInt(6,p.getEstoque());
            stmt.setInt(7,p.getDistribuidores().getCodDistribuidor());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Produto salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
    }
    public List<Produtos> read(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Produtos> pList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTOS");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Produtos p = new Produtos();
                
                p.setCodProduto(rs.getInt("COD_PRODUTO"));
                p.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                p.setDescricao(rs.getString("DESCRICAO"));
                p.setDataValidade(rs.getDate("DATA_VALIDADE"));
                p.setPrecoCusto(rs.getDouble("PRECO_CUSTO"));
                p.setEstoque(rs.getInt("ESTOQUE"));
                
                Distribuidores distribuidores = new Distribuidores();
                p.SetDistribuidores(distribuidores);
                
                pList.add(p);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return pList;
    }
    public List<Produtos> DataValidade() {

        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Produtos> prodList = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM PRODUTOS WHERE DATA_VALIDADE < (SELECT GETDATE())");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Produtos p = new Produtos();

                p.setPrecoVenda(rs.getDouble("PRECO_VENDA"));
                p.setDescricao(rs.getString("DESCRICAO"));
                p.setDataValidade(rs.getDate("DATA_VALIDADE"));
                p.setPrecoCusto(rs.getDouble("PRECO_CUSTO"));
                p.setEstoque(rs.getInt("ESTOQUE"));
                prodList.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: " + ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }

        return prodList;
    }

    public void ExibirData_Validade() {

        List<Produtos> DATA_VALIDADE = DataValidade();
        
        System.out.println("Produtos vencidos:");
        
        for (Produtos p : DATA_VALIDADE) {
            if (p.getDataValidade()!= conversores.Conversor.StringParaData("10/10/2020")) {
                System.out.println(p.getDescricao() + " "+ p.getDataValidade() );
            }
         }
      }
}

