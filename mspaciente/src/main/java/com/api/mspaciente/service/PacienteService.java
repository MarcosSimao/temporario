package com.api.mspaciente.service;

import com.api.mspaciente.mapper.PacienteMapper;
import com.api.mspaciente.model.Exception.ObjectConflictException;
import com.api.mspaciente.model.Exception.ObjectNotFoundException;
import com.api.mspaciente.model.Paciente;
import com.api.mspaciente.repository.PacienteRepository;
import io.swagger.model.PacienteRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Transactional
    public void save(PacienteRequest pacienteRequest) {
        existsPaciente(pacienteRequest.getCpf());
        Paciente paciente = pacienteMapper.toEntity(pacienteRequest);
        pacienteRepository.save(paciente);
    }

    public Paciente findByCpf(String cpf){
        Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
        if(!paciente.isPresent()){
            throw new ObjectNotFoundException("Paciente não encontrado");
        }
        return paciente.get();
    }

    public void existsPaciente(String cpf){
       if(pacienteRepository.existsByCpf(cpf)){
            throw new ObjectConflictException("Paciente já cadastrado!");
       }
    }
}
