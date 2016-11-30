/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movienator.Controller;

import Business.MovieBusiness;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import movienator.Model.Movie;
import javafx.scene.control.TextArea;
import movienator.Model.UserMovie;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.event.Event;
import javafx.scene.control.Tab;

public class MainController implements Initializable {

    MovieBusiness mb = new MovieBusiness();
    ObservableList<Movie> movieToTable;
    ObservableList<UserMovie> userMovieToTable;
    ArrayList<Movie> movieArray;
    ArrayList<Movie> wish_movieArray;
    ArrayList<Movie> sugest_movieArray;
    ArrayList<UserMovie> userMovieArray;
    UserMovie userMovieSelected;
    Movie movieSelected;
    Movie sugests_movieSelected;
    Movie wish_movieSelected;

    @FXML
    private Tab searchTab;

    
    //--------------------------------------------------------------------------
    //-----------------------------SEARCH---------------------------------------
    //--------------------------------------------------------------------------
    @FXML
    private Label search_lblDirectors;

    @FXML
    private Button search_btnWatched;

    @FXML
    private Button search_btnWish;

    @FXML
    private Label search_lblGenre;

    @FXML
    private TableView<Movie> search_tblMovies;
    
    @FXML
    private TableColumn search_columnRating;
    
    @FXML
    private TableColumn search_columnGenre;
    
    @FXML
    private TableColumn search_columnTitle;
    
    @FXML
    private Label search_lblStars;

    @FXML
    private Label search_lblPlot;

    @FXML
    private Button search_btnSearch;

    @FXML
    private Label search_lblMovieName;

    @FXML
    private TextField search_txtSearch;

    @FXML
    private Label search_lblRating;

    //NAO TA FUNCIONANDO
    @FXML
    void search_tabEvent(Event event) throws IOException, JsonMappingException, SQLException, JsonParseException, URISyntaxException  
    {
        search_LoadTable();
        search_LoadValues();
    }
    
    
    @FXML
    void search_btnSearchEvent(ActionEvent event) throws IOException, JsonMappingException, SQLException, JsonParseException, URISyntaxException 
    {       
        search_LoadTable();        
    }
    
    @FXML
    void search_tblMoviesEvent(MouseEvent event) 
    {
        search_LoadValues();
    }

    @FXML
    void search_btnWishEvent(ActionEvent event) 
    {
        if (movieSelected != null)
        {
            mb.ToWishList(movieSelected);
            search_btnWish.setText(mb.WishButtonMessage(movieSelected));
        }
    }

    @FXML
    void search_btnWatchedEvent(ActionEvent event) 
    {
        if (movieSelected != null)
        {
            mb.ToWatchList(movieSelected);
            search_btnWatched.setText(mb.WatchButtonMessage(movieSelected));
        }
    }
    
    private void search_LoadValues()
    {
        movieSelected = search_tblMovies.getSelectionModel().getSelectedItem();
                
        search_lblMovieName.setText(movieSelected.getTitle());
        search_lblDirectors.setText(movieSelected.getDirector());
        search_lblGenre.setText(movieSelected.getGenre());
        search_lblPlot.setText(movieSelected.getPlot());
        search_lblRating.setText(movieSelected.getImdbRating());
        search_lblStars.setText(movieSelected.getActors());
        search_btnWish.setText(mb.WishButtonMessage(movieSelected));
        
        if (mb.WatchButtonMessage(movieSelected).equals("Disabled"))
            search_btnWatched.setDisable(true);
        else
            search_btnWatched.setDisable(false);
        search_btnWatched.setText(mb.WatchButtonMessage(movieSelected));
    }
    
    private void search_LoadTable() throws IOException, JsonMappingException, SQLException, JsonParseException, URISyntaxException
    {
        movieArray =  mb.SearchMovie(search_txtSearch.getText());
        movieToTable = observableArrayList(movieArray);
        search_tblMovies.setItems(movieToTable);
    }
     
    
    //--------------------------------------------------------------------------
    //--------------------------------WATCHED-----------------------------------
    //--------------------------------------------------------------------------

