package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.Main;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.application.Application.launch;

public class IndexController implements Initializable {

    @FXML
    private ImageView imgIndex;

    private Main viewAlter;


    @FXML
    void begin(MouseEvent event) {
       Stage stage = (Stage) imgIndex.getScene().getWindow();
       stage.close();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../views/market.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("小柒 点餐");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Image image = new Image(getClass().getResourceAsStream("/img/cs.png"));
        imgIndex.setImage(image);
    }


    public void setApp(Main viewAlter) {
        this.viewAlter = viewAlter;
    }

}
