package com.citasmedicas_backend.mapper;

import com.citasmedicas_backend.dtos.PacienteDTO;
import com.citasmedicas_backend.entities.PacienteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PacienteMapper {

    PacienteMapper INSTANCE = Mappers.getMapper(PacienteMapper.class);

    PacienteDTO toDto(PacienteEntity pacienteEntity);
    PacienteEntity toEntity(PacienteDTO pacienteDTO);

    List<PacienteDTO> toDto(List<PacienteEntity> pacienteEntityList);
    List<PacienteEntity> toEntity(List<PacienteDTO> pacienteDTOList);
}
