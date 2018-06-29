import java.util.ArrayList;

/**
 * @author Byron T
 * 
 */
public class Banco
{
	private String name;
	private ArrayList<Cuenta> accountList;
	private ArrayList<Cliente> clientList;

	/**
	 * 
	 * @param name
	 */

	public Banco(String name){
		this.name=name;
		accountList=new ArrayList<Cuenta>();
		clientList=new ArrayList<Cliente>();
	}
	
	
	public void addClient(Cliente client){
		clientList.add(client);
	}

	
	public void addAccount(Cuenta account){
		accountList.add(account);
	}
	
	
	public void setAccountList(ArrayList<Cuenta> accountList) {
		this.accountList = accountList;
	}

	
	public ArrayList<Cuenta> getAccountList(){
		return accountList;
	}
	
	
	public void setClientList(ArrayList<Cliente> clientList) {
		this.clientList = clientList;
	}

	

	public ArrayList<Cliente> getClientList(){
		return clientList;
	}
	
	public void setName(String bankName) {
		this.name = bankName;
	}


	public String getName(){
		return name;
	}	
}
