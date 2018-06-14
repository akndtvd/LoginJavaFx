
package views.fxml.controllers;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
//
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class FXMLPageConnexionController implements Initializable {

    private static final AudioClip ALERT_AUDIOCLIP = new AudioClip(FXMLPageConnexionController.class.getResource("/resources/sounds/bravo.mp3").toString());

    @FXML
    private AnchorPane pageConexion;

    @FXML
    private ImageView imgIcone;

    @FXML
    private JFXTextField txtLogin;

    @FXML
    private JFXPasswordField txtMdp;

    @FXML
    private JFXButton btnValider;

    @FXML
    private ImageView imgUser;

    @FXML
    private Text txtTitre;
    
    @FXML
    private Text txtMessage;
    
    @FXML
    private Pane enteteFenetreAdministration;



    @FXML
    private void btnValiderAction(ActionEvent event) throws IOException {


        txtMessage.setText("");
        if ( txtLogin.getText().length() == 0 || txtMdp.getText().length() == 0 ) {
            txtMessage.setText("Vous devez saisir vos identifiants");
            txtMessage.setFill(Color.RED);
        } else {
            if ( txtLogin.getText().equalsIgnoreCase("admin") && txtMdp.getText().equalsIgnoreCase("admin") ) {
                txtMessage.setText("Accès autorisé");
                txtMessage.setFill(Color.GREEN);
                ALERT_AUDIOCLIP.play();
            } else {
                txtMessage.setText("Accès refusé ! Vos identifiants sont incorrects.");   
                txtMessage.setFill(Color.RED);
            }
        }
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        Image image1;
        image1 = new Image("/resources/pictures/logo.png");
        imgIcone.setImage(image1);

        image1 = new Image("/resources/pictures/usercnx.png");
        imgUser.setImage(image1);
        
        enteteFenetreAdministration.setStyle("-fx-background-color: linear-gradient(from 25% 35% to 100% 100%, white, gray)");

        Light.Distant light = new Light.Distant();
        light.setAzimuth(50);

        Lighting lighting = new Lighting();
        lighting.setLight(light);
        lighting.setSurfaceScale(5.0);

        txtTitre.setFill(Color.BLACK);
        txtTitre.setFont(Font.font("Palatino Linotype", FontWeight.BOLD, 55));

        Reflection ref = new Reflection();
        ref.setInput(lighting);
        txtTitre.setEffect(ref);
        
    }
    
}
