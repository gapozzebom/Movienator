package DAO;

import java.sql.SQLException;

public class UserDAO extends Database{
    
    public boolean InsertUser (String userName, String password, String email) throws SQLException
    {
        this.conectar();
        String query = "INSERT INTO user (userName, password, email) VALUES ('" 
                        + userName + "', '" + password + "', '" + email + "');";
        try
        {
            st.executeUpdate(query);
            return true;
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally
        {
            fechar();
        }
                
    }
    
    public boolean VerifyUserName (String userName) throws SQLException
    {
        this.conectar();
        String query = "select * from user where userName='" + userName + "'";
        try
        {
            rs =  st.executeQuery(query);
            return rs.next();
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally
        {
            fechar();
        }
        
        

        
    }
    
    public boolean VerifyUserEmail (String email) throws SQLException
    {
        this.conectar();
        String query = "select * from user where email='" + email + "'";
        
        try
        {
            rs =  st.executeQuery(query);
            return rs.next();
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally
        {
            fechar();
        }
        
    }
    
    public boolean Login (String userName, String password) throws SQLException
    {
        this.conectar();
        String query = "select * from user where password='" + password + "' AND userName='" + userName+ "'";
        
        try{
            rs =  st.executeQuery(query);

            if (rs.next())
            {
                System.setProperty("userId", rs.getString("userId"));
                System.setProperty("userName", rs.getString("userName"));
                System.out.println("LOGOU");
                return true;
            }
            else
                return false;
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return false;
        }finally
        {
            fechar();
        }
        
                
    }
    

}