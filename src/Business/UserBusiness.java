package Business;

import DAO.UserDAO;
import java.sql.SQLException;

public class UserBusiness {

    UserDAO uDAO = new UserDAO();
    public boolean Login(String user, String pass) throws SQLException {
              
        return uDAO.Login(user, pass);
    }

    public String Register(String name, String pass, String email) throws SQLException {
        
        if (uDAO.VerifyUserName(name))
            return "User already used";
        if (uDAO.VerifyUserEmail(email))
            return "Email already used";
        uDAO.InsertUser(name, pass, email);
        return "User saved";
    }
    
}