    @FXML
    private Button watched_btnSearch;
    
    @FXML
    private Slider watched_sliderRate;
    
    @FXML
    private Label watched_lblRate;
    
    @FXML
    private Label watched_lblTitle;
    
    @FXML
    private TextField watched_txtSearch;

    @FXML
    private TableView<UserMovie> watched_tblMovies;
        
    @FXML
    private TableColumn watched_columnRating;
    
    @FXML
    private TableColumn watched_columnTitle;
    
    @FXML
    private Button watched_btnSave;
    
    @FXML
    private TextArea watched_txtReview;

    @FXML
    void watched_btnSearchEvent(ActionEvent event) throws SQLException {
        
        watched_LoadTable();        
        
    }

    @FXML
    void watched_sliderEvent(MouseEvent event) {
        
        Double rateDouble = watched_sliderRate.getValue();
        int rateInt = rateDouble.intValue();
        watched_lblRate.setText(Integer.toString(rateInt));
    }

    @FXML
    void watched_btnSaveEvent(ActionEvent event) throws SQLException {
        
        userMovieSelected.setRate(watched_lblRate.getText());
        userMovieSelected.setReview(watched_txtReview.getText());
        mb.SaveReview(userMovieSelected);
        watched_LoadTable();    
                
    }
    
    @FXML
    void watched_tblMoviesEvent(MouseEvent event) {

        userMovieSelected = watched_tblMovies.getSelectionModel().getSelectedItem();
        
        watched_lblTitle.setText(userMovieSelected.getTitle());
        watched_txtReview.setText(userMovieSelected.getReview());
        if(userMovieSelected.getRate() == null)
            watched_lblRate.setText("10");
        else
            watched_lblRate.setText(userMovieSelected.getRate());
        watched_sliderRate.setValue(Double.parseDouble(watched_lblRate.getText()));
        
    }
    
    private void watched_LoadTable() throws SQLException
    {
        userMovieArray =  mb.SearchUserMovie(watched_txtSearch.getText());
        userMovieToTable = observableArrayList(userMovieArray);
        watched_tblMovies.setItems(userMovieToTable);
    }
     
    //--------------------------------------------------------------------------
    //--------------------------------SUGESTS-----------------------------------
    //--------------------------------------------------------------------------
    
    @FXML
    private Label sugests_lblRating;

    @FXML
    private Label sugests_lblTitle;
    
    @FXML
    private Label sugests_lblPlot;

    @FXML
    private Label sugests_lblGenres;

    @FXML
    private Label sugests_lblDirectors;

    @FXML
    private Label sugests_lblStars;

    @FXML
    private Button sugests_btnWish;

    @FXML
    private Button sugests_btnWatched;
    
    @FXML
    private Button sugests_btnLoad;
    
    @FXML
    private TableView<Movie> sugests_tblMovies;

    @FXML
    void sugests_btnLoadEvent(ActionEvent event) {
        sugests_LoadTable();
    }
    
    @FXML
    void sugests_btnWishEvent(ActionEvent event) 
    {
        if (sugests_movieSelected != null)
        {
            mb.ToWishList(sugests_movieSelected);
            sugests_btnWish.setText(mb.WishButtonMessage(sugests_movieSelected));
            sugests_LoadTable();
        }
    }

    @FXML
    void sugests_btnWatchedEvent(ActionEvent event) 
    {
        if (sugests_movieSelected != null)
        {
            mb.ToWatchList(sugests_movieSelected);
            sugests_btnWatched.setText(mb.WatchButtonMessage(sugests_movieSelected));
            sugests_LoadTable();
        }
    }
    
    @FXML
    void sugests_tblMoviesEvent(MouseEvent event) {
        sugests_LoadValues();
    }
    
