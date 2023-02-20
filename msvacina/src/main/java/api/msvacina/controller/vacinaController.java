package api.msvacina.controller;

import api.msvacina.mapper.VacinaMapper;
import api.msvacina.service.VacinaService;
import io.swagger.api.VacinaApi;

import io.swagger.model.VacinaDTO;
import io.swagger.model.VacinaRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class vacinaController implements VacinaApi {

    @Autowired
    public VacinaService vacinaService;

    @Autowired
    public VacinaMapper vacinaMapper;

    @Override
    public ResponseEntity<VacinaDTO> findByName(String nome){
        var vacinaDTO = vacinaMapper.toDTO(vacinaService.findByName(nome));
        return ResponseEntity.ok().body(vacinaDTO);
    }

    @Override
    public ResponseEntity<Void> save(VacinaRequest vacinaRequest) {
        vacinaService.save(vacinaRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
