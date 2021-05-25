package Controller;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import main.Main;
import main.MyListener;
import model.Goods;
import model.ShoppingCart;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private Label fruitNameLable;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private ImageView fruitImg;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    @FXML
    private Label lbGoodsDes;

    @FXML
    private TextField tfSearchData;

    @FXML
    private Button btnSearch;

    @FXML
    private Label time;

    @FXML
    private Label lbNum;


    @FXML
    private Button btnAddShoppingCar;


    @FXML
    private ImageView imgToShoppingCart;


    @FXML
    private AnchorPane apStage;


    // 当前
    private Goods preGood;
    private List<Goods> goods = new ArrayList<>();
    private Image image;
    private MyListener myListener;

    private List<Goods> getData() {
        List<Goods> goods = new ArrayList<>();
        Goods good;

        good = new Goods();
        good.setName("香喷喷的米饭");
        good.setPrice(2.0);
        good.setImgSrc("/img/mf.png");
        good.setColor("6A7324");
        good.setDes("单点一份米饭不送，一份菜最多点两份米饭。");
        goods.add(good);

        good = new Goods();
        good.setName("蛋炒饭");
        good.setPrice(12.0);
        good.setImgSrc("/img/dcf.png");
        good.setColor("291D36");
        good.setDes("单点一份炒饭不送，一份菜最多点两份炒饭。");
        goods.add(good);

        good = new Goods();
        good.setName("番茄炒肉");
        good.setPrice(18.0);
        good.setImgSrc("/img/fqcr.png");
        good.setColor("A7745B");
        good.setDes("番茄炒肉是一道家常菜，主要原料有番茄、猪肉。");
        goods.add(good);

        good = new Goods();
        good.setName("烩牛肉");
        good.setPrice(25.0);
        good.setImgSrc("/img/hnr.png");
        good.setColor("22371D");
        good.setDes("烩牛肉是一道菜品，制作原料主要有牛肉、土豆、胡萝卜等，具有丰富的蛋白质能增强体质，口味咸鲜，营养丰富。");
        goods.add(good);

        good = new Goods();
        good.setName("蔬菜沙拉");
        good.setPrice(16.0);
        good.setImgSrc("/img/scsl.png");
        good.setColor("FB5D03");
        good.setDes("蔬菜沙拉是一道 以圆白菜、番茄、黄瓜等作为主要食材制作而成的美食。蔬菜沙拉是一种非常营养健康的饮食方法。");
        goods.add(good);

        good = new Goods();
        good.setName("下酒花生米");
        good.setPrice(5.0);
        good.setImgSrc("/img/hsm.png");
        good.setColor("80080C");
        good.setDes("喝酒必备。");
        goods.add(good);

        good = new Goods();
        good.setName("奶油土豆汤");
        good.setPrice(22.0);
        good.setImgSrc("/img/nytd.png");
        good.setColor("FFB605");
        good.setDes("奶油土豆浓汤是以土豆一个、洋葱半个、培根3片、牛奶250毫升、淡奶油少许等为主要食材做成的一道美食。");
        goods.add(good);

        good = new Goods();
        good.setName("韩国泡菜");
        good.setPrice(14.0);
        good.setImgSrc("/img/hgpc.png");
        good.setColor("5F060E");
        good.setDes("“韩国泡菜”是朝鲜半岛一种以蔬菜为主要原料，各种水果、海鲜及肉料、添加鱼露为配料的发酵食品。");
        goods.add(good);

        good = new Goods();
        good.setName("萝卜鸡腿汤");
        good.setPrice(30.0);
        good.setImgSrc("/img/lbjtt.png");
        good.setColor("E7C00F");
        good.setDes("好喝又营养。");
        goods.add(good);

        good = new Goods();
        good.setName("鱼香肉丝");
        good.setPrice(25.0);
        good.setImgSrc("/img/yxrs.png");
        good.setColor("E7C00F");
        good.setDes("鱼香肉丝，是四川的一道特色名菜，该菜品以泡辣椒，子姜，大蒜，糖和醋炒制猪里脊肉丝而成，由民国时期的一位川菜大厨所创制，相传灵感来自泡椒肉丝。");
        goods.add(good);


        good = new Goods();
        good.setName("麻婆豆腐");
        good.setPrice(12.0);
        good.setImgSrc("/img/mpdf.png");
        good.setColor("E7C00F");
        good.setDes("麻婆豆腐，是四川省传统名菜之一，属于川菜，主料为：豆腐，辅料为：蒜苗、牛肉沫(其他肉也可以).");
        goods.add(good);

        return goods;
    }

    private void setChosenFruit(Goods goods) {
        fruitNameLable.setText(goods.getName());
        lbGoodsDes.setText(goods.getDes());
        fruitPriceLabel.setText(Main.CURRENCY + goods.getPrice());
        image = new Image(getClass().getResourceAsStream(goods.getImgSrc()));
        fruitImg.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #" + goods.getColor() + ";\n" +
                "    -fx-background-radius: 30;");



        preGood = goods;


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // set time
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String now = formatter.format(date);
        time.setText(now);

        goods.addAll(getData());
        if (goods.size() > 0) {
            setChosenFruit(goods.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(Goods goods) {
                    setChosenFruit(goods);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < goods.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/views/item.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(goods.get(i),myListener);

                if (column == 3) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

//        ShoppingCart shoppingCart = ShoppingCart.INSTANCE;
//        lbNum.textProperty().bind(new ObjectBinding<String>() {
//            @Override
//            protected String computeValue() {
//                return String.valueOf(shoppingCart.getList().size());
//            }
//        });
    }



    @FXML
    void search(MouseEvent event) {
        String data = tfSearchData.getText();

        if (data.equals("")){
            return;
        }

        for (int i = 0; i < goods.size(); i++) {
            if (data.equals(goods.get(i).getName())){
                setChosenFruit(goods.get(i));
                return;
            }
        }

    }


    @FXML
    void addShoppingCar(MouseEvent event) {
        ShoppingCart shoppingCart = ShoppingCart.INSTANCE;
        shoppingCart.addItem(preGood);

        // ui图标给出提示
        lbNum.setVisible(true);
        lbNum.setText(String.valueOf(shoppingCart.getList().size()));

    }


    // 跳转购物车界面
    @FXML
    void toShoppingCart(MouseEvent event) {
        Stage stage = (Stage) btnSearch.getScene().getWindow();
        stage.close();

        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("../views/shoppingCart.fxml"));
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
