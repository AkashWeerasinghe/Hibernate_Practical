package lk.jiat.webii.hp.entity;

import jakarta.persistence.*;


@Entity
public class Address implements java.io.Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "line_one", length = 100, nullable = false)
    private String lineone;
    @Column(name = "line_two", length = 100)
    private String linetwo;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getLineone() {return lineone;}

    public void setLineone(String lineone) {this.lineone = lineone;}

    public String getLinetwo() {return linetwo;}

    public void setLinetwo(String linetwo) {this.linetwo = linetwo;}

    public City getCity() {return city;}

    public void setCity(City city) {this.city = city;}
}
