package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "pagamentos_boleto")
public class PagamentoBoleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Enumerated(EnumType.STRING)
    private StatusPagamento status;
    @Column(name = "codigo_barras")
    private Integer codigoBarras;
}
