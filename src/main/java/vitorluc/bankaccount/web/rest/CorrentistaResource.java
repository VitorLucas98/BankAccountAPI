package vitorluc.bankaccount.web.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vitorluc.bankaccount.services.CorrentistaService;
import vitorluc.bankaccount.entities.Correntista;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/correntistas")
public class CorrentistaResource {

    private final CorrentistaService service;

    @GetMapping("/{cpf}")
    public ResponseEntity<Correntista> consultarCorrentista(@PathVariable String cpf){
        return  ResponseEntity.ok(service.consultarCorrentista(cpf));
    }
}
