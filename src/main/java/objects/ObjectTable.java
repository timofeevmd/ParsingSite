package objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@javax.persistence.Table(name = "parsing_table")
public class ObjectTable {
    @Id
    private String chto_kupit;
    @Column
    private Integer kolichestvo;
    @Column
    private Integer stoimost_kr;
    @Column
    private String deistvija;

    public ObjectTable(String columnOne, Integer clumnTwo, Integer columnThree, String columnFour) {
        this.chto_kupit = columnOne;
        this.kolichestvo = clumnTwo;
        this.stoimost_kr = columnThree;
        this.deistvija = columnFour;
    }

    public ObjectTable() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectTable that = (ObjectTable) o;
        return chto_kupit.equals(that.chto_kupit);
    }

    @Override
    public String toString() {
        return "Table{" +
                "chto_kupit='" + chto_kupit + '\'' +
                ", kolichestvo=" + kolichestvo +
                ", stoimost_kr=" + stoimost_kr +
                ", deistvija='" + deistvija + '\'' +
                '}';
    }

    public String getChto_kupit() {
        return chto_kupit;
    }

    public void setChto_kupit(String chto_kupit) {
        this.chto_kupit = chto_kupit;
    }

    public Integer getKolichestvo() {
        return kolichestvo;
    }

    public void setKolichestvo(Integer kolichestvo) {
        this.kolichestvo = kolichestvo;
    }

    public Integer getStoimost_kr() {
        return stoimost_kr;
    }

    public void setStoimost_kr(Integer stoimost_kr) {
        this.stoimost_kr = stoimost_kr;
    }

    public String getDeistvija() {
        return deistvija;
    }

    public void setDeistvija(String deistvija) {
        this.deistvija = deistvija;
    }
}
