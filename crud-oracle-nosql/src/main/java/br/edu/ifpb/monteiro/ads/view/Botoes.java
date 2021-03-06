package br.edu.ifpb.monteiro.ads.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Botoes {
	
	public JPanel adicionarButtonsSouth(ActionListener ouvinteAdd, ActionListener ouvinteExcluir, ActionListener ouvinteBuscar, ActionListener ouvinteEditar) {
		JButton adicionar = new JButton("Adicionar Aluno");
		adicionar.setIcon(new ImageIcon(getClass().getResource("/images/add.png")));
		adicionar.addActionListener(ouvinteAdd);
		
		JButton excluir = new JButton("Remover Aluno");
		excluir.setIcon(new ImageIcon(getClass().getResource("/images/excluir.png")));
		excluir.addActionListener(ouvinteExcluir);
		
		JButton buscar = new JButton("Buscar Aluno");
		buscar.setIcon(new ImageIcon(getClass().getResource("/images/buscar.png")));
		buscar.addActionListener(ouvinteBuscar);
		
		JButton editar = new JButton("Editar Aluno");
		editar.setIcon(new ImageIcon(getClass().getResource("/images/edit.png")));
		editar.addActionListener(ouvinteEditar);
		
		GridLayout botoes = new GridLayout(1, 4);
		JPanel painelBotoes = new JPanel(botoes);
		painelBotoes.add(adicionar);
		painelBotoes.add(excluir);
		painelBotoes.add(buscar);
		painelBotoes.add(editar);
		return painelBotoes;
	}
}