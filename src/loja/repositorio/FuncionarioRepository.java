package loja.repositorio;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityTransaction;

import loja.Funcionario;

public class FuncionarioRepository extends PersistenceConfig {
	
	public boolean criarFuncionario(Funcionario funcionario) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			transaction.begin();
			getEntityManager().persist(funcionario);
			transaction.commit();
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar persistir um novo funcionario. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public Funcionario recuperarFuncionarioPorID(int id_funcionario) {
		
		Funcionario resultado = null;
		
		try {
			
			resultado = getEntityManager().find(Funcionario.class, id_funcionario);
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar recuperar funcionario. " + e.getMessage());
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<Funcionario> recuperarFuncionario(){
		
		Set<Funcionario> resultado = null;
		
		try {
			
			Stream<Funcionario> funcionariosStream = getEntityManager().createQuery("FROM " + Funcionario.class.getName() +
					" ORDER BY id_funcionario ASC").getResultStream();
			
			resultado = funcionariosStream.collect(Collectors.toSet());
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar recuperar os funcionario cadastrados. " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
	
	public boolean atualizarFuncionario(Funcionario funcionario) {
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(funcionario);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar atualizar os dados do funcionario. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirFuncionario(Funcionario funcionario) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			funcionario = getEntityManager().find(Funcionario.class, funcionario.getIdFuncionario());
			getEntityManager().remove(funcionario);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o funcionário. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirFuncionarioPorId(int id_funcionario) {
		boolean resultado = true;
		
		try {
			Funcionario funcionario = recuperarFuncionarioPorID(id_funcionario);
			resultado = excluirFuncionario(funcionario);
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o funcionário. " + e.getMessage());
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}

	

}
