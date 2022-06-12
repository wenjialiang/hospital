package hostipal_client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;

import java.sql.*;
import java.util.StringTokenizer;

import javax.swing.*;
import javax.swing.plaf.OptionPaneUI;

public class Office extends JFrame {
	private Font laFont = new Font("����", Font.BOLD, 25);
	private Font btFont = new Font("����", Font.BOLD, 25);

	JButton addJButton = new JButton("���");
	JButton deleteJButton = new JButton("ɾ��");
	JButton updateJButton = new JButton("����");
	JButton selectJButton = new JButton("��ѯ");
	JButton returnJButton = new JButton("����");

	JLabel denoJLabel = new JLabel("���ұ��");
	JLabel denameJLabel = new JLabel("��������");
	JLabel deaddrJLabel = new JLabel("���ҵ�ַ");
	JLabel dephoneJLabel = new JLabel("���ҵ绰");
	JLabel demasterJLabel = new JLabel("��������");

	JTextField denoJTextField = new JTextField();
	JTextField denameJTextField = new JTextField();
	JTextField deaddrJTextField = new JTextField();
	JTextField dephoneJTextField = new JTextField();
	JTextField demasterJTextField = new JTextField();

	public Office() {
	}

	public Office(String b) throws Exception {
		super(b);
		this.setLayout(null);

		/*
		 * DBUtil dbUtil = new DBUtil(); dbUtil.getUsername(); dbUtil.getPassword();
		 * Connection con = dbUtil.getConnection();
		 */
		UDPClient client = new UDPClient("127.0.0.1", 5253, 5150);
		// client.Send("a");

		this.setSize(1000, 600);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.add(denoJLabel);
		this.add(denoJTextField);
		denoJLabel.setBounds(100, 50, 120, 50);
		denoJLabel.setFont(laFont);
		denoJTextField.setBounds(220, 50, 200, 50);

		this.add(denameJLabel);
		denameJLabel.setBounds(100, 150, 120, 50);
		denameJLabel.setFont(laFont);
		this.add(denameJTextField);
		denameJTextField.setBounds(220, 150, 200, 50);

		this.add(deaddrJLabel);
		deaddrJLabel.setBounds(550, 150, 120, 50);
		deaddrJLabel.setFont(laFont);
		this.add(deaddrJTextField);
		deaddrJTextField.setBounds(670, 150, 200, 50);

		this.add(dephoneJLabel);
		dephoneJLabel.setBounds(100, 250, 120, 50);
		dephoneJLabel.setFont(laFont);
		this.add(dephoneJTextField);
		dephoneJTextField.setBounds(220, 250, 200, 50);

		this.add(demasterJLabel);
		demasterJLabel.setBounds(550, 250, 200, 50);
		demasterJLabel.setFont(laFont);
		this.add(demasterJTextField);
		demasterJTextField.setBounds(670, 250, 200, 50);

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
					String denojString = denoJTextField.getText().toString();
					client.Send("b1" + "," + denojString + ",");
					String msg = client.Recive();
					StringTokenizer st = new StringTokenizer(msg, ",");
					denoJTextField.setText(st.nextToken());
					denameJTextField.setText(st.nextToken());
					deaddrJTextField.setText(st.nextToken());
					dephoneJTextField.setText(st.nextToken());
					demasterJTextField.setText(st.nextToken());
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
					String denoJText = denoJTextField.getText().toString();
					client.Send("c1" + "," + denoJText + ",");
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

					String denoText = denoJTextField.getText().toString();
					String deNameText = denameJTextField.getText().toString();
					String deAddrText = deaddrJTextField.getText().toString();
					String dePhoneText = dephoneJTextField.getText().toString();
					String deMasterText = demasterJTextField.getText().toString();
					String smsg = deNameText + "," + deAddrText + "," + dePhoneText + "," + deMasterText + ","
							+ denoText + ",";
					client.Send("d1" + "," + smsg);
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

					String denoText = denoJTextField.getText().toString();
					String deNameText = denameJTextField.getText().toString();
					String deAdderText = deaddrJTextField.getText().toString();
					String dePhoneText = dephoneJTextField.getText().toString();
					String deMasterText = demasterJTextField.getText().toString();
					String smgs = denoText + "," + deNameText + "," + deAdderText + "," + dePhoneText + ","
							+ deMasterText;
					client.Send("e1" + "," + smgs + ",");

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
					Office.this.setVisible(false);
					client.close();
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});

	}

}
