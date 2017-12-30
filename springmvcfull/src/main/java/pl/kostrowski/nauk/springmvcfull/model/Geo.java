package pl.kostrowski.nauk.springmvcfull.model;

import javax.persistence.*;

@Entity
@Table(name = "geo")
public class Geo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "lat")
    private Double lat;

    @Column(name = "lng")
    private Double lng;


    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
