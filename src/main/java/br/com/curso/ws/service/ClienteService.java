package br.com.curso.ws.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.curso.ws.model.Cliente;
import br.com.curso.ws.repository.ClienteRepository;
	
@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente add(Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	public Collection<Cliente> findAll() {
		return clienteRepository.findAll();
	}
	
	public Cliente findById(Integer id) {
		return clienteRepository.findOne(id);
	}
	
	public void update(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void remove(Cliente cliente) {
		clienteRepository.delete(cliente);
	}
}
