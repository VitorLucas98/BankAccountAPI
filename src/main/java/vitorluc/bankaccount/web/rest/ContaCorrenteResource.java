package vitorluc.bankaccount.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vitorluc.bankaccount.entities.ContaCorrente;
import vitorluc.bankaccount.services.ContaCorrenteService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/contasCorrentes")
public class ContaCorrenteResource {

    private final ContaCorrenteService service;

    @PatchMapping("consultarSaldo/{numConta}/{numAgencia}")
    public ResponseEntity<Double> consultarSaldo(@PathVariable Long numConta, @PathVariable Long numAgencia){
        return ResponseEntity.ok(service.consultarSaldo(numConta, numAgencia));
    }

    @PatchMapping("/depositar/{numConta}/{numAgencia}/valor/{valor}")
    public ResponseEntity<Double> depositar(@PathVariable Long numConta, @PathVariable Long numAgencia, @PathVariable Double valor){
        return ResponseEntity.ok(service.depositar(numConta, numAgencia, valor));
    }

    @PatchMapping("/sacar/{numConta}/{numAgencia}/valor/{valor}")
    public ResponseEntity<Double> sacar(@PathVariable Long numConta, @PathVariable Long numAgencia, @PathVariable Double valor){
        return ResponseEntity.ok(service.sacar(numConta, numAgencia, valor));
    }

    @PatchMapping("/transferir/{numContaOrigem}/{numAgenciaOrigem}" +
            "/para/{numContaDestino}/{numAgenciaDestino}/valor/{valor}")
    public ResponseEntity<Double> transferir(@PathVariable Long numContaOrigem, @PathVariable Long numAgenciaOrigem,
                                               @PathVariable Long numContaDestino, @PathVariable Long numAgenciaDestino,
                                               @PathVariable Double valor){
        return ResponseEntity.ok(service.transferir(numContaOrigem, numAgenciaOrigem, numContaDestino, numAgenciaDestino, valor));
    }

    @PatchMapping("desativar/{numConta}/{numAgencia}")
    public ResponseEntity<ContaCorrente> destivarConta(@PathVariable Long numConta, @PathVariable Long numAgencia){
        return ResponseEntity.ok(service.desativarConta(numConta, numAgencia));
    }

    @GetMapping
    public ResponseEntity<List<ContaCorrente>> buscarTodasContas(){
        return ResponseEntity.ok(service.buscarTodasContas());
    }
}
