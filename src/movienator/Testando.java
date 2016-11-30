package movienator;

import DAO.MovieAPI;
import DAO.MovieDAO;
import DAO.UserDAO;
import DAO.UserMovieDAO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import movienator.Model.Movie;


public class Testando {
    public static void main(String[] args) throws SQLException, JsonMappingException, IOException, JsonParseException, URISyntaxException {
        

        UserDAO d = new UserDAO();
        System.out.println(d.Login("anderson", "1234"));        
        System.out.println(System.getProperty("userName"));
        System.out.println(d.Login("gabriell", "testandoinsert"));
        System.out.println(System.getProperty("userName"));
        
        
        //----- MOVIES
         MovieDAO mDAO = new MovieDAO();    
         UserMovieDAO umDAO = new UserMovieDAO(); 
         MovieAPI mAPI = new MovieAPI();
         if (!mDAO.hasMovie("inception"))
         {
            System.out.println(mAPI.getMovie("inception").toString());
            mDAO.insertMovie(mAPI.getMovie("inception"));
         }
         else
         {
             System.out.println("Filme já inserido na base de dados");
         }
         
         System.out.println(mAPI.getMovie("toy story").toString());
         
      
        System.setProperty("userId", "6");
        
        System.out.println(System.getProperty("userId"));

        
        ArrayList<Movie> array = umDAO.loadWishList();
        for (Movie m : array)
        {
            System.out.println(m.getMovieId());
        }
         
         
    }
}
