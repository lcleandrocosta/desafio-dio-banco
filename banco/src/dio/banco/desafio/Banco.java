package dio.banco.desafio;

import java.util.ArrayList;

public class Banco {

	private String nome;
	private ArrayList<String> clientes;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public  void setCliente() {
		clientes.add(getNome());

	}
	
	public ArrayList<String> getCliente() {
		return clientes;
	}	
}
