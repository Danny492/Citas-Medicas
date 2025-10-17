package com.citasmedicas_backend.dtos;

import com.citasmedicas_backend.validators.Cedula;
import com.citasmedicas_backend.validators.Telefono;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PacienteDTO {
    private Long id;
    @NotBlank(message = "El nombre es obligatorio")
    @Size(message = "El nombre debe tener entre 3 y 50 caracteres", max = 50, min = 3)
    private String nombre;
    @NotBlank(message = "La cedula es obligatoria")
    @Cedula
    private String cedula;
    @Email(message = "Debe ingresar un correo valido")
    @NotBlank(message = "El email es obligatorio")
    private String correo;
    @Telefono
    @NotBlank(message = "El telefono es obligatorio")
    private String telefono;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "PacienteDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cedula='" + cedula + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
