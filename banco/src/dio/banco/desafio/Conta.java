package dio.banco.desafio;

public abstract class Conta implements IConta {

	// Variáveis constantes
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	
	// Atributos globais
	protected int agencia;
	protected int numeroConta;
	protected double saldo;
	protected Cliente cliente;
	
	// Método construtor
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numeroConta = SEQUENCIAL++;
		this.cliente = cliente;
		this.saldo = 0;
	}
	
	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	
	@Override
	public void transferir(double valor, IConta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumeroConta() {
		return numeroConta;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	protected String imprimirInfoComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero da Conta: %d", this.numeroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
		return "";
	}
}
