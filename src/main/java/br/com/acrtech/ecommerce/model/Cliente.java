package br.com.acrtech.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter @Setter @ToString @AllArgsConstructor
@NoArgsConstructor @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity @Table(name = "clientes")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private SexoCliente sexo;
}
