package com.T04.Fundo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Cosechas")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cosecha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cosecha")
    private Integer idCosecha;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_producto", nullable = false)
    @JsonIgnoreProperties({"cosechas", "hibernateLazyInitializer", "handler"})
    private Producto producto;

    @Column(name = "cantidad_cosechada", nullable = false, precision = 10, scale = 2)
    private BigDecimal cantidadCosechada;

    @Column(name = "fecha_cosecha", nullable = false)
    private LocalDate fechaCosecha;

    @Column(name = "observaciones", length = 255)
    private String observaciones;
}
