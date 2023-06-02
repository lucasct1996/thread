package cursojavathread;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
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
	
	private JButton jButton = new JButton("Start");
	private JButton jButton2 = new JButton("Stop");
	
	private Runnable thread1 = new Runnable() {
		
		@Override
		public void run() {
			while (true) { /* fica sempre rodando */
				mostraTempo.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));  /* funcao que puxa a hora no objeto */
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  /* pausa de 1s */
			}
			
		}
	};
	
	
private Runnable thread2 = new Runnable() {
		
		@Override
		public void run() {
			while (true) { /* fica sempre rodando */
				mostraTempo2.setText(new SimpleDateFormat("dd/MM/yyyy hh:mm.ss").
						format(Calendar.getInstance().getTime()));  /* funcao que puxa a hora no objeto */
				
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}  /* pausa de 1s */
			}
			
		}
	};
	
	private Thread  thread1Time;
	private Thread thread2Time;
	
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
	gridBagConstraints.gridwidth = 2; /* iniciar a largura com 2 */
	gridBagConstraints.insets = new Insets(5, 10, 5, 5); /* espaçamento */
	gridBagConstraints.anchor = GridBagConstraints.WEST; /* Posicionamento */
	
	descricaoHora.setPreferredSize(new Dimension(200, 25)); /* adicionar o painel dentro do gridx e gridy */
	jPanel.add(descricaoHora, gridBagConstraints);
	
	mostraTempo.setPreferredSize(new Dimension(200, 25)); /* cria um componente com sua localizacao */
	gridBagConstraints.gridy ++;  /* adiciona 1 casa do painel de layout andando 1 casa no Y */
	mostraTempo.setEditable(false); /* desativa a casa escrever */
	jPanel.add(mostraTempo, gridBagConstraints); /* adicionou o componente */
	
	descricaoHora2.setPreferredSize(new Dimension(200, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(descricaoHora2, gridBagConstraints);
	
	mostraTempo2.setPreferredSize(new Dimension(200,25));
	gridBagConstraints.gridy ++;
	mostraTempo2.setEditable(false); /* desativa a casa escrever */
	jPanel.add(mostraTempo2, gridBagConstraints);
	
	gridBagConstraints.gridwidth = 1; /* posiconamento de largura 1 */
	
	jButton.setPreferredSize(new Dimension(92, 25));
	gridBagConstraints.gridy ++;
	jPanel.add(jButton, gridBagConstraints);
	
	jButton2.setPreferredSize(new Dimension(92, 25));
	gridBagConstraints.gridx ++;
	jPanel.add(jButton2, gridBagConstraints);
	
	
	jButton.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {  /* executa o clique no botao */
			// TODO Auto-generated method stub
			thread1Time = new Thread(thread1);
			thread1Time.start();
			
			thread2Time = new Thread(thread2);
			thread2Time.start();
			
			jButton.setEnabled(false);
			jButton2.setEnabled(true);
		}
	});
	
	jButton2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			thread1Time.stop();
			thread2Time.stop();
			jButton.setEnabled(true);
			jButton2.setEnabled(false);
			
		}
	});
	
	jButton2.setEnabled(false);
	
	add(jPanel, BorderLayout.WEST); /* adiconou o layoub no painel (West <esquerda) */
	/* sempre ultima linha */	
		setVisible(true); /* Tona a tela visivel para o usuario*/
	}
	
	
	/**/
}
