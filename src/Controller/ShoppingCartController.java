package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import model.Goods;
import model.ShoppingCart;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartController implements Initializable {


    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        int column = 0;
        int row = 1;

        // 渲染数据
        ShoppingCart shoppingCart = ShoppingCart.INSTANCE;
        List<Goods> choose = shoppingCart.getList();
        System.out.println(choose.size());
        try {
            for (int i = 0; i < choose.size(); i++) {
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
    }
}
