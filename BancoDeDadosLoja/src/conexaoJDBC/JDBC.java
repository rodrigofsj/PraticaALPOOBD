package conexaoJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JDBC {
        
    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; 
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=LOJA"; 
    private static final String USER = "Rod";
    private static final String PASS = "6585";
    
    public static Connection getConnection() {
        
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro de conexão:",ex);
        }
    }
    
    public static void closeConnection(Connection con){
        
       try {
           if(con != null){
               con.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt){
        
       closeConnection(con);
       
        try {
           if(stmt != null){
               stmt.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){
        
       closeConnection(con, stmt);
       
        try {
           if(rs != null){
               rs.close();
           }
       } catch (SQLException ex){
           Logger.getLogger(JDBC.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
    public JDBC() {

    }
    
}
/*public class JDBC {
    
    public Connection connection = null;
    
    public JDBC() {
        
        String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String DATABASE_URL = "jdbc:sqlserver://localhost:1433;databaseName=LOJA";              
        
        try {
            Class.forName(DRIVER); // Carrega o Driver
            // Obtém a conexão com a base de dados
            connection = DriverManager.getConnection(DATABASE_URL, "Daniel", "8141");
            System.out.println("Conectou com o Banco");
            
        } catch (SQLException|ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
    }
    
    public void SalvarClientes(Clientes c){
        
        try {
        Statement smt = connection.createStatement();
        smt.executeUpdate ("insert into CLIENTES (nome, data_nasc, endereco, telefone, email) values (' " + c.nome + " ', ' " + c.dataNasc + " ', ' " + c.endereco + " ', ' " + c.telefone + " ', ' " + c.email + " ')");
        }
        catch (SQLException ex) {
           System.out.println(ex.getMessage()); 
        }
    }
    
    public void ExcluirClientes(Clientes c){
        //excluir cliente
    }
    
    public List<Clientes> ListarClientes(){
       return null;
    }
    
}*/