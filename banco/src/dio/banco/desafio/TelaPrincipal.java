package dio.banco.desafio;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JEditorPane;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private boolean acessoLiberado = false; // Acesso ao sistema
	
	Cliente cliente;
	Conta conta;

	/**
	 * Inicia a aplicação.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Cria o frame frame.
	 */
	public TelaPrincipal() {
		setTitle("Desafio banco - POO");
		setFont(new Font("Dialog", Font.BOLD, 30));
		setBackground(new Color(240, 240, 240));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 324);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.textHighlight);
		contentPane.setBorder(new LineBorder(new Color(255, 255, 255)));
		setContentPane(contentPane);
		contentPane.setLayout(null);	
	    
	    // Label título
		JLabel lblTitulo = new JLabel("Banco DIO PHILIPS");
		lblTitulo.setBounds(145, 11, 276, 39);
		lblTitulo.setForeground(SystemColor.text);
		lblTitulo.setLabelFor(this);
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 30));
		contentPane.add(lblTitulo);
		
		// Label subtítulo
		JLabel lblsubTitulo = new JLabel("Escolha uma op\u00E7\u00E3o");
		lblsubTitulo.setForeground(Color.WHITE);
		lblsubTitulo.setBackground(Color.WHITE);
		lblsubTitulo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblsubTitulo.setBounds(195, 44, 190, 39);
		contentPane.add(lblsubTitulo);
		
		// Botões
		JButton btnSaque = new JButton("Saque");
		btnSaque.setSize(20, 20);
		btnSaque.setBounds(10, 98, 139, 58);
		btnSaque.setForeground(Color.BLUE);
		btnSaque.setBackground(SystemColor.menu);
		btnSaque.setToolTipText("");
		btnSaque.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(btnSaque);
		
		JButton btnDepositar = new JButton("Depositar");
		btnDepositar.setToolTipText("");
		btnDepositar.setForeground(Color.BLUE);
		btnDepositar.setFont(new Font("Dialog", Font.BOLD, 20));
		btnDepositar.setBackground(SystemColor.menu);
		btnDepositar.setBounds(10, 175, 139, 58);
		contentPane.add(btnDepositar);
		
		JButton btnTransferir = new JButton("Transferir");
		btnTransferir.setToolTipText("");
		btnTransferir.setForeground(Color.BLUE);
		btnTransferir.setFont(new Font("Dialog", Font.BOLD, 20));
		btnTransferir.setBackground(SystemColor.menu);
		btnTransferir.setBounds(425, 98, 139, 58);
		contentPane.add(btnTransferir);
		
		JButton btnExtrato = new JButton("Extrato");
		btnExtrato.setToolTipText("");
		btnExtrato.setForeground(Color.BLUE);
		btnExtrato.setFont(new Font("Dialog", Font.BOLD, 20));
		btnExtrato.setBackground(SystemColor.menu);
		btnExtrato.setBounds(425, 175, 139, 58);
		contentPane.add(btnExtrato);
		
		// Botão entrar no sistema
		JButton btnEntrar = new JButton("ENTRAR");
		btnEntrar.setForeground(Color.BLUE);
		btnEntrar.setFont(new Font("Dialog", Font.BOLD, 30));
		btnEntrar.setBounds(172, 175, 236, 58);
		contentPane.add(btnEntrar);
		
		// Pinel de saída de infromações
		JEditorPane pnlSaida = new JEditorPane();
		pnlSaida.setText("Bem vindo a seu banco digital!");
		pnlSaida.setForeground(Color.BLUE);
		pnlSaida.setFont(new Font("Dialog", Font.BOLD, 15));
		pnlSaida.setBounds(172, 98, 236, 58);
		contentPane.add(pnlSaida);
		
		JLabel lblRodape = new JLabel("Desenvolvido por Leandro Costa@2022");
		lblRodape.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblRodape.setForeground(Color.WHITE);
		lblRodape.setBounds(193, 260, 238, 14);
		contentPane.add(lblRodape);
		
		JLabel lblImg = new JLabel("");
		lblImg.setBounds(454, 11, 106, 72);
		lblImg.setIcon(new ImageIcon("img/logo-philips.png"));
		contentPane.add(lblImg);
		
		/**
		 * Evento dos botões.
		 */
		
		// Evento do botão Entrar
		btnEntrar.addActionListener(new ActionListener() {
			String entrada;
			
			public void actionPerformed(ActionEvent e) {
				cliente = new Cliente();
				entrada = JOptionPane.showInputDialog("Digite seu nome: ");
				cliente.setNome(entrada);
				
				boolean clienteExiste = false;
				
				clienteExiste = cliente.getNome().equals(entrada);
				System.out.println(clienteExiste);
				System.out.println(cliente.getNome());
				
				if(clienteExiste) {
					pnlSaida.setText("Acesso liberado!");
					acessoLiberado = true;
				}else {
					pnlSaida.setText("Sem acesso ao sistema! Faça seu cadastro.");
				}
			}
		});
		
		// Evento do botão Saque
		btnSaque.addActionListener(new ActionListener() {
			String valorEntrada;
			double valorSaque;
			boolean existeSaldo = false;
			
			public void actionPerformed(ActionEvent e) {
				conta = new ContaCorrente(cliente);
				
				if(acessoLiberado) {
					pnlSaida.setText("");
					pnlSaida.setText("Você escolheu saque!");
					valorEntrada = JOptionPane.showInputDialog("Digite o valor do saque:");
					valorSaque = Double.parseDouble(valorEntrada);
					pnlSaida.setText("");
					pnlSaida.setText("Valor a ser sacado R$ " + valorSaque + ",00");
					
					existeSaldo = valorSaque > conta.getSaldo();
					
					if(existeSaldo) {
						pnlSaida.setText("Saldo insuficiente!");
			
					}else {
						pnlSaida.setText("Saque Realizado com sucesso!");
					}
					
				}else {
					JOptionPane.showMessageDialog(null, "Identifique-se");
					pnlSaida.setText("");
					pnlSaida.setText("Clique no botão ENTRAR!");
				}
			}
			
		});
		
		// Evento do botão Extrato
		btnExtrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conta = new ContaCorrente(cliente);
				
				pnlSaida.setText(conta.imprimirExtrato());
				
			}
		});
		
		// Evento do botão Depositar
		btnDepositar.addActionListener(new ActionListener() {
			String valorEntrada;
			double valorDeposito;
			boolean valorValido = false;
			
			public void actionPerformed(ActionEvent e) {
				
				valorEntrada = JOptionPane.showInputDialog("Digite valor: ");
				valorDeposito = Double.parseDouble(valorEntrada);
				valorValido = valorDeposito <= 0;
				
				if(!valorValido) {
					conta.depositar(valorDeposito);
					pnlSaida.setText("Déposito realizado com sucesso!");
				}else {
					pnlSaida.setText("Valor Inválido! Entre com um valor válido!");
				}
				
			}
		});
		
		// Evento do botão transferir
		btnTransferir.addActionListener(new ActionListener() {
			String valorEntrada;
			String contaEntrada;
			double valorTransferencia;
			boolean valorValido;
			
			public void actionPerformed(ActionEvent e) {
				Conta contaTransferir;
				Cliente novoCliente;
				
				valorEntrada = JOptionPane.showInputDialog("Entre com o valor do déposito: ");
				contaEntrada = JOptionPane.showInputDialog("Entre com a conta destino: ");
				valorTransferencia = Double.parseDouble(valorEntrada);
				valorValido = valorTransferencia > 0;
				
				if(!valorValido) {
					pnlSaida.setText("Valor INVÁLIDO!!");
				}else {
					cliente = new Cliente();
					conta = new ContaCorrente(cliente);
					novoCliente = new Cliente();
					novoCliente.setNome(contaEntrada);
					contaTransferir = new ContaCorrente(novoCliente);
					conta.transferir(valorTransferencia, contaTransferir);
					pnlSaida.setText("Transferência realizada com sucesso!");
				}
			}
		});
	}
}
