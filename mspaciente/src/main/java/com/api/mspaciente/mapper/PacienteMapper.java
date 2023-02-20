package com.api.mspaciente.mapper;


import com.api.mspaciente.model.Paciente;
import io.swagger.model.PacienteDTO;
import io.swagger.model.PacienteRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDTO toDTO(Paciente paciente);

    Paciente toEntity(PacienteRequest pacienteRequest);
}
