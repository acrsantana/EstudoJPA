package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "estoque")
public class Estoque {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "produto_id")
    private Integer produtoId;
    private Integer quantidade;
}
