package com.preving.springboot.backend.apirest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.preving.springboot.backend.apirest.models.entity.Cliente;
import com.preving.springboot.backend.apirest.models.services.IClienteService;


//crosorigin es para decirle que desde esa URL (en este caso la de angular) le das permiso para para acceder a la API
@RestController @RequestMapping("/api") @CrossOrigin(origins = {"http://localhost:4200"})
public class ClienteRestControllers {

	@Autowired private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> clientes(){
		
		return clienteService.FindAll();
	}
	
	@GetMapping("/cliente/{id}")
	public Cliente show(@PathVariable Long id) {
		
		return clienteService.findById(id);
	}

	@PostMapping("/clientes") @ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente) {
		
		return clienteService.save(cliente);
	}
	
	@PutMapping("/clientes/{id}") @ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteActual = clienteService.findById(id);
		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());
		
		return clienteService.save(clienteActual);
	}
	
	@DeleteMapping("/clientes/{id}") @ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		
		clienteService.delete(id);
		
	}
	
}