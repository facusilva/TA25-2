package com.example.demo.controller;

import java.util.List;
import com.example.demo.dto.Departamento;
import com.example.demo.service.DepartamentoServiceImpl;

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
public class DepartamentoController {

	@Autowired
	DepartamentoServiceImpl DepartamentoServiceImpl;
	
	//listar todos los Departamentos
	@GetMapping("/departamentos")
	public List<Departamento> listarDepartamentos(){
		return DepartamentoServiceImpl.listarDepartamentos();
	}
	
	//guardar un Departamento
	@PostMapping("/departamentos")
	public Departamento salvarDepartamento(@RequestBody Departamento Departamento) {//los datos del Departamento llegan en formato JSON desde el Request Body
		return DepartamentoServiceImpl.guardarDepartamento(Departamento);
	}
	
	//muestro un Departamento según el ID indicada
	@GetMapping("/departamentos/{id}") 
	public Departamento DepartamentoXID(@PathVariable(name="id") Long id){ // el id del Departamento llega desde la variable del path
		Departamento Departamento_xid = new Departamento();//creo una instancia de la clase Departamento
		
		Departamento_xid=DepartamentoServiceImpl.DepartamentoXID(id);//busco el Departamento según el ID y le asigno los datos a la instancia de la clase Departamento
		
		System.out.println("Departamento XID: "+Departamento_xid);
		
		return Departamento_xid;//devuelvo el Departamento en formato JSON
	}
	
	//Actualizo los datos de un Departamento según el ID indicada
	@PutMapping("/departamentos/{id}")
	public Departamento actualizarDepartamento(@PathVariable(name="id")Long id,@RequestBody Departamento Departamento) {
		
		Departamento Departamento_seleccionado= new Departamento();
		Departamento Departamento_actualizado= new Departamento();
		
		Departamento_seleccionado= DepartamentoServiceImpl.DepartamentoXID(id);
		
		Departamento_seleccionado.setNombre(Departamento.getNombre());
		Departamento_seleccionado.setEmpleado(Departamento.getEmpleado());
		
		Departamento_actualizado = DepartamentoServiceImpl.actualizarDepartamento(Departamento_seleccionado);
		
		System.out.println("El Departamento actualizado es: "+ Departamento_actualizado);
		
		return Departamento_actualizado;
	}
	
	//borro el Departamento indicado por el ID que llega en la variable del path
	@DeleteMapping("/departamentos/{id}")
	public void eleiminarDepartamento(@PathVariable(name="id")Long id) {
		DepartamentoServiceImpl.eliminarDepartamento(id);
	}
}
