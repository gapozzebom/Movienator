package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import movienator.Model.Movie;

public class MovieDAO extends Database{
    
    int user = Integer.parseInt(System.getProperty("userId"));
    
    public ArrayList<Movie> loadMovies (String search) throws SQLException
    {
        this.conectar();
        ArrayList<Movie> retorno = new ArrayList<>();

        pstmt = conn.prepareStatement("SELECT * FROM movie "
                                + " WHERE title LIKE ?"
                                + " OR actors LIKE ?"
                                + " OR director LIKE ?");
        
        pstmt.setString(1, "%"+ search + "%");
        pstmt.setString(2, "%"+ search + "%");
        pstmt.setString(3, "%"+ search + "%");
                        
                       
        try
        {
            rs = pstmt.executeQuery();
            while (rs.next())
            {            
                Movie movie = new Movie();
                movie.setMovieId(Integer.parseInt(rs.getString("movieId")));
                movie.setActors(rs.getString("actors"));
                movie.setAwards(rs.getString("awards"));
                movie.setCountry(rs.getString("country"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setImdbID(rs.getString("imdbId"));
                movie.setImdbVotes(rs.getString("imdbVotes"));
                movie.setImdbRating(rs.getString("imdbRating"));
                movie.setLanguage(rs.getString("language"));
                movie.setMetascore(rs.getString("metascore"));
                movie.setPlot(rs.getString("plot"));
                movie.setPoster(rs.getString("poster"));
                movie.setRated(rs.getString("rated"));
                movie.setReleased(rs.getString("released"));
                movie.setResponse(rs.getString("response"));
                movie.setRuntime(rs.getString("runtime"));
                movie.setTitle(rs.getString("title"));
                movie.setType(rs.getString("type"));
                movie.setWriter(rs.getString("writer"));
                movie.setYear(rs.getString("year"));
              
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
    
    public ArrayList<Movie> loadSugests ()
    {
        this.conectar();
        ArrayList<Movie> retorno = new ArrayList<>();

        String query = "SELECT * FROM movie "
                + " WHERE movieId NOT IN ("
                + " SELECT movieId FROM userMovie"
                + " WHERE wish = true OR watch = true AND userId = "
                + user + " ) ORDER BY RAND() LIMIT 10";

                
              
        try
        {
            rs = st.executeQuery(query);
            while (rs.next())
            {            
                Movie movie = new Movie();
                movie.setMovieId(Integer.parseInt(rs.getString("movie.movieId")));
                movie.setActors(rs.getString("actors"));
                movie.setAwards(rs.getString("awards"));
                movie.setCountry(rs.getString("country"));
                movie.setDirector(rs.getString("director"));
                movie.setGenre(rs.getString("genre"));
                movie.setImdbID(rs.getString("imdbId"));
                movie.setImdbVotes(rs.getString("imdbVotes"));
                movie.setImdbRating(rs.getString("imdbRating"));
                movie.setLanguage(rs.getString("language"));
                movie.setMetascore(rs.getString("metascore"));
                movie.setPlot(rs.getString("plot"));
                movie.setPoster(rs.getString("poster"));
                movie.setRated(rs.getString("rated"));
                movie.setReleased(rs.getString("released"));
                movie.setResponse(rs.getString("response"));
                movie.setRuntime(rs.getString("runtime"));
                movie.setTitle(rs.getString("movie.title"));
                movie.setType(rs.getString("type"));
                movie.setWriter(rs.getString("writer"));
                movie.setYear(rs.getString("year"));
              
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
      
    public Movie selectMovie (int movieId)
    {
        this.conectar();
        Movie retorno = new Movie();
        String query;
        
        try
        {            
            query = "SELECT * FROM movie WHERE movieId =" + movieId;
            rs = st.executeQuery(query);

            retorno.setMovieId(Integer.parseInt(rs.getString("movieId")));
            retorno.setActors(rs.getString("actors"));
            retorno.setAwards(rs.getString("awards"));
            retorno.setCountry(rs.getString("country"));
            retorno.setDirector(rs.getString("director"));
            retorno.setGenre(rs.getString("genre"));
            retorno.setImdbID(rs.getString("imdbId"));
            retorno.setImdbVotes(rs.getString("imdbVotes"));
            retorno.setImdbRating(rs.getString("imdbRating"));
            retorno.setLanguage(rs.getString("language"));
            retorno.setMetascore(rs.getString("metascore"));
            retorno.setPlot(rs.getString("plot"));
            retorno.setPoster(rs.getString("poster"));
            retorno.setRated(rs.getString("rated"));
            retorno.setReleased(rs.getString("released"));
            retorno.setResponse(rs.getString("response"));
            retorno.setRuntime(rs.getString("runtime"));
            retorno.setTitle(rs.getString("title"));
            retorno.setType(rs.getString("type"));
            retorno.setWriter(rs.getString("writer"));
            retorno.setYear(rs.getString("year"));

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
    
    public boolean hasMovie (String search) throws SQLException
    {
        this.conectar();
         pstmt = conn.prepareStatement("SELECT * FROM movie WHERE title like ?");
        
        pstmt.setString(1, "%"+ search + "%");
        
        try
        {            
            rs = pstmt.executeQuery();
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
    
    public void insertMovie (Movie movie) throws SQLException
    {
        this.conectar();
        
        PreparedStatement pstmt = conn.prepareStatement("INSERT INTO movie (actors, awards, country, director, genre, imdbId,"
                + " imdbVotes, imdbRating, language, metascore, plot, poster, rated, released,"
                + " response, runtime, title, type, writer, year)"
                + " VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
        
        pstmt.setString(1, movie.getActors());
        pstmt.setString(2, movie.getAwards());
        pstmt.setString(3, movie.getCountry());
        pstmt.setString(4,  movie.getDirector());
        pstmt.setString(5, movie.getGenre());
        pstmt.setString(6, movie.getImdbID());
        pstmt.setString(7, movie.getImdbVotes());
        pstmt.setString(8, movie.getImdbRating());
        pstmt.setString(9, movie.getLanguage());
        pstmt.setString(10, movie.getMetascore());
        pstmt.setString(11, movie.getPlot());
        pstmt.setString(12, movie.getPoster());
        pstmt.setString(13, movie.getRated());
        pstmt.setString(14, movie.getReleased());
        pstmt.setString(15, movie.getResponse());
        pstmt.setString(16, movie.getRuntime());
        pstmt.setString(17, movie.getTitle());
        pstmt.setString(18, movie.getType());
        pstmt.setString(19, movie.getWriter());
        pstmt.setString(20, movie.getYear());
                        

        try
        {            
            pstmt.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.toString());
        }finally
        {
            fechar();
        }

    }
    
}
