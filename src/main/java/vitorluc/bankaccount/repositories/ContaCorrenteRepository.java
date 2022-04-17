package vitorluc.bankaccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vitorluc.bankaccount.entities.ContaCorrente;

import java.util.Optional;

@Repository
public interface ContaCorrenteRepository extends JpaRepository<ContaCorrente, Long> {

    @Query("SELECT cc FROM ContaCorrente cc " +
            "WHERE cc.id = :numConta AND cc.agencia.id = :numAgencia")
    Optional<ContaCorrente> buscarPorContaAgencia(Long numConta, Long numAgencia);
}
