package dio.banco.desafio;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	public String imprimirExtrato() {
		System.out.println("******* Extrato Conta Corrente *******");
		super.imprimirInfoComuns();
		return "";
	}
}
