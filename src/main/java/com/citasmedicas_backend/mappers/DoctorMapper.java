package com.citasmedicas_backend.mappers;

import com.citasmedicas_backend.dtos.DoctorDTO;
import com.citasmedicas_backend.entities.DoctorEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface DoctorMapper {

    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorDTO toDTO(DoctorEntity doctorEntity);
    DoctorEntity toEntity(DoctorDTO doctorDTO);

    List<DoctorDTO> toDTO(List<DoctorEntity> doctorEntities);
    List<DoctorEntity> toEntity(List<DoctorDTO> doctorDTOs);
}
