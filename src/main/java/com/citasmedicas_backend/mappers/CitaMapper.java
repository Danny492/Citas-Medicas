package com.citasmedicas_backend.mappers;

import com.citasmedicas_backend.dtos.CitaDTO;
import com.citasmedicas_backend.entities.CitaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CitaMapper {

    CitaMapper INSTANCE = Mappers.getMapper(CitaMapper.class);

    @Mapping(target = "doctorId", source = "doctor.id")
    @Mapping(target = "pacienteId", source = "paciente.id")
    CitaDTO toDTO(CitaEntity citaEntity);

    CitaEntity toEntity(CitaDTO citaDTO);

    List<CitaDTO> toDTO(List<CitaEntity> citaEntities);
    List<CitaEntity> toEntity(List<CitaDTO> citaDTOs);
}
