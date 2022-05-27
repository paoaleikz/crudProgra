package com.Crud.Crud_PrograIII.dao;


import com.Crud.Crud_PrograIII.modelos.Empleado;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmpleadoDao extends CrudRepository<Empleado, Integer> { }

