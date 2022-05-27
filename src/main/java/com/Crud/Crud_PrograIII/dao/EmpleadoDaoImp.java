package com.Crud.Crud_PrograIII.dao;

import com.Crud.Crud_PrograIII.modelos.Empleado;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import  java.util.List;
import java.util.Optional;
import java.util.Date;

@Service
public class EmpleadoDaoImp {

     @Autowired private  EmpleadoDao Edao;

    public List<Empleado> getEmpleados(){
       return (List<Empleado>) Edao.findAll();
    }

    public int guardarEmpleado(Empleado empleado){
        int resp = 0;
        Date date = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        empleado.setEstado("Activo");
        if(empleado.getCodigo()!=null){
            empleado.setFecha_modificacion(dt1.format(date));
         }else{
            empleado.setFecha_creacion(dt1.format(date));
        }
        Empleado emp = Edao.save(empleado);
        if(!emp.equals(null)){
            resp = 1;
        }
        return resp;
    }

    public Optional<Empleado> getEpleadoId(Integer Codigo){
        Optional<Empleado> emp = Edao.findById(Codigo);
        return emp;
    }

    public int eliminarEmpleado(Empleado empleado){
        int resp = 0;
        Date date = new Date();
        SimpleDateFormat dt1 = new SimpleDateFormat("yyyy-MM-dd");
        empleado.setFecha_modificacion(dt1.format(date));
        empleado.setEstado("Eliminado");
        Empleado emp = Edao.save(empleado);
        if(!emp.equals(null)){
            resp = 1;
        }
        return resp;
    }


}
