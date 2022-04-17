package vitorluc.bankaccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorluc.bankaccount.entities.Correntista;

import java.util.Optional;

@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long> {

    Optional<Correntista> findByCpf(String cpf);
}
