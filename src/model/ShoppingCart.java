package model;

import java.util.ArrayList;
import java.util.List;

public enum ShoppingCart {
    INSTANCE ;


    private List<Goods> list = new ArrayList<>();

    public void show(){
        // Do you need to do things
    }

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    public void removeAll (List<Goods> list){
        list.removeAll(list);
    }

    public void addItem(Goods good){
        list.add(good);
    }
}
