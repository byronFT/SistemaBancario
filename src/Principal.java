
/**
 * @author ByronT
 * 
 */
public class Principal {
	Banco banco;
	Cliente cliente1;
	Cliente cliente2;
	Cliente cliente3;
	Cuenta cuenta1;
	Cuenta cuenta2;
	Cuenta cuenta3;

	public Principal(){
		try {
		banco = new Banco("BDJC");
		cliente1 = new Cliente("0105964824", "Cristian", "Dutan", "Av. Americas, 4", 9865874);
		banco.addClient(cliente1);		
		banco.addAccount(new Cuenta("CC", cliente1).deposito(100.00));
		cliente2 = new Cliente("010257894", "Johnny", "Espinoza", "C/ Heroes d eVerdeloma", 8963547);
		banco.addClient(cliente2);
		banco.addAccount(new Cuenta("CV", cliente2).deposito(100.00));
		cliente3 = new Cliente("010487963", "Dario", "Molina", "C/Remigio Crespo", 96895684);		
		banco.addClient(cliente3);
		banco.addAccount(new Cuenta("FI", cliente3).deposito(100.00));			
		} catch (IllegalArgumentException error) {
			
                        System.out.println("Error en el tipo de cuenta");
		}
	}

	
	public static void main(String[] args) { 
		new Principal();
	}
	
}
