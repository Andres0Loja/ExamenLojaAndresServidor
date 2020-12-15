package ec.edu.ups.appdis.g1.DAO;

import java.sql.Connection;
import java.sql.SQLException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ec.edu.ups.appdis.g1.modelo.Cliente;

@Stateless
public class ClienteDAO {
	@Inject
	private Connection con;
	
	@Inject
	private EntityManager em;
	
	private Cliente cliente;
	
	public boolean insertJPA(Cliente entity) throws SQLException {
		em.persist(entity);
		return true;
	}
	public Cliente read(String cedula) throws Exception {
        try {
            return em.find(Cliente.class, cedula);
        } catch (Exception e) {
            throw new Exception("Erro leer Cliente " +e.getMessage());
        }
    }

}
