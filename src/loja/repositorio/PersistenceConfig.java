package loja.repositorio;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceConfig {
	protected static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("SistemasInstrumentosMusicaisDB");
	protected static EntityManager entityManager;

	
	public static EntityManager getEntityManager(){
		if(entityManager == null){
			
			try{
				
				entityManager = entityManagerFactory.createEntityManager();
				System.out.println("Gerenciador de entidades instanciado com sucesso.");
			}
			catch (Exception e){
				System.out.println("Erro ao tentar instanciar um gerenciador de entidades. " +
								   e.getMessage());
			}
		}
		
		return entityManager;
	}
	
	public static void closeEntityManager(){
		if(entityManager != null){
			try{
				entityManager.close();
				entityManager = null;
				System.out.println("Gerenciador de Entidades fechado com sucesso!");
			}
			catch (Exception e){
				System.out.println("Erro ao tentar fechar o gerenciador de entidades. " +
								   e.getMessage());
			}
		}
	}
}
