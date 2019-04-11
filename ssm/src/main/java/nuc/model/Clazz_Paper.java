package nuc.model;

import java.util.Date;

public class Clazz_Paper {

    private int id;
    private int paper_id;
    private int[] clazz_ids;
    private Date start_date;
    private Date end_date;
    private int clazz_id;

    public Clazz_Paper() {
    }

    @Override
    public String toString() {
        return "Clazz_Paper{" +
                "id=" + id +
                ", paper_id=" + paper_id +
                ", clazz_ids=" + clazz_ids +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }

    public int getClazz_id() {
        return clazz_id;
    }

    public void setClazz_id(int clazz_id) {
        this.clazz_id = clazz_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPaper_id() {
        return paper_id;
    }

    public void setPaper_id(int paper_id) {
        this.paper_id = paper_id;
    }

    public int[] getClazz_ids() {
        return clazz_ids;
    }

    public void setClazz_ids(int[] clazz_ids) {
        this.clazz_ids = clazz_ids;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }
}
