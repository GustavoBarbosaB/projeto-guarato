package project.model;

public class Item {

    private String desc;
    private int qtd;
    private float val;

    public Item() {

    }

    public Item(String desc, int qtd, float val) {
        this.qtd = qtd;
        this.desc = desc;
        this.val = val;

    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
