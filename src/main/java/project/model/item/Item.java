package project.model.item;

public class Item {

    private int id;
    private String desc;
    private float val;

    protected Item() {

    }

    public Item(String desc, float val, int id) {
        this.desc = desc;
        this.val = val;
        this.id = id;

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
