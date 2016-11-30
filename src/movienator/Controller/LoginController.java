package movienator.Controller;


import Business.UserBusiness;
import java.io.IOException;
import java.sql.SQLException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class LoginController {

    UserBusiness ub = new UserBusiness(); 
    
    @FXML
    private TextField loginUser;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnLoginRegister;

    @FXML
    private PasswordField loginPassword;
    
    @FXML
    private Label loginMessage;

    @FXML
    void loginEvent(ActionEvent event) throws SQLException {

        if (ub.Login(loginUser.getText(), loginPassword.getText()))
        {
            Parent root;
            try {
                root = FXMLLoader.load(getClass().getResource("/movienator/View/Main.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Main");
                stage.setScene(scene);
                
                stage.show();
                // Hide this current window (if this is what you want)
                ((Node)(event.getSource())).getScene().getWindow().hide();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else
            loginMessage.setText("Login Inválido!");
    }
    
    @FXML
    void loginRegisterEvent(ActionEvent event) throws IOException {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/movienator/View/Register.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Register");
            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
    }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    //--------------------------------
    //REGISTER VIEW
    //--------------------------------
    
    @FXML
    private Button btnBack;

    @FXML
    private TextField registerUser;

    @FXML
    private PasswordField registerPassword;

    @FXML
    private TextField registerEmail;

    @FXML
    private PasswordField registerCPassword;

    @FXML
    private Button btnRegister;
        
    @FXML
    private Label registerMessage;

    @FXML
    void f79600(ActionEvent event) {

    }

    @FXML
    void backEvent(ActionEvent event) {

        Parent root;
        try {
            
            ((Node)(event.getSource())).getScene().getWindow().hide();
            root = FXMLLoader.load(getClass().getResource("/movienator/View/Login.fxml"));
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
            // Hide this current window (if this is what you want)
    }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("errou");
        }
        
    }

    @FXML
    void registerUserEvent(ActionEvent event) throws SQLException {
        StringBuilder message = new StringBuilder();
        boolean go = true;
        if (registerUser.getText().length() < 4){
            message.append("The User name must contain more than 4 characters\n");
            go = false;
        }
        if (registerEmail.getText().length() < 4){
            message.append("Please, fill the E-mail\n");
                    go = false;
        }
        if (registerPassword.getText().length() < 6){
            message.append("The Password must contain more than 6 characters\n");
                    go = false;
        }
        if (!registerCPassword.getText().equals(registerPassword.getText()) && registerPassword.getText().length() >= 6 ){
            message.append("Passwords are not the same\n");
            go = false;
        }
        registerMessage.setText(message.toString());
        if (go)
            registerMessage.setText(ub.Register(registerUser.getText(), registerPassword.getText(), registerEmail.getText()));
        
        if (registerMessage.getText().equals("User saved"))
        {
            Parent root;
            try {

                ((Node)(event.getSource())).getScene().getWindow().hide();
                root = FXMLLoader.load(getClass().getResource("/movienator/View/Login.fxml"));
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setTitle("Login");
                stage.setScene(scene);
                stage.show();
                // Hide this current window (if this is what you want)
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
    
}
