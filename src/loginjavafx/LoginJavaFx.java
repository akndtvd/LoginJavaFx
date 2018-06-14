
package loginjavafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class LoginJavaFx extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("  BACKOFFICE   ");
        stage.getIcons().add(new Image("/resources/pictures/logo-wemacity.png"));
        stage.setResizable(false);

        Parent root = FXMLLoader.load(getClass().getResource("/views/fxml/views/FXMLPageConnexion.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    
    public static void main(String[] args) {
        launch(args);
    }
    
}
