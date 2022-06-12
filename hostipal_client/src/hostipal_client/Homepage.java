
package hostipal_client;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Homepage extends JFrame {

	private JLabel la1, la2;

	private Font laFont = new Font("����", Font.BOLD, 60);
	private Font btFont = new Font("����", Font.BOLD, 25);

	ImageIcon background = new ImageIcon("one.jpg");
	JLabel bgJLabel = new JLabel(background);

	JButton doctorJButton = new JButton("ҽ����Ϣ����");
	JButton patientJButton = new JButton("������Ϣ����");
	JButton wardJButton = new JButton("������Ϣ����");

	public Homepage() {
	}

	public Homepage(String a) {
		super(a);
		this.setLayout(null);

		this.add(doctorJButton);
		this.add(patientJButton);
		this.add(wardJButton);
		doctorJButton.setFont(btFont);
		patientJButton.setFont(btFont);
		wardJButton.setFont(btFont);

		doctorJButton.setBounds(0, 0, 200, 190);
		patientJButton.setBounds(0, 190, 200, 190);
		wardJButton.setBounds(0, 380, 200, 190);

		la1 = new JLabel("��ӭʹ��");
		la2 = new JLabel("ҽԺ��Ϣ����ϵͳ");

		this.add(la1);
		this.add(la2);
		la1.setBounds(500, 100, 500, 100);
		la1.setFont(laFont);
		la2.setBounds(400, 200, 600, 100);
		la2.setFont(laFont);

		this.add(bgJLabel);
		bgJLabel.setBounds(0, 0, 1000, 600);

		wardJButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				try {
					new Office("���ҹ������");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				Homepage.this.setVisible(false);

			}
		});

		doctorJButton.addActionListener(new ActionListener() {
			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				try {
					new Doctor("ҽ���������");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Homepage.this.setVisible(false);

			}

		});

		patientJButton.addActionListener(new ActionListener() {

			@Override

			public void actionPerformed(ActionEvent e) {

				// TODO Auto-generated method stub

				try {
					new Patient("���˹������");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				Homepage.this.setVisible(false);

			}

		});

		this.setTitle("��ҳ��");
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(1000, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

	public static void main(String[] args) {
		Homepage homePage = new Homepage("��ҳ��");

	}

}