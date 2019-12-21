package com.fhernandez.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fhernandez.Model.Vacante;

@Controller
public class HomeController {
	
	@GetMapping(value="/tabla")
	public String mostrarTabla(Model model) {
		List<Vacante> getList = this.getListVacante();
		model.addAttribute("vacantes", getList);
		return "tabla";
	}
	@GetMapping(value = "detalle")
	public String mostrarDetalle(Model model) {
		Vacante vacante = new Vacante();
		vacante.setNombre("Ingeniero de telecomunicaciones.");
		vacante.setDescripcion("Se solicita ingeniero para dar soporte a intranet");
		vacante.setFecha(new Date());
		vacante.setSalario(9700.00);
		model.addAttribute("vacante", vacante);
		
		return "detalle";	
	}
	
	@GetMapping(value = "/listado")
	public String mostrarListado(Model model) {
		List<String> listVacantes = new LinkedList<String>();
		listVacantes.add("Ingeniero de Sistemas");
		listVacantes.add("Auxiliar de contabilidad");
		listVacantes.add("Vendedor");
		listVacantes.add("Arquitecto");
		model.addAttribute("empleos", listVacantes);
		
	
		return "listado";
	}
	
	@GetMapping(value = "/")
	public String mostrarIndex(Model model) {
		/*
		 * model.addAttribute("mensaje", "Bienvenidos a empleos Apps");
		 * model.addAttribute("fecha", new Date());
		 */
		String nombreVacante = "Auxiliar de contabilidad";
		Date fechaPublicada = new Date();
		boolean vigente = true;
		Double salario = 9000.00;
		
		model.addAttribute("vacante", nombreVacante);
		model.addAttribute("fecha", fechaPublicada);
		model.addAttribute("vigencia", vigente);
		model.addAttribute("salario", salario);
		
		return "home";
	}
	
	public List<Vacante> getListVacante(){
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
		List<Vacante> vacanteList = new LinkedList<Vacante>();
		try {
		Vacante vacante = new Vacante();
		vacante.setId(1);
		vacante.setNombre("Auxiliar de almacen");
		vacante.setDescripcion("Agregar la disponibilidad de materiales a sistema contable.");
		vacante.setFecha(formato.parse("22-02-2019"));
		vacante.setDestacado(1);
		vacante.setImagen("empresa1.png");
		vacante.setSalario(7000.00);
		
		Vacante vacante1 = new Vacante();
		vacante1.setId(2);
		vacante1.setNombre("Auxiliar de mostrador");
		vacante1.setDescripcion("Ofrecer producto al cliente segun la necesidad");
		vacante1.setFecha(formato.parse("02-04-2019"));
		vacante1.setSalario(8000.00);
		vacante1.setDestacado(0);
		vacante1.setImagen("empresa2.png");
		
		Vacante vacante2 = new Vacante();
		vacante2.setId(3);
		vacante2.setNombre("Diseñador web");
		vacante2.setDescripcion("Diseñar paginas web para sistemas dinamicos e interativos para el el cliente");
		vacante2.setFecha(formato.parse("06-06-2019"));
		vacante2.setSalario(12000.00);
		vacante2.setDestacado(0);
		vacante2.setImagen("empresa3.png");
		
		Vacante vacante3 = new Vacante();
		vacante3.setId(4);
		vacante3.setNombre("Desarrollador de sistema web");
		vacante3.setDescripcion("Desarrollar backend .net");
		vacante3.setFecha(formato.parse("12-01-2019"));
		vacante3.setSalario(15000.00);
		vacante3.setDestacado(1);
		vacante3.setImagen("empresa4.png");
		
		vacanteList.add(vacante);
		vacanteList.add(vacante1);
		vacanteList.add(vacante2);
		vacanteList.add(vacante3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: " + e.getMessage());
		}
		
		return vacanteList;
	}

}
