package work;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import frame.*;

/**
 * ������� ����� ���������. � ��� ��������� ���� � ��������� ���, ����� �������� �������
 * @author Yauhenii
 *
 */
public class Run {

	//���������� ����
	/**
	 * ��������� ����
	 */
	public static StartPage SP;
	/**
	 * ������� ����
	 */
	public static MainFrame MF;
	/**
	 * ����������� ���� (� ���������)
	 */
	public static About Ab;
	/**
	 * ��������� ����
	 */
	public static Avtor Av;
	//�������� ������������� �����
	/**
	 * ������
	 */
	public static long number;
	//������ ���� ������� �����, ������������ ��������
	
	
	/**
	 * ������� �����, ������� ��������� ����
	 * @param args ��������� ������
	 */
	public static void main(String[] args) {
		 
		SP = new StartPage();
		SP.setVisible(true);
		
	}
	
	/**
	 * �����, ������������ ������ ���� �������
	 * @param numbr ��������� ����, ������ ����� ������
	 * @param antwort ��������� ����, ���� ����� ���������� ����� �����
	 * @param more ��������� ����, � ������� ����� ���������� ����� �������
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
			JOptionPane.showMessageDialog(null, "��������� ���� �������������� ������ �����. \n"+ "���������, �������� �� ��������� ���� ���������� ������");
		}
    }
	
	/**
	 * ����� �������� ������ �� �����
	 * @param str �������� ������ � ���� �����
	 * @return ������� ��������, �������� �� ������ ������
	 */
	public static boolean isNumber(String str) {
	    if (str == null || str.isEmpty()) return false;
	    for (int i = 0; i < str.length(); i++) {
	        if (!Character.isDigit(str.charAt(i))) return false;
	    }
	    return true;
	}
	

}
