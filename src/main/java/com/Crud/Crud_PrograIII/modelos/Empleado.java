package com.Crud.Crud_PrograIII.modelos;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="Empleado")
@Getter
@Setter
public class Empleado {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Codigo",unique=true, nullable = false)
    private Integer Codigo;
    @Column(name ="Nombres",unique=false, nullable = false)
    private String Nombres;
    @Column(name ="Apellidos",unique=false, nullable = false)
    private String Apellidos;
    @Column(name ="Dpi",unique=false, nullable = false)
    private String Dpi;
    @Column(name ="Estado",unique=false, nullable = false)
    private String Estado;
    @Column(name ="Fecha_creacion",unique=false, nullable = true)
    private String Fecha_creacion;
    @Column(name ="Fecha_modificacion",unique=false, nullable = true)
    private String Fecha_modificacion;



}
