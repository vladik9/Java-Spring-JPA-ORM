package com.example.app.CarVIN;
import com.example.app.Car.Car;
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


@Entity(name = "VIN")
@Table(name = "VIN", uniqueConstraints = {
    @UniqueConstraint(name = "vin_unique_constraint", columnNames = "VIN")
})
public class CarVIN {

    @Id
    @SequenceGenerator(name = "vin_sequence", sequenceName = "vin_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vin_sequence")
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "VIN", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String vin;
    //this is the owner of the relations
     @OneToOne
     @JoinColumn(name = "car_vin_id")
     private Car car;

    public CarVIN() {
    }

    public CarVIN(String vin) {
        this.vin = vin;
    }

    public Long getId() {
        return id;
    }

    public String getVin() {
        return vin;
    }

    @Override
    public String toString() {
        return "CarVIN [id=" + id + ", vin=" + vin + "]";
    }
}
