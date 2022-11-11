package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Empleado;
import com.example.demo.service.EmpleadoServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class EmpleadoController {

	@Autowired
	EmpleadoServiceImpl EmpleadoServiceImpl;
	
	//listar todos los Empleados
	@GetMapping("/empleados")
	public List<Empleado> listarEmpleados(){
		return EmpleadoServiceImpl.listarEmpleados();
	}
	
	//guardar un Empleado
	@PostMapping("/empleados")
	public Empleado salvarEmpleado(@RequestBody Empleado Empleado) {//los datos del Empleado llegan en formato JSON desde el Request Body
		return EmpleadoServiceImpl.guardarEmpleado(Empleado);
	}
	
	//muestro un Empleado según el ID indicada
	@GetMapping("/empleados/{id}") 
	public Empleado EmpleadoXID(@PathVariable(name="id") Long id){ // el id del Empleado llega desde la variable del path
		Empleado Empleado_xid = new Empleado();//creo una instancia de la clase Empleado
		
		Empleado_xid=EmpleadoServiceImpl.EmpleadoXID(id);//busco el Empleado según el ID y le asigno los datos a la instancia de la clase Empleado
		
		System.out.println("Empleado XID: "+Empleado_xid);
		
		return Empleado_xid;//devuelvo el Empleado en formato JSON
	}
	
	//Actualizo los datos de un Empleado según el ID indicada
	@PutMapping("/empleados/{id}")
	public Empleado actualizarEmpleado(@PathVariable(name="id")Long id,@RequestBody Empleado Empleado) {
		
		Empleado Empleado_seleccionado= new Empleado();
		Empleado Empleado_actualizado= new Empleado();
		
		Empleado_seleccionado= EmpleadoServiceImpl.EmpleadoXID(id);
		
		Empleado_seleccionado.setNombre(Empleado.getNombre());
		Empleado_seleccionado.setApellidos(Empleado.getApellidos());
		Empleado_seleccionado.setDepartamento(Empleado.getDepartamento());
		
		Empleado_actualizado = EmpleadoServiceImpl.actualizarEmpleado(Empleado_seleccionado);
		
		System.out.println("El Empleado actualizado es: "+ Empleado_actualizado);
		
		return Empleado_actualizado;
	}
	
	//borro el Empleado indicado por el ID que llega en la variable del path
	@DeleteMapping("/empleados/{id}")
	public void eleiminarEmpleado(@PathVariable(name="id")Long id) {
		EmpleadoServiceImpl.eliminarEmpleado(id);
	}
}
