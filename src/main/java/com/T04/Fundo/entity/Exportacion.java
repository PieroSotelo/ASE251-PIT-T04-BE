package com.T04.Fundo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "Exportaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exportacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_exportacion")
    private Integer idExportacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_venta", nullable = false)
    private Venta venta;

    @Column(name = "pais_destino", length = 100)
    private String paisDestino;

    @Column(name = "fecha_exportacion")
    private LocalDate fechaExportacion;

    @Column(name = "empresa_transporte", length = 100)
    private String empresaTransporte;

    @Column(name = "estado_exportacion", length = 50)
    private String estadoExportacion; // Pendiente, Enviado, Entregado
}
