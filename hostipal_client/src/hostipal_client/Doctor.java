package hostipal_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

import java.sql.*;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

public class Doctor extends JFrame {
	private Font laFont = new Font("����", Font.BOLD, 25);
	private Font btFont = new Font("����", Font.BOLD, 25);

	JButton addJButton = new JButton("���");
	JButton deleteJButton = new JButton("ɾ��");
	JButton updateJButton = new JButton("�޸�");
	JButton selectJButton = new JButton("��ѯ");
	JButton returnJButton = new JButton("����");

	JLabel dnoJLabel = new JLabel("ҽ�����");
	JLabel dnameJLabel = new JLabel("ҽ������");
	JLabel dsexJLabel = new JLabel("ҽ���Ա�");
	JLabel dageJLabel = new JLabel("ҽ������");
	JLabel dtitleJLabel = new JLabel("ҽ��ְ��");
	JLabel denoJLabel = new JLabel("���Һ�");

	JTextField dnoJTextField = new JTextField();
	JTextField denameJTextField = new JTextField();
	JTextField dsexJTextField = new JTextField();
	JTextField dageJTextField = new JTextField();
	JTextField dtitleJTextField = new JTextField();
	JTextField denoJTextField = new JTextField();

	public Doctor() {
	}

	public Doctor(String b) throws Exception {
		super(b);
		this.setLayout(null);

		UDPClient client = new UDPClient("127.0.0.1", 5253, 5150);

		this.setSize(1000, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(dnoJLabel);
		this.add(dnoJTextField);
		dnoJLabel.setBounds(100, 50, 120, 50);
		dnoJLabel.setFont(laFont);
		dnoJTextField.setBounds(220, 50, 200, 50);

		this.add(dnameJLabel);
		dnameJLabel.setBounds(100, 150, 120, 50);
		dnameJLabel.setFont(laFont);
		this.add(denameJTextField);
		denameJTextField.setBounds(220, 150, 200, 50);

		this.add(dsexJLabel);
		dsexJLabel.setBounds(550, 150, 120, 50);
		dsexJLabel.setFont(laFont);
		this.add(dsexJTextField);
		dsexJTextField.setBounds(670, 150, 200, 50);

		this.add(dageJLabel);
		dageJLabel.setBounds(100, 250, 120, 50);
		dageJLabel.setFont(laFont);
		this.add(dageJTextField);
		dageJTextField.setBounds(220, 250, 200, 50);

		this.add(dtitleJLabel);
		dtitleJLabel.setBounds(550, 250, 200, 50);
		dtitleJLabel.setFont(laFont);
		this.add(dtitleJTextField);
		dtitleJTextField.setBounds(670, 250, 200, 50);

		this.add(denoJLabel);
		this.add(denoJTextField);
		denoJLabel.setBounds(100, 350, 120, 50);
		denoJLabel.setFont(laFont);
		denoJTextField.setBounds(220, 350, 400, 50);

		this.add(selectJButton);
		selectJButton.setBounds(600, 50, 120, 50);
		selectJButton.setFont(btFont);

		this.add(addJButton);
		addJButton.setBounds(200, 420, 120, 50);
		addJButton.setFont(btFont);

		this.add(deleteJButton);
		deleteJButton.setBounds(400, 420, 120, 50);
		deleteJButton.setFont(btFont);

		this.add(returnJButton);
		returnJButton.setBounds(800, 420, 120, 50);
		returnJButton.setFont(btFont);

		this.add(updateJButton);
		updateJButton.setBounds(600, 420, 120, 50);
		updateJButton.setFont(btFont);

		selectJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String dnojString = dnoJTextField.getText();

					client.Send("b" + "," + dnojString + ",");
					String msg = client.Recive();
					if (msg.equals("null")) {
						JOptionPane.showMessageDialog(null, "��ѯʧ�ܣ�");
					} else {
						StringTokenizer st = new StringTokenizer(msg, ",");
						dnoJTextField.setText(st.nextToken());
						denameJTextField.setText(st.nextToken());
						dsexJTextField.setText(st.nextToken());
						dageJTextField.setText(st.nextToken());
						dtitleJTextField.setText(st.nextToken());
						denoJTextField.setText(st.nextToken());
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});

		deleteJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					String dnojString = dnoJTextField.getText().toString();
					client.Send("c" + "," + dnojString + ",");
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

		updateJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					String dnoText = dnoJTextField.getText().toString();
					String deNameText = denameJTextField.getText().toString();
					String dsexText = dsexJTextField.getText().toString();
					String dageText = dageJTextField.getText().toString();
					String dtitleText = dtitleJTextField.getText().toString();
					String denoText = denoJTextField.getText().toString();
					String smsg = deNameText + "," + dsexText + "," + dageText + "," + dtitleText + "," + denoText + ","
							+ dnoText;
					client.Send("d" + "," + smsg + ",");

					String msg = client.Recive();
					if (msg.contains("ok")) {
						JOptionPane.showMessageDialog(null, "���³ɹ���");
					}

				} catch (Exception e2) {
					// TODO: handle exception
				}

			}
		});
		addJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {

					String dnoText = dnoJTextField.getText().toString();
					String deNameText = denameJTextField.getText().toString();
					String dsexText = dsexJTextField.getText().toString();
					String dageText = dageJTextField.getText().toString();
					String dtitleText = dtitleJTextField.getText().toString();
					String denoText = denoJTextField.getText().toString();

					String smsg = dnoText + "," + deNameText + "," + dsexText + "," + dageText + "," + dtitleText + ","
							+ denoText + ",";

					client.Send("e" + "," + smsg);

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
					Doctor.this.setVisible(false);
					client.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});

	}
}
