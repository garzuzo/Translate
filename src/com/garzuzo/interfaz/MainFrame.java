package com.garzuzo.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.garzuzo.mundo.Trans;

public class MainFrame extends JFrame implements ActionListener {

	private TextArea taSource;
	private TextArea taDestin;

	private boolean englishToSpanish;
	private JRadioButton rbEToS;
	private JRadioButton rbSToE;
	private JButton bTraslate;

	private Trans trans;

	public MainFrame() {
		trans = new Trans();
		englishToSpanish = true;
		rbEToS = new JRadioButton("English To Spanish");
		rbSToE = new JRadioButton("Spanish To English");
		bTraslate = new JButton("Translate");
		bTraslate.addActionListener(this);
		bTraslate.setActionCommand("translate");
		
		setLayout(new BorderLayout());
		taSource = new TextArea();
		taDestin = new TextArea();
		JPanel pAux1 = new JPanel();
		pAux1.setLayout(new FlowLayout());
		pAux1.add(taSource);
		pAux1.add(taDestin);

		JPanel pAux = new JPanel();
		pAux.setLayout(new FlowLayout());

		ButtonGroup bg = new ButtonGroup();

		bg.add(rbEToS);
		bg.add(rbSToE);

		pAux.add(rbEToS);
		pAux.add(rbSToE);
		pAux.add(bTraslate);
		add(pAux1, BorderLayout.NORTH);
		add(pAux, BorderLayout.CENTER);
		this.pack();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String comand = ae.getActionCommand();

		if (comand.equals("translate")) {
			if (rbEToS.isSelected()) {
				englishToSpanish = true;

			} else {
				englishToSpanish = false;

			}
			String ret = trans.translate(englishToSpanish, taSource.getText());
			System.out.println(ret);
			taDestin.setText(ret);

		}

	}

}
