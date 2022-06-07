package com.Crud.Crud_PrograIII.controlador;

import com.Crud.Crud_PrograIII.dao.EmpleadoDaoImp;
import com.Crud.Crud_PrograIII.modelos.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class controlador {
    @Autowired  private EmpleadoDaoImp EdaoImp;

    @GetMapping("/empleados")
    public String  getEmpleados( Model model)
    {
        List<Empleado> lstEmpleados = EdaoImp.getEmpleados();
        model.addAttribute("listaEmpleados", lstEmpleados);
        return "empleados";
    }

    @GetMapping("/CrearEmpleado/0")
    public String  crearEmpleado( Model model)
    {
        Empleado e = new Empleado();
        model.addAttribute("Empleado", e);
        model.addAttribute("Titulo", "Crear Empleado");
        return "CrearEmpleado";
    }

   @PostMapping("/guardar")
    public String  guardarEmpleado(@Valid Empleado e, Model model)
    {
        EdaoImp.guardarEmpleado(e);
        return "redirect:/empleados";
    }

    @GetMapping("/editar/{Codigo}")
    public  String editar(@PathVariable int Codigo, Model model){
        Optional<Empleado> e = EdaoImp.getEpleadoId(Codigo);
        model.addAttribute("Titulo", "Editar Empleado");
        model.addAttribute("Empleado", e);
        return "CrearEmpleado";
    }

    @GetMapping("/eliminar/{Codigo}")
    public  String eliminar(@PathVariable int Codigo, Model model){
        Optional<Empleado> opE = EdaoImp.getEpleadoId(Codigo);
        opE.ifPresentOrElse(
                (empleado)-> { EdaoImp.eliminarEmpleado(empleado);},
                ()-> {}
        );
        return "redirect:/empleados";
    }

}
