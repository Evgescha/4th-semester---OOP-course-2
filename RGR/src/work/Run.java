package work;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import frame.*;

/**
 * Главный класс программы. В нем создаются окна и управляют ими, также проводят расчеты
 * @author Yauhenii
 *
 */
public class Run {

	//переменные форм
	/**
	 * Стартовое окно
	 */
	public static StartPage SP;
	/**
	 * Главное окно
	 */
	public static MainFrame MF;
	/**
	 * Программное окно (о программе)
	 */
	public static About Ab;
	/**
	 * Авторское окно
	 */
	public static Avtor Av;
	//вводимое пользователем число
	/**
	 * радиус
	 */
	public static long number;
	//массив всех простых чисел, составляющих заданное
	
	
	/**
	 * Главный метод, создает стартовое окно
	 * @param args строковый массив
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	/**
	 * Метод, обьединяющий работу всех методов
	 * @param numbr текстовое поле, отукда берем радиус
	 * @param antwort текстовое поле, куда будем записывать ответ обьем
	 * @param more текстовое поле, в которое будем записывать ответ площадь
	 * 
	 */
	public static void Arbeit( JTextField numbr, JTextField antwort, JTextField more) {
		
		String str = numbr.getText();		
		if(isNumber(str) && (Long.parseLong(str))!=0) {
			int R = Integer.parseInt(str);
		
			float S =  (float) (4 * Math.PI * R * R);
			float V =  (float) (4 * Math.PI * R * R * R)/3;
		
		more.setText(S+"");		
		antwort.setText(V+"");		
		
		} else {
			JOptionPane.showMessageDialog(null, "Ожидается ввод положительного целого числа. \n"+ "Проверьте, является ли введанная вами информация числом");
		}
    }
	
	/**
	 * Метод проверки строки на число
	 * @param str исходная строка в виде числа
	 * @return булевое значение, является ли строка числом
	 */
	public static boolean isNumber(String str) {
	    if (str == null || str.isEmpty()) return false;
	    for (int i = 0; i < str.length(); i++) {
	        if (!Character.isDigit(str.charAt(i))) return false;
	    }
	    return true;
	}
	

}
