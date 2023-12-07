package org.bedu.java.proyecto.veterinaria.mapper;

import org.bedu.java.proyecto.veterinaria.DTO.ClienteDTO;
import org.bedu.java.proyecto.veterinaria.DTO.NewClienteDTO;
import org.bedu.java.proyecto.veterinaria.entities.Cliente;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ClienteMapper {

    ClienteDTO toDTO(Cliente model);

    @Mapping(target = "nombreCompleto", ignore = true)
    Cliente toModel(NewClienteDTO dto);
//
//    @Mapping(target = "idOwner", ignore = false)
//    Owner toModel(UpdateOwnerDTO dto);

}
