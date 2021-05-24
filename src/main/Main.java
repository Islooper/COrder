package main;

import Controller.IndexController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.InputStream;
import java.util.logging.Level;

public class Main extends Application {

    public static final String CURRENCY = "¥";

    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/index.fxml"));
        primaryStage.setTitle("小柒 点餐");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    /**
     * 跳转到登录界面
     */
    public void gotoIndex() {
        try {
            IndexController index = (IndexController) replaceSceneContent("../views/index.fxml");
            index.setApp(this);
        } catch (Exception ex) {
            System.out.println("页面加载异常!");
        }
    }


    /**
     * 跳转到主界面
     */
    public void gotoMarket() {
        try {
            IndexController index = (IndexController) replaceSceneContent("../views/market.fxml");
            index.setApp(this);
        } catch (Exception ex) {
            System.out.println("页面加载异常!");
        }
    }


    public static void main(String[] args) {
        launch(args);
    }



    /**
     * 替换场景
     * @param fxml
     * @return
     * @throws Exception
     */
    private Initializable replaceSceneContent(String fxml) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        InputStream in = Main.class.getResourceAsStream(fxml);
        loader.setBuilderFactory(new JavaFXBuilderFactory());
        loader.setLocation(Main.class.getResource(fxml));
        try {
            AnchorPane page = (AnchorPane) loader.load(in);
            Scene scene = new Scene(page, 400,400);
            stage.setScene(scene);
            stage.sizeToScene();
        } catch (Exception e) {
            System.out.println("页面加载异常!");
        } finally {
            in.close();
        }
        return (Initializable) loader.getController();
    }
}
