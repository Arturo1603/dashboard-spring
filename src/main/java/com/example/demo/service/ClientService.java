package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Client;


public interface ClientService {
	
	public List<Client> clientsList();
	public Client clientRegister(Client obj);
	Optional<Client> obtienePorId(int id);
	void deleteClient(int id);
	
}
