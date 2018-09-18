package frame;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import work.Run;

/**
 * калькулятор 
 * Объем и площадь геометрических фигур
 * 28.	Объем и площадь шара
 * О программе
 *
 * @version 1.0 05/05/2018
 * @author Мр. Хикка
 */

public class About extends JDialog {
	/**
	 * @uml.property  name="jtxtArea"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextArea jtxtArea = new JTextArea();
  
    /**
	 * @uml.property  name="jbtBack"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JButton jbtBack = new JButton("Назад");

    /**
     * Конструктор класса о программе
     */
	public About(){
		setSize(340, 150);
		setResizable(false);
		setTitle("О программе");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        // информация о программе
        jtxtArea.setColumns(20);
        jtxtArea.setRows(5);
        jtxtArea.setWrapStyleWord(true);
        jtxtArea.setLineWrap(true);
        jtxtArea.setEditable(false);
        jtxtArea.setText("Программа предназначена для нахождения \n"
        		+ "объема и площади шара \n"
        		+ "по данному радиусу");
               

        jtxtArea.setFont(new Font("Arial", Font.PLAIN, 16));
        
        // панель кнопок
        JPanel pnlButton = new JPanel(new GridLayout(1, 2, 5, 5));
        pnlButton.add(jbtBack);

        setLayout(new BorderLayout());
        add(jtxtArea, BorderLayout.CENTER);
        add(pnlButton, BorderLayout.SOUTH);

        setFocusable(true);
        setFocusableWindowState(true);
       
        //Кнопка "Назад"
        jbtBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Back();
				
			}
		});
       

     // При выходе из окна открывать доступ к окну-родителю
        addWindowListener(new WindowListener() {      
            public void windowClosing(WindowEvent event) {
               Run.MF.setEnabled(true);
            }

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
 
        });
       

	}
	
	/**
	 * Возвращение на предыдущее окно
	 */
	void Back() {
		 Run.MF.setEnabled(true);
		 dispose();	
		   
	}


}
