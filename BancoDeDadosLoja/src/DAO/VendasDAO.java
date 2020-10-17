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
import modelos.Clientes;
import modelos.Vendas;

public class VendasDAO {
    
    public void create (Vendas v) {
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO VENDAS (COD_VENDA, TOTAL, IDFK_CLIENTE, DATA, HORA) VALUES (?,?,?,?,?)");
            stmt.setInt(1,v.getCodVenda());
            stmt.setDouble(2,v.getTotal());
            stmt.setInt(3,v.getClientes().getCodCliente());
            stmt.setDate(4, (Date) v.getData());  
            stmt.setString(5,v.getHora());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Venda salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
    }
    public List<Vendas> read(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Vendas> vList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM VENDAS");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Vendas v = new Vendas();
                
                v.setCodVenda(rs.getInt("COD_VENDA"));
                v.setTotal(rs.getDouble("TOTAL"));
                v.setData(rs.getDate("DATA"));
                v.setHora(rs.getString("HORA"));
                
                Clientes clientes = new Clientes();
                v.setClientes(clientes);
                
                vList.add(v);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return vList;
    }
}
   
