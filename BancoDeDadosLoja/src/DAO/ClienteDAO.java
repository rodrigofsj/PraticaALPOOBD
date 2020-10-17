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

public class ClienteDAO {
    
    public void create (Clientes c) {
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
                
        try {
            stmt = con.prepareStatement("INSERT INTO CLIENTES (COD_CLIENTE, NOME, DATA_NASC, ENDERECO, TELEFONE, EMAIL) VALUES (?,?,?,?,?,?)");
            stmt.setInt(1,c.getCodCliente());
            stmt.setString(2,c.getNome());
            stmt.setDate(3, (Date) c.getDataNasc());
            stmt.setString(4,c.getEndereco());
            stmt.setString(5,c.getTelefone());
            stmt.setString(6,c.getEmail());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);            
        } 
    }
   
    public List<Clientes> read(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Clientes> cList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM CLIENTES");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Clientes c = new Clientes();
                
                c.setCodCliente(rs.getInt("COD_CLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setDataNasc(rs.getDate("DATA_NASC"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                
                cList.add(c);
                
            }
          
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return cList;
    }
    public List<Clientes> EmailNull(){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Clientes> cliList = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM CLIENTES WHERE EMAIL IS NULL");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                
                Clientes c = new Clientes();

                c.setCodCliente(rs.getInt("COD_CLIENTE"));
                c.setNome(rs.getString("NOME"));
                c.setDataNasc(rs.getDate("DATA_NASC"));
                c.setEndereco(rs.getString("ENDERECO"));
                c.setTelefone(rs.getString("TELEFONE"));
                c.setEmail(rs.getString("EMAIL"));
                
                cliList.add(c);
                
            }
          
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Erro na Consulta: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt, rs);
        }
        
        return cliList;    
    }
    public void ExibirEmailNull(){
        
        List<Clientes> EMAIL = EmailNull();
        
        System.out.println("Clientes sem email cadastrado:");
        
        for (Clientes c : EMAIL){
            if (c.getEmail() == null) {
                System.out.println(c.getNome());
            }
        }
    }
}    
    /*public void update(Clientes c){
        
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE CLIENTES SET Nome_CLIENTES = ?,DatNasc_CLIENTES = ?,Endereco_CLIENTES = ?,Telefone_CLIENTES = ?, Email_CLIENTES = ? WHERE CodCliente_CLIENTES = ?");
            stmt.setString(1,c.getNome());
            stmt.setDate(2, (Date) c.getDatNasc());
            stmt.setString(3,c.getEndereco());
            stmt.setString(4,c.getTelefone());
            stmt.setString(5,c.getEmail());
            stmt.setInt(5,c.getCodCliente());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
    }
    
    public void delete(Clientes c){
        Connection con = JDBC.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM CLIENTES WHERE CodCliente_CLIENTES = ?");
            stmt.setInt(1,c.getCodCliente());

            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: "+ex);
        } finally {
            JDBC.closeConnection(con, stmt);
        }
        
    }*/

       