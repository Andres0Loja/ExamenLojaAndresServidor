package ec.edu.ups.appdis.g1.negocio;

import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.appdis.g1.DAO.ClienteDAO;
import ec.edu.ups.appdis.g1.modelo.Cliente;

@Stateless
public class ClienteON implements ClienteONRemoto{
	@Inject
	private ClienteDAO daoCliente;
	public boolean registrarPersona(Cliente cliente) throws Exception {
		if (cliente.getCedula().length() != 10)
			throw new Exception("La cedula no cumple con la longitud correcta");
		try {
			daoCliente.insertJPA(cliente);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
		return true;
	}
	public Cliente buscarPersona(String cedula) throws Exception {
		if (cedula.length() != 10)
			throw new Exception("La cedula no cumple con la longitud correcta");
		try {
			return  daoCliente.read(cedula);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new Exception("Error al registrar");
		}
	}
}
