package vo;

public class LabelCount {

    private String label;
    private int count;
    private int count_changed;

    private int count_changed_add;
    private int count_changed_minus;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount_changed() {
        return count_changed;
    }

    public void setCount_changed(int count_changed) {
        this.count_changed = count_changed;
    }

    public int getCount_changed_add() {
        return count_changed_add;
    }

    public void setCount_changed_add(int count_changed_add) {
        this.count_changed_add = count_changed_add;
    }

    public int getCount_changed_minus() {
        return count_changed_minus;
    }

    public void setCount_changed_minus(int count_changed_minus) {
        this.count_changed_minus = count_changed_minus;
    }
}
