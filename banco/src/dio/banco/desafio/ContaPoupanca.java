package dio.banco.desafio;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	public String imprimirExtrato() {
		System.out.println("\"******* Extrato Conta Poupan�a  *******");
		super.imprimirInfoComuns();
		return "";
	}
}
