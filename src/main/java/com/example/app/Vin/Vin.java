package com.example.app.Vin;
import com.example.app.Car.Car;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;



@Entity(name = "Vin")
@Table(name = "vin", uniqueConstraints = {
    @UniqueConstraint(name = "vin_unique_constraint", columnNames = "vin")
})
public class Vin {

    @Id
    @SequenceGenerator(name = "vin_sequence", sequenceName = "vin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vin_sequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "vin", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String vin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car car;
    
    public Vin() {
    }

    public Vin(String vin, Car car) {
        this.vin = vin;
        this.car = car;
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    
    public void setVin(String vin) {
        this.vin = vin;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "VIN [id=" + id + ", vin=" + vin + "]";
    }
}