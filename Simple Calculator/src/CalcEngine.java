import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
public class CalcEngine implements ActionListener {
Calculator parent; //������ �� ���� ������������
char selectedAction = ' '; // +, -, /, ��� *
double currentResult =0;
// ����������� ��������� ������ �� ���� ������������
// � ���������� ���������� ������
CalcEngine(Calculator parent){
 this.parent = parent;
}
public void actionPerformed(ActionEvent e){
 // �������� �������� ��������
 JButton clickedButton = (JButton) e.getSource();
 String dispFieldText=parent.displayField.getText();
 double displayValue=0;
 // �������� ����� �� ������� ������������,
 // ���� �� �� ������.
 // ��������������� ���� � ��� �������� ���������
 
 if (!"".equals(dispFieldText)){
 displayValue= Double.parseDouble(dispFieldText);
 }
 
 int index1 = dispFieldText.indexOf('.', 2);
 if (index1 !=-1) {
	 parent.displayField.setText("Nu ne!");
 }
 
 Object src = e.getSource();
 // ��� ������ ������ ��������������� ��������
 // ��������� ���: +, -, /, ��� *, ��������� ������� �����
 // � ���������� currentResult, � �������� �������
 // ��� ����� ������ �����
 if (src == parent.buttonPlus){
selectedAction = '+';
 currentResult=displayValue;
 parent.displayField.setText("");
 } else if (src == parent.buttonMinus){
selectedAction = '-';
 currentResult=displayValue;
 parent.displayField.setText("");
 }else if (src == parent.buttonDivide){
selectedAction = '/';
 currentResult=displayValue;
 parent.displayField.setText("");
 } else if (src == parent.buttonMultiply){
selectedAction = '*';
 currentResult=displayValue;
 parent.displayField.setText("");
 } else if (src == parent.buttonEqual){
 // ��������� �������������� ��������, � �����������
 // �� selectedAction, �������� ���������� currentResult
 // � �������� ��������� �� �������
if (selectedAction=='+'){
 currentResult+=displayValue;
 // ��������������� ��������� � ������, �������� ���
 // � ������ ������ � �������� ���
 parent.displayField.setText(""+currentResult);
}else if (selectedAction=='/' && displayValue == 0){
	  parent.displayField.setText("Infinity");
}else if (selectedAction=='-'){
 currentResult -=displayValue;
 parent.displayField.setText(""+currentResult);
}else if (selectedAction=='/'){
 currentResult /=displayValue;
 parent.displayField.setText(""+currentResult);
 }else if (selectedAction=='*'){
	 currentResult*=displayValue;
	 parent.displayField.setText(""+currentResult);
	 }
	 } else{
	// ��� ���� �������� ������ ������������ ������� ��
	 // ������ � ������� � �������
	 String clickedButtonLabel= clickedButton.getText();
	 parent.displayField.setText(dispFieldText +
	 clickedButtonLabel);
	 }
 }
}
