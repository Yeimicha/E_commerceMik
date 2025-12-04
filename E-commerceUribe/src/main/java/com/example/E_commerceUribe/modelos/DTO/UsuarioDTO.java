package com.example.E_commerceUribe.modelos.DTO;

import com.example.E_commerceUribe.ayudas.EstadosUsuario;
// Asumiendo que tienes un enum para el tipo de documento:
import com.example.E_commerceUribe.ayudas.TipoDocumento;

import java.time.LocalDate;

public class UsuarioDTO {
    private Integer id;
    private String nombres;
    private EstadosUsuario estado;
    private String correo;
    private LocalDate fechaNacimiento;
    private String documento;
    private String contraseña;
    private TipoDocumento tipoDocumento;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Integer id, String nombres, EstadosUsuario estado, String correo, LocalDate fechaNacimiento, String documento, String contraseña, TipoDocumento tipoDocumento) {
        this.id = id;
        this.nombres = nombres;
        this.estado = estado;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.documento = documento;
        this.contraseña = contraseña;
        this.tipoDocumento = tipoDocumento;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public EstadosUsuario getEstado() { return estado; }
    public void setEstado(EstadosUsuario estado) { this.estado = estado; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }
    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public String getDocumento() { return documento; }
    public void setDocumento(String documento) { this.documento = documento; }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TipoDocumento tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
}