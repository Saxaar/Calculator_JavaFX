package sample;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField text_field;

    String op ="";
    long number1;
    long number2;



    public void Number (javafx.event.ActionEvent ae){
        String no = ((Button)ae.getSource()).getText();
        text_field.setText(text_field.getText()+no);
    }
    public void Operation (javafx.event.ActionEvent ae){
        String operation = ((Button)ae.getSource()).getText();
        if (!operation.equals("=")){
            if (!op.equals("")){

                return;
            }
            op = operation;
            number1 = Long.parseLong(text_field.getText());
        } else {
            if(op.equals("")){
                return;
            }
            number2 = Long.parseLong(text_field.getText());
            text_field.setText("");
            calculate ( number1,  number2,  op);

            op = "";
        }
    }

    public void calculate (long n1, long n2, String op) {

        switch (op){

            case "+" :
                text_field.setText(n1+n2+"");
                break;
            case "-" :
                text_field.setText(n1-n2+"");
                break;
            case "*" :
                text_field.setText(n1*n2+"");
                break;
            case "/" :
                if (n2 == 0){
                    text_field.setText("0");
                    break;
                }
                text_field.setText(n1/n2 + "");
                break;

        }
    }

    @FXML
    public void initialize(URL url, ResourceBundle rb) {


    }



}
