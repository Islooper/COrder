package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import model.Goods;
import model.ShoppingCart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {


    @FXML
    private GridPane grid;

    @FXML
    private Label lbTotal;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        int column = 0;
        int row = 1;

        // 渲染数据
        ShoppingCart shoppingCart = ShoppingCart.INSTANCE;
        List<Goods> choose = shoppingCart.getList();

        // 算钱
        double total = 0;
        try {
            for (int i = 0; i < choose.size(); i++) {
                total += choose.get(i).getPrice();
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/scItems.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ScItemsController scItemsController = fxmlLoader.getController();
                scItemsController.setData(choose.get(i));

                if (column == 1) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch (Exception e){

        }

        lbTotal.setText("总计："+ total + "元");
    }


    @FXML
    void count(MouseEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("提示");
        alert.setHeaderText("结算信息");
        alert.setContentText("结算成功!");


        Stage stage = (Stage) lbTotal.getScene().getWindow();
        stage.close();

        // 数据清空
        ShoppingCart shoppingCart = ShoppingCart.INSTANCE;
        shoppingCart.removeAll(shoppingCart.getList());

        alert.showAndWait();


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

}
