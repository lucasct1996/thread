package cursojavathread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaTimeThread extends JDialog{
	
	private JPanel jPanel = new JPanel(new GridBagLayout()); /* Painel de componentes*/
	
	private JLabel descricaoHora = new JLabel("Time thread 1"); /* Descricao do Label */
	private JTextField mostraTempo = new JTextField();
	
	private JLabel descricaoHora2 = new JLabel("Time thread 2"); /* Descricao do Label */
	private JTextField mostraTempo2 = new JTextField();
	
	public TelaTimeThread() { /* Executa o que tiver dentro no momento da abertura ou execucao*/
	setTitle("Minha tela com a Thread"); /* titulo da tela */
	setSize(new Dimension(240, 240));  /* dimensao */
	setLocationRelativeTo(null);	/* localizacao da tela (centro */
	setResizable(false); /* nao da dimninuir nem aumentar a tela */
	/* primeira parte concluida */
	

	/* controlador de posicionamento */
	GridBagConstraints gridBagConstraints = new GridBagConstraints();  /* Controlador de posicionamento de componentes */
	gridBagConstraints.gridx = 0; /* pro lado horizontal */
	gridBagConstraints.gridy = 0; /* pra cima vertical */
	
	descricaoHora.setPreferredSize(new Dimension(200, 25)); /* adicionar o painel dentro do gridx e gridy */
	jPanel.add(descricaoHora, gridBagConstraints);
	
	mostraTempo.setPreferredSize(new Dimension(200, 25)); /* cria um componente com sua localizacao */
	gridBagConstraints.gridy ++;  /* adiciona 1 casa do painel de layout andando 1 casa no Y */
	jPanel.add(mostraTempo, gridBagConstraints); /* adicionou o componente */
	
	descricaoHora2.setPreferredSize(new Dimension(200, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(descricaoHora2, gridBagConstraints);
	
	mostraTempo2.setPreferredSize(new Dimension(200,25));
	gridBagConstraints.gridy ++;
	jPanel.add(mostraTempo2, gridBagConstraints);
	
	
	add(jPanel, BorderLayout.WEST); /* adiconou o layoub no painel (West <esquerda) */
	/* sempre ultima linha */	
		setVisible(true); /* Tona a tela visivel para o usuario*/
	}
	
	
	/**/
}
