package com.example.bohdan.entities;

import com.example.bohdan.entities.enums.FinancialDataType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class FinancialData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "volume")
    private int volume;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Column(name = "type")
    private FinancialDataType type;

    @Column(name = "percent_change")
    private double percentChange;

    @Column(name = "current_change")
    private double change;

    @Column(name = "price")
    private double price;

    public FinancialData(int volume, LocalDateTime dateTime, FinancialDataType type, double percentChange, double change, double price) {
        this.volume = volume;
        this.dateTime = dateTime;
        this.type = type;
        this.percentChange = percentChange;
        this.change = change;
        this.price = price;
    }
}
