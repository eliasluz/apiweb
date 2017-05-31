package br.com.curso.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.curso.ws.model.Cliente;
import br.com.curso.ws.service.ClienteService;

@RestController
public class ClienteController {

	private static final String URI_CLIENT = "/clientes";
	private static final String URI_CLIENT_ID = "/clientes/{id}";
	
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.POST, value = URI_CLIENT, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Cliente> register(@RequestBody Cliente cliente) {
		Cliente cli = clienteService.add(cliente);
		return new ResponseEntity<Cliente>(cli, HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.GET, value = URI_CLIENT, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> findAll() {
		return new ResponseEntity<>(clienteService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value = URI_CLIENT_ID, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> alterar(@PathVariable Cliente cliente) {
		clienteService.update(cliente);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value = URI_CLIENT_ID)
	public ResponseEntity<Cliente> remove(@PathVariable Integer id) {
		Cliente cliente = clienteService.findById(id);
		
		if (cliente == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			clienteService.remove(cliente);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
