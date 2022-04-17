package vitorluc.bankaccount.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vitorluc.bankaccount.entities.Agencia;
import vitorluc.bankaccount.repositories.AgenciaRepository;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class AgenciaService {

    private final AgenciaRepository repository;

    public Agencia buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Agência não existe"));
    }
}
