package vitorluc.bankaccount.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriaConta implements Serializable {

    private Long numAgencia;
    private String nome;
    private LocalDate dataNascimento;
    private String cpf;
    private Double limite;
    private Double saldo;
}
