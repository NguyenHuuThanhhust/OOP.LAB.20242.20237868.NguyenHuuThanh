import javax.swing.JOptionPane;

public class Bai225Calculator {

    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification = "Ban da nhap 2 so: ";

        strNum1 = JOptionPane.showInputDialog(null, "Xin hay nhap so thu 1 :", "Nhap so thu 1", JOptionPane.QUESTION_MESSAGE);
        double num1 = Double.parseDouble(strNum1);          strNotification += strNum1 + " and ";

        strNum2 = JOptionPane.showInputDialog(null, "Xin hay nhap so thu 2 :", "Nhap so thu 2", JOptionPane.QUESTION_MESSAGE);
        double num2 = Double.parseDouble(strNum2); 
        strNotification += strNum2;

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num2 != 0 ? num1 / num2 : Double.NaN; 

        String result = strNotification + "\n" +
                       "Tong: " + sum + "\n" +
                       "Hieu: " + difference + "\n" +
                       "Tich: " + product + "\n" +
                       "Thuong: " + (quotient == Double.NaN ? "Khong the chia cho 0" : quotient);

        JOptionPane.showMessageDialog(null, result, "Calculation Results", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
