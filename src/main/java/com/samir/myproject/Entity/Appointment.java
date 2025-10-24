package com.samir.myproject.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
public class Appointment {
    //Поля
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;
    //сюда поставить связи
    @Column(name = "appointment_date") private LocalDateTime appointmentDate;
    private String status;

    //Конструкторы
    //Сеттеры
    //Геттеры
}
