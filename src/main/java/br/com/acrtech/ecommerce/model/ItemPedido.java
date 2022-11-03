package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "itens_pedido")
public class ItemPedido {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    @Column(name = "produto_id")
    private Integer produtoId;
    @Column(name = "preco_produto")
    private BigDecimal precoProduto;
    private Integer quantidade;
}