    private void sugests_LoadValues() 
    {
        sugests_movieSelected = sugests_tblMovies.getSelectionModel().getSelectedItem();
        
        sugests_lblTitle.setText(sugests_movieSelected.getTitle());
        sugests_lblDirectors.setText(sugests_movieSelected.getDirector());
        sugests_lblGenres.setText(sugests_movieSelected.getGenre());
        sugests_lblPlot.setText(sugests_movieSelected.getPlot());
        sugests_lblRating.setText(sugests_movieSelected.getImdbRating());
        sugests_lblStars.setText(sugests_movieSelected.getActors());
        sugests_btnWish.setText(mb.WishButtonMessage(sugests_movieSelected));
        
        if (mb.WatchButtonMessage(sugests_movieSelected).equals("Disabled"))
            sugests_btnWatched.setDisable(true);
        else
            sugests_btnWatched.setDisable(false);
        sugests_btnWatched.setText(mb.WatchButtonMessage(sugests_movieSelected));
    }
    
    private void sugests_LoadTable() 
    {        
        movieArray =  mb.LoadSugests();
        movieToTable = observableArrayList(movieArray);
        sugests_tblMovies.setItems(movieToTable);
    }
    
    
    //--------------------------------------------------------------------------
    //--------------------------------WISH--------------------------------------
    //--------------------------------------------------------------------------
    
    @FXML
    private Label wish_lblDirectors;

    @FXML
    private Button wish_btnWish;

    @FXML
    private Label wish_lblStars;

    @FXML
    private Button wish_btnWatched;

    @FXML
    private Label wish_lblTitle;

    @FXML
    private Label wish_lblGenres;

    @FXML
    private Label wish_lblPlot;
    
    @FXML
    private Label wish_lblRating;
    
    @FXML
    private Button wish_btnLoad;
    
    @FXML
    private TableView<Movie> wish_tblMovies;
    
    @FXML
    void wish_btnLoadEvent(ActionEvent event) {

        wish_LoadTable();
    }
    
    @FXML
    void wish_btnWishEvent(ActionEvent event) 
    {
        if (wish_movieSelected != null)
        {
            mb.ToWishList(wish_movieSelected);
            wish_btnWish.setText(mb.WishButtonMessage(wish_movieSelected));
            wish_LoadTable();
        }
    }

    @FXML
    void wish_btnWatchedEvent(ActionEvent event) 
    {
        if (wish_movieSelected != null)
        {
            mb.ToWatchList(wish_movieSelected);
            wish_btnWatched.setText(mb.WatchButtonMessage(wish_movieSelected));
            wish_LoadTable();
        }
    }
    
    @FXML
    void wish_tblMoviesEvent(MouseEvent event) 
    {
        wish_LoadValues();        
    }
    
    private void wish_LoadValues() 
    {
        wish_movieSelected = wish_tblMovies.getSelectionModel().getSelectedItem();
        
        wish_lblTitle.setText(wish_movieSelected.getTitle());
        wish_lblDirectors.setText(wish_movieSelected.getDirector());
        wish_lblGenres.setText(wish_movieSelected.getGenre());
        wish_lblPlot.setText(wish_movieSelected.getPlot());
        wish_lblRating.setText(wish_movieSelected.getImdbRating());
        wish_lblStars.setText(wish_movieSelected.getActors());
        wish_btnWish.setText(mb.WishButtonMessage(wish_movieSelected));
        
        if (mb.WatchButtonMessage(wish_movieSelected).equals("Disabled"))
            wish_btnWatched.setDisable(true);
        else
            wish_btnWatched.setDisable(false);
        wish_btnWatched.setText(mb.WatchButtonMessage(wish_movieSelected));
    }
    
    private void wish_LoadTable() {
        
        movieArray =  mb.LoadWishList();
        movieToTable = observableArrayList(movieArray);
        wish_tblMovies.setItems(movieToTable);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

   
    
    
}
