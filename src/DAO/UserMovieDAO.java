package DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import movienator.Model.Movie;
import movienator.Model.UserMovie;

public class UserMovieDAO extends Database{
    
    int user = Integer.parseInt(System.getProperty("userId"));
    //System.getProperty("userName");
    
    public ArrayList<UserMovie> loadWatchedList (String search) throws SQLException
    {
        this.conectar();
        ArrayList<UserMovie> retorno = new ArrayList<>();

         pstmt = conn.prepareStatement("SELECT * FROM movie "
                 + " INNER JOIN userMovie ON movie.movieId = userMovie.movieId "
                        + " INNER JOIN user ON user.userId = userMovie.userId "
                        + " WHERE userMovie.userId = ?" 
                                + "  AND userMovie.title LIKE ?"
                                + " OR actors LIKE ?"
                                + " OR director LIKE ?");
        
        pstmt.setInt(1, user);
        pstmt.setString(2, "%"+ search + "%");
        pstmt.setString(3, "%"+ search + "%");
        pstmt.setString(4, "%"+ search + "%");
        
        try
        {
            rs = pstmt.executeQuery();
            
            while (rs.next())
            {              
                UserMovie um = new UserMovie();
                um.setMovieId(Integer.parseInt(rs.getString("userMovie.movieId")));
                um.setRate(rs.getString("userMovie.rate"));
                um.setReview(rs.getString("userMovie.review"));
                um.setTitle(rs.getString("userMovie.title"));
                um.setUserId(Integer.parseInt(rs.getString("userMovie.userId")));
                um.setUserName(rs.getString("user.userName"));
                um.setWatch(Boolean.valueOf(rs.getString("userMovie.userId")));
                um.setWish(Boolean.valueOf(rs.getString("userMovie.userId")));
                
                retorno.add(um);
                
            }
            return retorno;
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return null;
        }finally
        {
            fechar();
        }
    }
    
    public ArrayList<Movie> loadWishList ()
    {
        this.conectar();
        ArrayList<Movie> retorno = new ArrayList<>();

        String query = "select * from userMovie "
                        + " INNER JOIN movie ON movie.movieId = userMovie.movieId "
                        + " INNER JOIN user ON user.userId = userMovie.userId "
                        + " WHERE userMovie.userId = " + user 
                        + " AND userMovie.wish = true";
             
        try
        {
            rs = st.executeQuery(query);
            while (rs.next())
            {            
                Movie movie = new Movie();
                movie.setMovieId(Integer.parseInt(rs.getString("movie.movieId")));
                movie.setActors(rs.getString("movie.actors"));
                movie.setAwards(rs.getString("movie.awards"));
                movie.setCountry(rs.getString("movie.country"));
                movie.setDirector(rs.getString("movie.director"));
                movie.setGenre(rs.getString("movie.genre"));
                movie.setImdbID(rs.getString("movie.imdbId"));
                movie.setImdbVotes(rs.getString("movie.imdbVotes"));
                movie.setImdbRating(rs.getString("movie.imdbRating"));
                movie.setLanguage(rs.getString("movie.language"));
                movie.setMetascore(rs.getString("movie.metascore"));
                movie.setPlot(rs.getString("movie.plot"));
                movie.setPoster(rs.getString("movie.poster"));
                movie.setRated(rs.getString("movie.rated"));
                movie.setReleased(rs.getString("movie.released"));
                movie.setResponse(rs.getString("movie.response"));
                movie.setRuntime(rs.getString("movie.runtime"));
                movie.setTitle(rs.getString("movie.title"));
                movie.setType(rs.getString("movie.type"));
                movie.setWriter(rs.getString("movie.writer"));
                movie.setYear(rs.getString("movie.year"));
              
                retorno.add(movie);                
            }
            return retorno;
        }catch (SQLException e)
        {
            System.out.println(e.toString());
            return null;
        }finally
        {
            fechar();
        }
    }
    
    //WISH
    public void insertWish (int movieId)
    {
        this.conectar();
        String query = "UPDATE userMovie SET wish=true"
                        + " WHERE movieId = '" +  movieId + "'"
                        + " AND userId = '"+ user +"' "; 
        try
        {
            st.executeUpdate(query);
            
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public void removeWish (int movieId)
    {
        this.conectar();
        String query = "UPDATE userMovie SET wish = false"
                        + " WHERE movieId = '" +  movieId + "'"
                        + " AND userId = '"+ user +"' "; 
        try
        {
            st.executeUpdate(query);
            
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public boolean isWished (int movieId)
    {
        this.conectar();
        String query = "SELECT * FROM userMovie "
                        + "WHERE movieId = " + movieId             
                        + " AND userId = " + user
                        + " AND wish = true";       
        try
        {
            rs = st.executeQuery(query);
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
    
    //WATCH
    public void insertWatched (int movieId)
    {
        this.conectar();
        String query = "UPDATE userMovie SET  watch = true"
                        + " WHERE movieId = " +  movieId 
                        + " AND userId = "+ user;      
        try
        {
            st.executeUpdate(query);
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public void removeWatched (int movieId)
    {
        this.conectar();
        String query = "UPDATE userMovie SET  watch = false"
                        + " WHERE movieId = " +  movieId 
                        + " AND userId = "+ user;      
        try
        {
            st.executeUpdate(query);
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public boolean isWatched (int movieId)
    {
        this.conectar();
        String query = "SELECT * FROM userMovie "
                        + "WHERE movieId ="+ movieId             
                        + " AND userId ="+ user
                        + " AND watch = true";       
        try
        {
            rs = st.executeQuery(query);
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

    //USERMOVIE
    public boolean isOnUserMovie (int movieId)
    {
        this.conectar();
        String query = "SELECT * FROM userMovie "
                        + "WHERE movieId ="+ movieId             
                        + " AND userId ="+ user;       
        try
        {
            rs = st.executeQuery(query);
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
    
    public void insertOnUserMovie (int movieId, String title)
    {
        this.conectar();
        String query = "INSERT INTO userMovie (movieId, userId, title )"
                        + "VALUES (" +  movieId + ", " + user + ", '" +  title + "')";      
        try
        {
            st.executeUpdate(query);
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public void insertReviewAndRate (int movieId, String rate, String review)
    {
        this.conectar();
        String query = "UPDATE userMovie SET rate='"+ rate + "'"
                        + ", review = '" + review + "' "
                        + "WHERE movieId = " +  movieId
                        + " AND userId = " + user;      
        try
        {
            st.executeUpdate(query);
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }
    }
    
    public boolean hasReviewOrRate (int movieId)
    {
        this.conectar();
        String query = "SELECT * FROM userMovie "
                        + "WHERE movieId ="+ movieId             
                        + " AND userId ="+ user
                        + " AND (review IS NOT NULL"
                        + " OR rate IS NOT NULL)";       
        try
        {
            rs = st.executeQuery(query);
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
    

}
