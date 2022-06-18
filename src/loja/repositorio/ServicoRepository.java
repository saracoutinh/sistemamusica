package loja.repositorio;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityTransaction;

import loja.Servico;

public class ServicoRepository extends PersistenceConfig {
	
	public boolean criarServico(Servico servico) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			transaction.begin();
			getEntityManager().persist(servico);
			transaction.commit();
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar persistir um novo servico. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public Servico recuperarServicoPorID(int id_servico) {
		
		Servico resultado = null;
		
		try {
			
			resultado = getEntityManager().find(Servico.class, id_servico);
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar recuperar o servico. " + e.getMessage());
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<Servico> recuperarServico(){
		
		Set<Servico> resultado = null;
		
		try {
			
			Stream<Servico> servicosStream = getEntityManager().createQuery("FROM " + Servico.class.getName() +
					" ORDER BY id_servico ASC").getResultStream();
			
			resultado = servicosStream.collect(Collectors.toSet());
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar recuperar os serviços cadastrados. " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
	
	public boolean atualizarServico(Servico servico) {
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(servico);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar atualizar os dados do serviço. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirServico(Servico servico) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			servico = getEntityManager().find(Servico.class, servico.getIdServico());
			getEntityManager().remove(servico);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o serviço. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirServicoPorId(int id_servico) {
		boolean resultado = true;
		
		try {
			Servico servico = recuperarServicoPorID(id_servico);
			resultado = excluirServico(servico);
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o serviço. " + e.getMessage());
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}


}
