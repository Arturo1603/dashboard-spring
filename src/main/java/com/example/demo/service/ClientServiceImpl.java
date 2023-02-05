package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;


@Service
public class ClientServiceImpl implements ClientService {
	
	
	@Autowired
	private ClientRepository clienteRepository;

	@Override
	public List<Client> clientsList() {
		return clienteRepository.findAll();
	}

	@Override	
	public Client clientRegister(Client obj) {
		return clienteRepository.save(obj);
	}

	@Override
	public Optional<Client> obtienePorId(int id) {
		return clienteRepository.findById(id);
	}

	@Override
	public void deleteClient(int id) {
		clienteRepository.deleteById(id);
	}
}
