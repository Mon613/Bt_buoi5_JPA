package org.example.bt_buoi5_jpa.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity(name = "product")
@Data
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private float price;
    private String category;

}
