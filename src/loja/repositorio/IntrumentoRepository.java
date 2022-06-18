package loja.repositorio;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityTransaction;

import loja.Instrumento;

public class IntrumentoRepository extends PersistenceConfig {
	
	public boolean criarInstrumento(Instrumento instrumento) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			transaction.begin();
			getEntityManager().persist(instrumento);
			transaction.commit();
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar persistir um novo instrumento. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
	}
	
	public Instrumento recuperarInstrumentoPorID(int id_instrumento) {
		
		Instrumento resultado = null;
		
		try {
			
			resultado = getEntityManager().find(Instrumento.class, id_instrumento);
			
		}  catch (Exception e) {
			System.out.println("Erro ao tentar recuperar o instrumento. " + e.getMessage());
			e.printStackTrace();
		}
		
		return resultado;
		
	}
	
	@SuppressWarnings("unchecked")
	public Set<Instrumento> recuperarInstrumento(){
		
		Set<Instrumento> resultado = null;
		
		try {
			
			Stream<Instrumento> instrumentosStream = getEntityManager().createQuery("FROM " + Instrumento.class.getName() +
					" ORDER BY id_instrumento ASC").getResultStream();
			
			resultado = instrumentosStream.collect(Collectors.toSet());
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar recuperar os instrumentos cadastrados. " + e.getMessage());
			e.printStackTrace();
			
		}
		
		return resultado;
		
	}
	
	public boolean atualizarInstrumento(Instrumento instrumento) {
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			getEntityManager().merge(instrumento);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar atualizar os dados do instrumento. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirInstrumento(Instrumento instrumento) {
		
		boolean resultado = true;
		EntityTransaction transaction = getEntityManager().getTransaction();
		
		try {
			
			transaction.begin();
			instrumento = getEntityManager().find(Instrumento.class, instrumento.getIdInstrumentos());
			getEntityManager().remove(instrumento);
			transaction.commit();
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o instrumento. " + e.getMessage());
			e.printStackTrace();
			transaction.rollback();
			resultado = false;
		}
		
		return resultado;
		
	}
	
	public boolean excluirInstrumentoPorId(int id_instrumento) {
		boolean resultado = true;
		
		try {
			Instrumento instrumento = recuperarInstrumentoPorID(id_instrumento);
			resultado = excluirInstrumento(instrumento);
			
		} catch (Exception e) {
			
			System.out.println("Erro ao tentar remover o instrumento. " + e.getMessage());
			e.printStackTrace();
			resultado = false;
		}
		
		return resultado;
	}


}
