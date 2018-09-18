package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.EventObject;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


import work.Run;


/**
 * ������� ���� ���������
 * @version 1.0 05/05/2018
 * @author ��. �����
 *
 */
public class MainFrame extends JFrame {
	
	/**
	 * ����� ��������� ������� ����� ���������.
	 */
	public MainFrame() {
		// ������������� ���������, ����� �� ��������, ������ � �������� �������������� 
        setTitle("����� � ������� ����");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,250);
        
        // ������� ������       
        JButton jbtCalc = new JButton("�����");
        JButton jbtClear = new JButton("��������");
        JButton jbtAbout = new JButton("� ���������");
        JButton jbtAuthor = new JButton("�� ������");
        JButton jbtExit = new JButton("�����");

        // ������� ��� ��������� ���� ��� ����� � ������ ����������
        JTextField textField = new JTextField(15);
        JTextField textFieldResultS = new JTextField(15);
        JTextField textFieldResultV = new JTextField(15);

        // ������� ������ ������, ������ ����� �������� ����
        JPanel pBtn = new JPanel(new FlowLayout());

        // ��������� ������ �� ������ ������
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        
        //������ ������ ����� � ��������
        JPanel sc = new JPanel();
        sc.setLayout(new BoxLayout(sc, BoxLayout.LINE_AXIS));
        sc.add(jbtCalc);
        sc.add(jbtClear);
        
        // ������� ������ ������� ����� ����
        JPanel up =new JPanel(new BorderLayout());
        up.add(new JLabel("������� ������ ��� ����������"), BorderLayout.PAGE_START);
        up.add(textField,BorderLayout.CENTER);
        up.add(sc, BorderLayout.PAGE_END);
        
        // ������� ����������� ����� ���� �����
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.add(new JLabel("������� ������ ���� �����"));
        center.add(textFieldResultS);
        center.add(new JLabel("����� ������ ���� �����"));
        center.add(textFieldResultV);
        
        // ������� ����� ������� ����������
        add(up,BorderLayout.PAGE_START);
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
       
        // ������ � ���������
        jbtAbout.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Ab ==null) {
            		Run.Ab =  new About();            		
            	}
				setEnabled(false);
            	Run.Ab.setVisible(true);	
            	
			}
		});
        
        //������ �� ������
        jbtAuthor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(Run.Av ==null) {
            		Run.Av =  new Avtor();            		
            	}
				setEnabled(false);
            	Run.Av.setVisible(true);
            	
								
			}
		});
        
        // ������ �����
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "��", "���!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "������� ����?",
	                                "�������������", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // ������ �����
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(textField, textFieldResultV, textFieldResultS);
			}
		});
        
        // ������ ��������
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFieldResultS.setText("");
				textField.setText("");
				textFieldResultV.setText("");
				
			}
		});
        
        
       
        // �������������� � ������
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"��, �����", "���, ��������"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "�� ������������� ������ �����?", "��������� �� ���� ��������",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
