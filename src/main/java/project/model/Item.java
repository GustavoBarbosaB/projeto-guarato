package project.model;

public class Item {

    private String desc;
    private float val;

    public Item() {

    }

    public Item(String desc, float val) {
        this.desc = desc;
        this.val = val;

    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getVal() {
        return val;
    }

    public void setVal(float val) {
        this.val = val;
    }
}
