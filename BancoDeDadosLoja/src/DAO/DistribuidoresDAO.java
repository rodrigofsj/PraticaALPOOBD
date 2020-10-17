package DAO;

import conexaoJDBC.JDBC;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Distribuidores;

public class DistribuidoresDAO {
    
    public void create (Distribuidores d) {
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO DISTRIBUIDORES (COD_DISTRIBUIDOR, NOME_FANTASIA, RAZAO_SOCIAL, TELEFONE, EMAIL) VALUES (?,?,?,?,?)");
            stmt.setInt(1,d.getCodDistribuidor());
            stmt.setString(2,d.getNomeFantasia());
            stmt.setString(3,d.getRazaoSocial());
            stmt.setString(4,d.getTelefone());
            stmt.setString(5,d.getEmail());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Distribuidor salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
    }
    public List<Distribuidores> read(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Distribuidores> dList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM DISTRIBUIDORES");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Distribuidores d = new Distribuidores();
                
                d.setCodDistribuidor(rs.getInt("COD_DISTRIBUIDOR"));
                d.setNomeFantasia(rs.getString("NOME_FANTASIA"));
                d.setRazaoSocial(rs.getString("RAZAO_SOCIAL"));
                d.setTelefone(rs.getString("TELEFONE"));
                d.setEmail(rs.getString("EMAIL"));
                
                dList.add(d);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return dList;
    }
}
