package Business;

import DAO.MovieAPI;
import DAO.MovieDAO;
import DAO.UserMovieDAO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import movienator.Model.Movie;
import movienator.Model.UserMovie;

public class MovieBusiness {
    
    MovieDAO mDAO = new MovieDAO();
    UserMovieDAO umDAO = new UserMovieDAO();
    MovieAPI mAPI = new MovieAPI();

    public ArrayList<Movie> SearchMovie(String text) throws JsonMappingException, IOException, SQLException, JsonParseException, URISyntaxException {
                
        if (!mDAO.hasMovie(text) && text != null && !text.equals(""))      
        {
            if (!mDAO.hasMovie(mAPI.getMovie(text).getTitle()))
                mDAO.insertMovie(mAPI.getMovie(text));
        }
    
        return mDAO.loadMovies(text);
    }

    public String WishButtonMessage(Movie movieSelected) 
    {

        if (umDAO.isWished(movieSelected.getMovieId()))
            return "Remove Wish";
        else     
            return "Add Wish";
    }
    
    public void ToWishList(Movie movieSelected) 
    {
        if(!umDAO.isOnUserMovie(movieSelected.getMovieId()))
            umDAO.insertOnUserMovie(movieSelected.getMovieId(), movieSelected.getTitle());
        
        if (!umDAO.isWished(movieSelected.getMovieId()))
            umDAO.insertWish(movieSelected.getMovieId());
        else      
            umDAO.removeWish(movieSelected.getMovieId());
    }

    public String WatchButtonMessage(Movie movieSelected) 
    {

        if (umDAO.hasReviewOrRate(movieSelected.getMovieId()))
            return "Disabled";
        if (umDAO.isWatched(movieSelected.getMovieId()))
            return "Remove Movie";
        else     
            return "Add Movie";
    }
     
    public void ToWatchList(Movie movieSelected) 
    {
        
        if(!umDAO.isOnUserMovie(movieSelected.getMovieId()))
            umDAO.insertOnUserMovie(movieSelected.getMovieId(), movieSelected.getTitle());
        
        if (!umDAO.isWatched(movieSelected.getMovieId()))
            umDAO.insertWatched(movieSelected.getMovieId());
        else      
            umDAO.removeWatched(movieSelected.getMovieId());
    }

    
    //MY MOVIE
    public ArrayList<UserMovie> SearchUserMovie(String text) throws SQLException 
    {

        return umDAO.loadWatchedList(text);
        
    }

    public void SaveReview(UserMovie userMovieSelected) 
    {
        umDAO.insertReviewAndRate(userMovieSelected.getMovieId(), userMovieSelected.getRate(), userMovieSelected.getReview());
    }
    
    public ArrayList<Movie> LoadWishList ()
    {
        return umDAO.loadWishList();
        
    }

    public ArrayList<Movie> LoadSugests() {
        return mDAO.loadSugests();
    }
    
}
