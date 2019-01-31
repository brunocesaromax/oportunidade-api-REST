package com.oportunidade.oportunidadeapi.Controller;

import com.oportunidade.oportunidadeapi.Model.Oportunidade;
import com.oportunidade.oportunidadeapi.Repository.OportunidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/oportunidades")
public class OportunidadeController {//

    @Autowired/*Injeção de dependência*/
    private OportunidadeRepository oportunidadeRepository;

    @GetMapping
    public List<Oportunidade> listar() {
        return oportunidadeRepository.findAll();
    }

    /*Optional pode retornar null ou não*/
    @GetMapping("/{id}")// -> placeholder
    public ResponseEntity<Oportunidade> buscar(@PathVariable Long id) {

        Optional<Oportunidade> oportunidade = oportunidadeRepository.findById(id);

        if (!oportunidade.isPresent()) {
            return ResponseEntity.notFound().build(); /*Código 404*/
        }

        return ResponseEntity.ok(oportunidade.get());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)/*Retornar 201 de que um objeto foi criado*/
    public Oportunidade adicionar(@Valid @RequestBody Oportunidade oportunidade) {/*Primeiro valida objeto para depois ver se pode salvar*/

        Optional<Oportunidade> oportunidadeBD = oportunidadeRepository.findByDescricaoAndAndNomeProspecto(oportunidade.getDescricao(), oportunidade.getNomeProspecto());

        if (oportunidadeBD.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Já existe oportunidade com mesmo nomeProspecto e descrição");
        }

        return oportunidadeRepository.save(oportunidade);
    }
}
