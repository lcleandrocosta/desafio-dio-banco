package dio.banco.desafio;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Main campos = new Main();
		campos.IniciarJanelaPrincipal();
	}

	private void IniciarJanelaPrincipal() {
		Container janela = getContentPane();
		setLayout(null);

		// Define os rótulos na tela
		JLabel janelaPrincipal = new JLabel("Bem vindo ao banco digital DIO-PHILIPS");
		janelaPrincipal.setBounds(190, 5, 500, 30);
		
		JLabel operacoes = new JLabel("Quais operações deseja realizar?");
		operacoes.setBounds(200, 50, 500, 30);
		
		// Botões
		JButton botaoSacar = new JButton("Sacar");
		botaoSacar.setBounds(200, 80, 500, 30);
		botaoSacar.setSize(200, 80);
		botaoSacar.setVisible(true);
		
		JButton botaoDepositar = new JButton("Depositar");
		botaoDepositar.setBounds(200, 200, 500, 30);
		botaoDepositar.setSize(200, 80);
		botaoDepositar.setVisible(true);

		// Define as máscaras
		/*MaskFormatter mascaraCep = null;
		MaskFormatter mascaraTel = null;
		MaskFormatter mascaraCpf = null;
		MaskFormatter mascaraData = null;

		try {
			mascaraCep = new MaskFormatter("#####-###");
			mascaraTel = new MaskFormatter("(##)####-####");
			mascaraCpf = new MaskFormatter("#########-##");
			mascaraData = new MaskFormatter("##/##/####");
			mascaraCep.setPlaceholderCharacter('_');
			mascaraTel.setPlaceholderCharacter('_');
			mascaraCpf.setPlaceholderCharacter('_');
			mascaraData.setPlaceholderCharacter('_');
		} catch (ParseException excp) {
			System.err.println("Erro na formatação: " + excp.getMessage());
			System.exit(-1);
		}

		// Seta as máscaras nos objetos JFormattedTextField
		JFormattedTextField jFormattedTextCep = new JFormattedTextField(mascaraCep);
		JFormattedTextField jFormattedTextTel = new JFormattedTextField(mascaraTel);
		JFormattedTextField jFormattedTextCpf = new JFormattedTextField(mascaraCpf);
		JFormattedTextField jFormattedTextData = new JFormattedTextField(mascaraData);
		jFormattedTextCep.setBounds(150, 40, 100, 20);
		jFormattedTextTel.setBounds(150, 80, 100, 20);
		jFormattedTextCpf.setBounds(150, 120, 100, 20);
		jFormattedTextData.setBounds(150, 160, 100, 20);*/

		// Adiciona os rótulos na tela
		janela.add(janelaPrincipal);
		janela.add(operacoes);
		
		janela.add(botaoSacar);
		janela.add(botaoDepositar);
		
		setSize(600, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}
