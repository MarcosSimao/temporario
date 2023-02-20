package com.api.mspaciente.controller;

import com.api.mspaciente.mapper.PacienteMapper;
import com.api.mspaciente.service.PacienteService;
import io.swagger.api.PacienteApi;
import io.swagger.model.PacienteDTO;
import io.swagger.model.PacienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PacienteController implements PacienteApi {

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Override
    public ResponseEntity<PacienteDTO> findByCpf(String cpf){
        PacienteDTO paciente = pacienteMapper.toDTO(pacienteService.findByCpf(cpf));
        return ResponseEntity.ok().body(paciente);
    }
    @Override
    public ResponseEntity<Void> save(PacienteRequest pacienteRequest){
        pacienteService.save(pacienteRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
