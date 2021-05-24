package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;
import main.MyListener;
import model.Goods;

public class ScItemsController {


    @FXML
    private Label lbName;

    @FXML
    private Label lbPrice;

    @FXML
    private CheckBox cbIsChoose;

    private Goods goods;

    @FXML
    private ImageView imgLogo;


    public void setData(Goods goods) {
        this.goods = goods;
        lbName.setText(goods.getName());
        lbPrice.setText(Main.CURRENCY + goods.getPrice());
        Image image = new Image(getClass().getResourceAsStream(goods.getImgSrc()));
        imgLogo.setImage(image);
    }

}
