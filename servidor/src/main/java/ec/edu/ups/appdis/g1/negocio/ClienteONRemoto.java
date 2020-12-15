package ec.edu.ups.appdis.g1.negocio;

import javax.ejb.Remote;

import ec.edu.ups.appdis.g1.modelo.Cliente;

@Remote
public interface ClienteONRemoto {
	public boolean registrarPersona(Cliente cliente) throws Exception;
	public Cliente buscarPersona(String cedula) throws Exception;

}
