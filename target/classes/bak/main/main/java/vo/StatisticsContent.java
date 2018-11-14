package vo;

import java.util.List;

public class StatisticsContent {

    private String data_date;
    private String cino;
    private String cust_name;
    private String group_id;
    private String group_name;
    private String start_date;
    private String end_date;
    private String num_vertices;
    private String num_edges;
    private String num_vertices_changed;
    private String num_edges_changed;

    private List<LabelCount> vertices_changes_by_label;
    private List<LabelCount> edge_changes_by_label;

    public String getData_date() {
        return data_date;
    }

    public void setData_date(String data_date) {
        this.data_date = data_date;
    }

    public String getCino() {
        return cino;
    }

    public void setCino(String cino) {
        this.cino = cino;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getNum_vertices() {
        return num_vertices;
    }

    public void setNum_vertices(String num_vertices) {
        this.num_vertices = num_vertices;
    }

    public String getNum_edges() {
        return num_edges;
    }

    public void setNum_edges(String num_edges) {
        this.num_edges = num_edges;
    }

    public String getNum_vertices_changed() {
        return num_vertices_changed;
    }

    public void setNum_vertices_changed(String num_vertices_changed) {
        this.num_vertices_changed = num_vertices_changed;
    }

    public String getNum_edges_changed() {
        return num_edges_changed;
    }

    public void setNum_edges_changed(String num_edges_changed) {
        this.num_edges_changed = num_edges_changed;
    }

    public List<LabelCount> getVertices_changes_by_label() {
        return vertices_changes_by_label;
    }

    public void setVertices_changes_by_label(List<LabelCount> vertices_changes_by_label) {
        this.vertices_changes_by_label = vertices_changes_by_label;
    }

    public List<LabelCount> getEdge_changes_by_label() {
        return edge_changes_by_label;
    }

    public void setEdge_changes_by_label(List<LabelCount> edge_changes_by_label) {
        this.edge_changes_by_label = edge_changes_by_label;
    }
}
