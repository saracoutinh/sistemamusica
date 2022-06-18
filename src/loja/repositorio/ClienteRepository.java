package loja.repositorio;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityTransaction;

import loja.Cliente;

public class ClienteRepository extends PersistenceConfig {

	public boolean criarCliente(Cliente cliente) {
		
			boolean resultado = true;
			EntityTransaction transaction = getEntityManager().getTransaction();
			
			try {
				transaction.begin();
				getEntityManager().persist(cliente);
				transaction.commit();
				
			}  catch (Exception e) {
				System.out.println("Erro ao tentar persistir um novo cliente. " + e.getMessage());
				e.printStackTrace();
				transaction.rollback();
				resultado = false;
			}
			
			return resultado;
	}
	
	public Cliente recuperarClientePorID(int id_cliente) {
		
		Cliente resultado = null;
		
		try {
			
			resultado = getEntityManager().find(Cliente.class, id_cliente);
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar recuperar cliente. " + e.getMessage());
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<Cliente> recuperarCliente(){
		
		Set<Cliente> resultado = null;
		
		try {
			
			Stream<Cliente> clientesStream = getEntityManager().createQuery("FROM " + Cliente.class.getName() +
					" ORDER BY id_cliente ASC").getResultStream();
			
			resultado = clientesStream.collect(Collectors.toSet());
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar recuperar os cliente cadastrados. " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
	
	public boolean atualizarCliente(Cliente cliente) {
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(cliente);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar atualizar os dados do cliente. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirCliente(Cliente cliente) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			cliente = getEntityManager().find(Cliente.class, cliente.getIdCliente());
			getEntityManager().remove(cliente);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o cliente. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirClientePorId(int id_cliente) {
		boolean resultado = true;
		
		try {
			Cliente cliente = recuperarClientePorID(id_cliente);
			resultado = excluirCliente(cliente);
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o cliente. " + e.getMessage());
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}
	
}