import java.util.Calendar;
import java.util.TimerTask;
import java.util.Timer;
/**
 * @author Byron T
 * 
 */
public class Cuenta {
	int saldo = 0;
	private Cliente cliente;
        private Double interes;
	private Double comision = 0.6; 
	private Calendar calendario = Calendar.getInstance();
	private TipoCuenta tipoCuenta;
	private int dia; 
	private int mes; 
	private int anio; 
	
								
	private int intervaloCheckeo = 10000;
	private Double balance;
	private boolean bloqueado = false;
	private int puntos;

	enum TipoCuenta {
		CC, CV, FI;
	} 
	
	public Cuenta(String accountType, Cliente cliente){
		try {
			this.tipoCuenta = TipoCuenta.valueOf(accountType);
			this.setCliente(cliente);
			dia = calendario.get(5);
			mes = calendario.get(2);
			anio = calendario.get(1);
			balance = 0.00;
			Tarea task = new Tarea();
			Timer timer = new Timer();
			
			timer.scheduleAtFixedRate(task, 0, intervaloCheckeo); 

			if (this.tipoCuenta == TipoCuenta.CC)
				interes = 0.01;
			else if (this.tipoCuenta == TipoCuenta.CV)
				interes = 0.02;
			else
				interes = 0.034;
		} catch (IllegalArgumentException error) {
                    
			
                        System.out.println("Error en el tipo de cuenta");
		}
	}

	

	public TipoCuenta getTipoCuenta() {
		return tipoCuenta;
	}

	
	public void setTipoCuenta(String accountType) { 
		try {
			this.tipoCuenta = TipoCuenta.valueOf(accountType);
		} catch (IllegalArgumentException error) {
		
                        System.out.println("Error en el tipo de cuenta");
		}
	}


	public Cuenta deposito(Double cantidad) {
		this.balance += cantidad;
		if (this.balance > -500.00)
			this.bloqueado = false;
		this.puntos++;
		return this;
	}

//Permite retirar el dinero
	public void procesar(Double cantidad){
		if (!this.bloqueado) {
			if (this.tipoCuenta == TipoCuenta.CC) {
				if (this.balance >= cantidad)
					this.balance -= cantidad;
				else
					
                                    System.out.println("Balance insuficiente");
			} else if (this.tipoCuenta == TipoCuenta.FI) {
				if (this.balance <= -500.00) {
					this.bloqueado = true;
					
                                        System.out.println("Cuenta bloqueada");
				} else if(this.balance - cantidad >= -500.00)
					this.balance -= cantidad;
			} else
				
                            System.out.println("Operacion Prohibida");

		} else
			
                    System.out.println("Cuenta bloqueada");
	}


	public Double checkBalance() {
		return this.balance;
	}

	
	public void RevisionMensual() {
		if (!this.bloqueado && this.balance > 0.00) {
			if (this.tipoCuenta == TipoCuenta.FI)
				this.balance = this.balance + this.balance * this.interes - this.comision;
			else if (this.tipoCuenta == TipoCuenta.CC) { 
				boolean checkPositive = this.balance + this.balance * this.interes - this.comision > 0.00;
				if (checkPositive)
					this.balance = this.balance + this.balance * this.interes - this.comision;
			} else
				this.balance = this.balance + this.balance * this.interes;
		}
	}

	public int getPuntos() {
		return this.puntos;
	}

	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}

	
	public Cliente getCliente() {
		return cliente;
	}

	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	
	class Tarea extends TimerTask {

		@Override
		public void run() {
			Calendar calendario = Calendar.getInstance();
			if (mes != calendario.get(Calendar.MONTH)
					|| anio != calendario.get(Calendar.YEAR)) {
				if (calendario.get(Calendar.DAY_OF_MONTH) == 1)
					RevisionMensual();
			}
			
			 System.out.println("(Mes "+saldo+")Antes de la revisión mínima: "
			                      +Cuenta.this.cliente.getName()+": "+checkBalance());
			 RevisionMensual();
			 System.out.println("Después de la revisión mínima: "+Cuenta.this.cliente.getName()+": "+checkBalance());
			 System.out.println("Retirar 101 $");
			 try {
				Cuenta.this.procesar(101.00);				
			} catch (Exception e) {				
				e.printStackTrace();
			}
			 System.out.println("Depositar 5 $");
			 Cuenta.this.deposito(5.00);
			
			 saldo++;
		}

	}
}
