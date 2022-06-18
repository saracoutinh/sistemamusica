import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

import javafx.scene.input.DataFormat;
import loja.*;
import loja.repositorio.*;


@SuppressWarnings("unused")
public class Main {
	
	private static final SimpleDateFormat dateformatter = new SimpleDateFormat("dd/MM/yyyy");
	
	private	static final Locale Locale = new Locale("pt", "BR");
	private static final NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale);
	
	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Sara Coutinho", 55544433321l, "Rua Flores, 121", "(11)998877665", "sara.coutinho@outlook.com");
		Cliente c2 = new Cliente("Willian Henrique", 12345678955l, "Rua Verde, 445", "(11)124578963", "willian.h_reis@hotmail.com");
		
		ClienteRepository clienteRepository = new ClienteRepository();
		
		System.out.println("\n*********Cliente inserido: *****************\n");
		
		clienteRepository.criarCliente(c1);
		clienteRepository.criarCliente(c2);
		
		System.out.println("Id do cliente 1: " + c1.getIdCliente());
		System.out.println("Id do cliente 2: " + c2.getIdCliente());
		
		Servico ss1 = new Servico(500.5,
				"conserto no piano, não funciona primeira tecla dó", 
				"conserto", 
				120, 
				new Date(), c1, null, null); 
		
		ServicoRepository servicoRepository = new ServicoRepository();
		
		servicoRepository.criarServico(ss1);
		
		Instrumento i1 = new Instrumento("Piano", "teclas", "madeira");
		
		
		//Funcionario f1 = new Funcionario("Luciana", "lutheria", "teclas/cordas", "vendas", ss1)
				
		
		
	}


}
