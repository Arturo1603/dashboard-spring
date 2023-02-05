package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	
	@GetMapping("/clients")
	public List<Client> clientList(){
		return clientService.clientsList(); 
	}
	
//	@PostMapping("/saveClient")
//	public String saveClient(Client obj) {
//		clientService.clientRegister(obj);
//		return HttpStatus.OK;
//	}
	

    @PostMapping("/saveClient")
    public ResponseEntity<String> addClient(@RequestBody Client client) {
    	clientService.clientRegister(client);
    	String mensaje = "Creacion exitosa";
        return new ResponseEntity<>( mensaje ,HttpStatus.OK);
    }
    
    
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable int id){
    	clientService.deleteClient(id);
    	return new ResponseEntity<>("Cliente eliminado con exito", HttpStatus.OK);
    }
    
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable int id, @RequestBody Client client) {
		Optional<Client> updateClient = clientService.obtienePorId(id);
		
        if(updateClient.isPresent()) {
        	Client cliente = updateClient.get();
        	cliente.setNombre(client.getNombre());
        	cliente.setA_paterno(client.getA_paterno());
        	cliente.setA_materno(client.getA_materno());
        	cliente.setDireccion(client.getDireccion());
        	cliente.setDni(client.getDni());
        	cliente.setReferencia(client.getReferencia());
        	cliente.setTelefono(client.getTelefono());
        	
        	return new ResponseEntity<>(clientService.clientRegister(cliente), HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
