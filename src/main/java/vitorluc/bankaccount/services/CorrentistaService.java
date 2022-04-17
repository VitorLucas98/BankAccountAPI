package vitorluc.bankaccount.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vitorluc.bankaccount.entities.Correntista;
import vitorluc.bankaccount.repositories.CorrentistaRepository;

import javax.transaction.Transactional;

@Transactional
@Service
@RequiredArgsConstructor
public class CorrentistaService {

    private final CorrentistaRepository repository;

    public Correntista consultarCorrentista(String cpf){
        return  repository.findByCpf(cpf).orElseThrow(() -> new RuntimeException());
    }

}
