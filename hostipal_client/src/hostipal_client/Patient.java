package hostipal_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

import java.sql.*;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

public class Patient extends JFrame {
	private Font laFont = new Font("����", Font.BOLD, 25);
	private Font btFont = new Font("����", Font.BOLD, 25);

	JButton addJButton = new JButton("���");
	JButton deleteJButton = new JButton("ɾ��");
	JButton updateJButton = new JButton("�޸�");
	JButton selectJButton = new JButton("��ѯ");
	JButton returnJButton = new JButton("����");

	JLabel pidJLabel = new JLabel("���˱��");
	JLabel pnaJLabel = new JLabel("����");
	JLabel psexJLabel = new JLabel("�Ա�");
	JLabel pageJLabel = new JLabel("����");
	JLabel proJLabel = new JLabel("������");
	JLabel pnadoJLabel = new JLabel("ҽ������");
	JLabel pbloJLabel = new JLabel("Ѫ��");
	JLabel pdiaJLabel = new JLabel("ȷ����");
	JLabel pidoJLabel = new JLabel("���Һ�");

	JTextField pidJTextField = new JTextField();
	JTextField pnaJTextField = new JTextField();
	JTextField psexJTextField = new JTextField();
	JTextField pageJTextField = new JTextField();
	JTextField proJTextField = new JTextField();
	JTextField pnadoJTextField = new JTextField();
	JTextField pbloJTextField = new JTextField();
	JTextField pdiaJTextField = new JTextField();
	JTextField pidoJTextField = new JTextField();

	public Patient() {
	}

	public Patient(String b) throws Exception {
		super(b);
		this.setLayout(null);

		UDPClient client = new UDPClient("127.0.0.1", 5253, 5150);

		this.setSize(1000, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(pidJLabel);
		this.add(pidJTextField);
		pidJLabel.setBounds(100, 50, 120, 50);
		pidJLabel.setFont(laFont);
		pidJTextField.setBounds(220, 50, 200, 50);

		this.add(pnaJLabel);
		pnaJLabel.setBounds(100, 100, 120, 50);
		pnaJLabel.setFont(laFont);
		this.add(pnaJTextField);
		pnaJTextField.setBounds(220, 100, 200, 50);

		this.add(psexJLabel);
		psexJLabel.setBounds(550, 150, 120, 50);
		psexJLabel.setFont(laFont);
		this.add(psexJTextField);
		psexJTextField.setBounds(670, 150, 200, 50);

		this.add(pageJLabel);
		pageJLabel.setBounds(100, 150, 120, 50);
		pageJLabel.setFont(laFont);
		this.add(pageJTextField);
		pageJTextField.setBounds(220, 150, 200, 50);

		this.add(proJLabel);
		proJLabel.setBounds(550, 250, 200, 50);
		proJLabel.setFont(laFont);
		this.add(proJTextField);
		proJTextField.setBounds(670, 250, 200, 50);

		this.add(pnadoJLabel);
		pnadoJLabel.setBounds(550, 200, 120, 50);
		pnadoJLabel.setFont(laFont);
		this.add(pnadoJTextField);
		pnadoJTextField.setBounds(670, 200, 200, 50);

		this.add(pbloJLabel);
		pbloJLabel.setBounds(100, 200, 120, 50);
		pbloJLabel.setFont(laFont);
		this.add(pbloJTextField);
		pbloJTextField.setBounds(220, 200, 200, 50);

		this.add(pdiaJLabel);
		pdiaJLabel.setBounds(100, 250, 120, 50);
		pdiaJLabel.setFont(laFont);
		this.add(pdiaJTextField);
		pdiaJTextField.setBounds(220, 250, 200, 50);

		this.add(pidoJLabel);
		pidoJLabel.setBounds(100, 300, 200, 50);
		pidoJLabel.setFont(laFont);
		this.add(pidoJTextField);
		pidoJTextField.setBounds(220, 300, 200, 50);

		this.add(selectJButton);
		selectJButton.setBounds(600, 50, 120, 50);
		selectJButton.setFont(btFont);

		this.add(addJButton);
		addJButton.setBounds(200, 400, 120, 50);
		addJButton.setFont(btFont);

		this.add(deleteJButton);
		deleteJButton.setBounds(400, 400, 120, 50);
		deleteJButton.setFont(btFont);

		this.add(updateJButton);
		updateJButton.setBounds(600, 400, 120, 50);
		updateJButton.setFont(btFont);

		this.add(returnJButton);
		returnJButton.setBounds(800, 400, 120, 50);
		returnJButton.setFont(btFont);

		// ��ѯ

		selectJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String pidjString = pidJTextField.getText().toString();
					client.Send("b2" + "," + pidjString + ",");
					String msg = client.Recive();
					StringTokenizer st = new StringTokenizer(msg, ",");
					pidJTextField.setText(st.nextToken());
					pnaJTextField.setText(st.nextToken());
					psexJTextField.setText(st.nextToken());
					pageJTextField.setText(st.nextToken());
					proJTextField.setText(st.nextToken());
					pnadoJTextField.setText(st.nextToken());
					pbloJTextField.setText(st.nextToken());
					pdiaJTextField.setText(st.nextToken());
					pidoJTextField.setText(st.nextToken());
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		// ɾ��
		deleteJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String denoJText = pidJTextField.getText().toString();
					client.Send("c2" + "," + denoJText + ",");
					String msg = client.Recive();
					if (msg.contains("ok")) {
						JOptionPane.showMessageDialog(null, "ɾ���ɹ���");
					}
				}

				catch (Exception e2) {
					System.out.println(e2);
				}

			}
		});
		// ����
		updateJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					String pidText = pidJTextField.getText().toString();
					String pnaText = pnaJTextField.getText().toString();
					String psexText = psexJTextField.getText().toString();
					String pageText = pageJTextField.getText().toString();
					String proText = proJTextField.getText().toString();
					String pnadoText = pnadoJTextField.getText().toString();
					String pbloText = pbloJTextField.getText().toString();
					String pdiaText = pdiaJTextField.getText().toString();
					String pidoText = pidoJTextField.getText().toString();
					String smsg = pnaText + "," + psexText + "," + pageText + "," + proText + "," + pnadoText + ","
							+ pbloText + "," + pdiaText + "," + pidoText + "," + pidText;
					client.Send("d2" + "," + smsg + ",");

					String msg = client.Recive();

					if (msg.contains("ok")) {

						JOptionPane.showMessageDialog(null, "���³ɹ���");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		// ����
		addJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					String pidText = pidJTextField.getText().toString();
					String pnaText = pnaJTextField.getText().toString();
					String psexText = psexJTextField.getText().toString();
					String pageText = pageJTextField.getText().toString();
					String proText = proJTextField.getText().toString();
					String pnadoText = pnadoJTextField.getText().toString();
					String pbloText = pbloJTextField.getText().toString();
					String pdiaText = pdiaJTextField.getText().toString();
					String pidoText = pidoJTextField.getText().toString();
					String smsg = pidText + "," + pnaText + "," + psexText + "," + pageText + "," + proText + ","
							+ pnadoText + "," + pbloText + "," + pdiaText + "," + pidoText;

					client.Send("e2" + "," + smsg + ",");

					String msg = client.Recive();

					if (msg.contains("ok")) {
						JOptionPane.showMessageDialog(null, "����ɹ���");
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});

		returnJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Homepage homePage = new Homepage("��ҳ��");
					Patient.this.setVisible(false);
					client.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
	}

}
