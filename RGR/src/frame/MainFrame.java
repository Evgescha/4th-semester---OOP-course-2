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
 * Главное окно программы
 * @version 1.0 05/05/2018
 * @author Мр. Хикка
 *
 */
public class MainFrame extends JFrame {
	
	/**
	 * Метод отрисовки главной формы программы.
	 */
	public MainFrame() {
		// устанавливаем заголовок, выход по крестику, размер и запрещем масщтабировать 
        setTitle("Объем и площадт шара");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(300,250);
        
        // Создаем кнопки       
        JButton jbtCalc = new JButton("Найти");
        JButton jbtClear = new JButton("Очистить");
        JButton jbtAbout = new JButton("О программе");
        JButton jbtAuthor = new JButton("Об авторе");
        JButton jbtExit = new JButton("Выход");

        // создаем два текстовых поля для ввода и вывода результата
        JTextField textField = new JTextField(15);
        JTextField textFieldResultS = new JTextField(15);
        JTextField textFieldResultV = new JTextField(15);

        // Создаем панель кнопок, нижняя часть главного окна
        JPanel pBtn = new JPanel(new FlowLayout());

        // Добавляем кнопки на панель кнопок
        pBtn.add(jbtAbout);
        pBtn.add(jbtAuthor);
        pBtn.add(jbtExit);
        
        
        //панель кнопок найти и очистить
        JPanel sc = new JPanel();
        sc.setLayout(new BoxLayout(sc, BoxLayout.LINE_AXIS));
        sc.add(jbtCalc);
        sc.add(jbtClear);
        
        // создаем панель верхней части окна
        JPanel up =new JPanel(new BorderLayout());
        up.add(new JLabel("Введите Радиус для нахождения"), BorderLayout.PAGE_START);
        up.add(textField,BorderLayout.CENTER);
        up.add(sc, BorderLayout.PAGE_END);
        
        // создаем центральную часть окна верха
        JPanel center = new JPanel();
        center.setLayout(new BoxLayout(center, BoxLayout.PAGE_AXIS));
        center.add(new JLabel("Площадь вашего шара равна"));
        center.add(textFieldResultS);
        center.add(new JLabel("Обьем вашего шара равен"));
        center.add(textFieldResultV);
        
        // создаем общую картину мироздания
        add(up,BorderLayout.PAGE_START);
        add(center,BorderLayout.CENTER);
        add(pBtn,BorderLayout.PAGE_END);
       
        // кнопка о программе
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
        
        //кнопка об автаре
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
        
        // кнопка выйти
        jbtExit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 Object[] options = { "Да", "Нет!" };
	                int n = JOptionPane
	                        .showOptionDialog(null, "Закрыть окно?",
	                                "Подтверждение", JOptionPane.YES_NO_OPTION,
	                                JOptionPane.QUESTION_MESSAGE, null, options,
	                                options[0]);
	                if (n == 0) {	                    
	                    System.exit(0);
	                }
			}
		});
        
        // кнопка найти
        jbtCalc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Run.Arbeit(textField, textFieldResultV, textFieldResultS);
			}
		});
        
        // кнопка очистить
        jbtClear.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				textFieldResultS.setText("");
				textField.setText("");
				textFieldResultV.setText("");
				
			}
		});
        
        
       
        // предупреждение о выходе
        addWindowListener(new WindowAdapter() {
        	 
            @Override
            public void windowClosing(WindowEvent we) {
                String ObjButtons[] = {"Да, выйти", "Нет, остаться"};
                int PromptResult = JOptionPane.showOptionDialog(null,
                        "Вы действительно хотите выйти?", "Отвечайте за свои поступки",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null,
                        ObjButtons, ObjButtons[1]);
                if (PromptResult == 0) {
                    System.exit(0);
                }
            }
        });
	}
}
