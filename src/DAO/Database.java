package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Database {
    
    protected Connection conn;
    protected Statement st;
    protected ResultSet rs;
    protected PreparedStatement pstmt;
     
    protected void conectar(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String urlConexao ="jdbc:mysql://localhost:3306/Movienator";
            String username="root";
            String senha="";
            
            conn = DriverManager.getConnection(urlConexao,username,senha);
            st = conn.createStatement();
            
            if (conn != null){
                System.err.println("Conectado com sucesso");
            }else{
                System.err.println("Erro na conexão");
            }
            
           
        }catch (ClassNotFoundException e){
            System.err.println("Driver não encontrado");
            
        }catch (SQLException  e){
            System.err.println("Falha na Conexão");
        }
        
        
    }
    protected void fechar() {  
      try {  
         st.close();  
         conn.close();  
         System.out.println("Conexão Fechada");  
      } catch (SQLException e) {  
          System.err.println("Erro ao fechar conexão" + e.getMessage());  
      }  
   }  
    
       
    
}
