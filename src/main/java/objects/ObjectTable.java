package objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@javax.persistence.Table(name = "parsing_table")

public class ObjectTable {
    @Id
    @Column(name = "chto_kupit")
    private String a;
    @Column(name = "kolichestvo")
    private Integer b;
    @Column(name = "stoimost_kr")
    private Integer c;
    @Column(name = "deistvija")
    private String d;

    public ObjectTable(String columnOne, Integer clumnTwo, Integer columnThree, String columnFour) {
        this.a = columnOne;
        this.b = clumnTwo;
        this.c = columnThree;
        this.d = columnFour;
    }

    public ObjectTable() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectTable that = (ObjectTable) o;
        return a.equals(that.a);
    }

    @Override
    public String toString() {
        return "Table{" +
                "chto_kupit='" + a + '\'' +
                ", kolichestvo=" + b +
                ", stoimost_kr=" + c +
                ", deistvija='" + d + '\'' +
                '}';
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }
}
