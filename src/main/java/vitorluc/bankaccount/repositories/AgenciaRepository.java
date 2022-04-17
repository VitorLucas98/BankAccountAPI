package vitorluc.bankaccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vitorluc.bankaccount.entities.Agencia;

@Repository
public interface AgenciaRepository extends JpaRepository<Agencia, Long> {
}
