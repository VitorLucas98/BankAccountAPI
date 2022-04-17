package vitorluc.bankaccount.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ContaCorrente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_correntista", referencedColumnName = "id")
    @JsonIgnore
    private Correntista correntista;

    @OneToOne
    @JoinColumn(name = "id_agencia", referencedColumnName = "id")
    private  Agencia agencia;

    private Double limite;

    private Double saldo;

    private char ativa = 'T';
}
