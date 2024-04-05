package com.example.app.Vin;

import com.example.app.Car.Car;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(name = "vin", nullable = false, updatable = true)
    private String vin;

    @OneToOne(mappedBy = "vin")
    private Car car;

    public Vin() {
    }

    public Vin(String vin) {
        this.vin = vin;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    @Override
    public String toString() {
        return "Vin [id=" + id + ", vin=" + vin + "]";
    }

}
