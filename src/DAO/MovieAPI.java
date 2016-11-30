package DAO;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import movienator.Model.Movie;

public class MovieAPI {
    
    private ObjectMapper mapper = new ObjectMapper();
    
    public Movie getMovie (String string) throws JsonParseException, JsonMappingException, IOException, URISyntaxException
    {
        /*URI uri = new URI(
        "http", 
        "www.omdbapi.com", 
        "/?t=" + string + "&y=&plot=short&r=json",
        null);*/
        String encodedUrl = string;
       
        try {
            encodedUrl = URLEncoder.encode(string, "UTF-8");
        } catch (UnsupportedEncodingException ignored) {
            // Can be safely ignored because UTF-8 is always supported
        }
        
        String url = "http://www.omdbapi.com/?t=" + encodedUrl + "&y=&plot=full&r=json";
        URL jsonUrl = new URL(url);
        //URL jsonUrl = uri.toURL();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        ObjectNode node = mapper.readValue(jsonUrl, ObjectNode.class);

        Movie movie = null;
        movie = mapper.readValue(jsonUrl, Movie.class);
                 
        System.out.println(movie.toString());
        System.out.println(movie.getTitle());
        
        return movie;
        
    }
    
    public ArrayList<String> searchMovie (String string) throws JsonParseException, JsonMappingException, IOException
    {
        String url = "http://www.omdbapi.com/?s=" + string + "&r=json&page=1";
        URL jsonUrl = new URL(url);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        ObjectNode node = mapper.readValue(jsonUrl, ObjectNode.class);
        System.out.println("Numero de resultados: " + node.get("totalResults"));
       
        //arrumar
        Movie[] movie = null;

        System.out.println("comecou");
        List<Movie> myObjects = mapper.readValue(jsonUrl, new TypeReference<List<Movie>>(){});
        System.out.println("Primeiro array");
        for (Movie m : myObjects)
        {
            System.out.println(m.getTitle());
        }
        
        movie = mapper.readValue(jsonUrl, Movie[].class);
        System.out.println("Segundo array");
        for (Movie m : movie)
        {
            System.out.println(m.getTitle());
        }
         
        return null;
        
    }
    
}
