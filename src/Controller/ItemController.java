package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import main.Main;
import main.MyListener;
import model.Goods;

public class ItemController {
    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLable;

    @FXML
    private ImageView img;



    @FXML
    private void click(MouseEvent mouseEvent) {
        myListener.onClickListener(goods);
    }

    private Goods goods;
    private MyListener myListener;



    public void setData(Goods goods, MyListener myListener) {
        this.goods = goods;
        this.myListener = myListener;
        nameLabel.setText(goods.getName());
        priceLable.setText(Main.CURRENCY + goods.getPrice());
        Image image = new Image(getClass().getResourceAsStream(goods.getImgSrc()));
        img.setImage(image);
    }
}
