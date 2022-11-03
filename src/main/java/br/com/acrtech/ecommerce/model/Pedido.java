package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "data_pedido")
    private LocalDateTime dataPedido;
    @Column(name = "data_conclusao")
    private LocalDateTime dataConclusao;
    @Column(name = "nota_fiscal_id")
    private Integer notaFiscalId;
    @Enumerated(EnumType.STRING)
    private StatusPedido status;
    private BigDecimal total;
}
