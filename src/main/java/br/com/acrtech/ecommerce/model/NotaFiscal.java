package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "notas_fiscais")
public class NotaFiscal {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(name = "pedido_id")
    private Integer pedidoId;
    private String xml;
    @Column(name = "data_emissao")
    private Date dataEmissao;
}
