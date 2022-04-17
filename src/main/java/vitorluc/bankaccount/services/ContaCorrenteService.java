package vitorluc.bankaccount.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import vitorluc.bankaccount.entities.ContaCorrente;
import vitorluc.bankaccount.repositories.ContaCorrenteRepository;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class ContaCorrenteService {

    private final ContaCorrenteRepository repository;

    public Double consultarSaldo(Long numConta, Long numAgencia){
        ContaCorrente cc = repository.buscarPorContaAgencia(numConta, numAgencia)
                .orElseThrow(() -> new RuntimeException("Conta Corrente inexistente!"));
        return cc.getSaldo();
    }

    public Double depositar(Long numConta, Long numAgencia, Double valor){
        if (valor <= 0){
            throw new RuntimeException("Valor menor ou igual a zero!");
        }
        ContaCorrente cc = repository.buscarPorContaAgencia(numConta, numAgencia)
                .orElseThrow(() -> new RuntimeException("Conta Corrente inexistente!"));
        cc.setSaldo(cc.getSaldo() + valor);
        cc = repository.save(cc);
        return cc.getSaldo();
    }

    public Double sacar(Long numConta, Long numAgencia, Double valor){
        if (valor <= 0){
            throw new RuntimeException("Valor menor ou igual a zero!");
        }
        ContaCorrente cc = repository.buscarPorContaAgencia(numConta, numAgencia)
                .orElseThrow(() -> new RuntimeException("Conta Corrente inexistente!"));
        cc.setSaldo(cc.getSaldo() - valor);
        cc = repository.save(cc);
        return cc.getSaldo();
    }

    public Double transferir(Long numContaOrigem, Long numAgenciaOrigem,
                                       Long numContaDestino, Long numAgenciaDestino,
                                        Double valor){
        ContaCorrente ccOrigem = repository.buscarPorContaAgencia(numContaOrigem, numAgenciaOrigem)
                .orElseThrow(() -> new RuntimeException("Conta de origem inexistente!"));
        ContaCorrente ccDestino = repository.buscarPorContaAgencia(numContaDestino, numAgenciaDestino)
                .orElseThrow(() -> new RuntimeException("Conta de destino inexistente!"));
        if (valor <= 0){
            throw new RuntimeException("Valor menor ou igual a zero!");
        }
        ccOrigem.setSaldo(ccOrigem.getSaldo() - valor);
        ccDestino.setSaldo(ccDestino.getSaldo() + valor);
        repository.saveAll(Arrays.asList(ccOrigem, ccDestino));
        return ccOrigem.getSaldo();
    }

    public ContaCorrente desativarConta(Long numConta, Long numAgencia){
        ContaCorrente cc = repository.buscarPorContaAgencia(numConta, numAgencia)
                .orElseThrow(() -> new RuntimeException("Conta corrente inexistente!"));
        cc.setAtiva('F');
        cc = repository.save(cc);
        return cc;
    }

    public List<ContaCorrente> buscarTodasContas(){
        return repository.findAll();
    }

}
