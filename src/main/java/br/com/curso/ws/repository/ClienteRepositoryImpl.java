package br.com.curso.ws.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.curso.ws.model.Cliente;

//@Repository
public class ClienteRepositoryImpl {
	
	private Map<Integer, Cliente> clientes;
	private Integer proximoId = 1;

	public void update(Integer id) {
		// TODO Auto-generated method stub
	}

	public Collection<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente add(Cliente cliente) {
		if (clientes == null) {
			clientes = new HashMap<>();
		}
		cliente.setId(proximoId);
		proximoId++;
		
		clientes.put(cliente.getId(), cliente);
		
		return null;
	}

	public void remove(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
