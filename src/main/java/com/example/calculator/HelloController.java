package com.example.calculator;

import com.fathzer.soft.javaluator.DoubleEvaluator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.commons.lang3.StringUtils;

public class HelloController {

    public static String expression="";
    public static String HexExpression="";
    public static String DecExpression="";
    @FXML
    private Button aBtn;

    @FXML
    private Button bBtn;

    @FXML
    private Button cBtn;

    @FXML
    private Button clearBtn;

    @FXML
    private Button dBtn;

    @FXML
    private Button divBtn;

    @FXML
    private Button eBtn;

    @FXML
    private Button eightBtn;

    @FXML
    private Button equalBtn;

    @FXML
    private Button fBtn;

    @FXML
    private Button fiveBtn;

    @FXML
    private Button fourBtn;

    @FXML
    private Button minusBtn;

    @FXML
    private Button modeBtn;

    @FXML
    private TextField modeScreen;

    @FXML
    private Button mulBtn;

    @FXML
    private Button nineBtn;

    @FXML
    private Button oneBtn;

    @FXML
    private Button plusBtn;

    @FXML
    private TextField screen;

    @FXML
    private Button sevenBtn;

    @FXML
    private Button sixBtn;

    @FXML
    private Button threeBtn;

    @FXML
    private Button twoBtn;

    @FXML
    private Button zeroBtn;

    @FXML
    void add0(ActionEvent event) {
        expression+="0";
        screen.setText(expression);

    }

    @FXML
    void add1(ActionEvent event) {
    expression+="1";
        screen.setText(expression);

    }

    @FXML
    void add2(ActionEvent event) {
    expression+="2";
        screen.setText(expression);

    }

    @FXML
    void add3(ActionEvent event) {
        expression+="3";
        screen.setText(expression);

    }

    @FXML
    void add4(ActionEvent event) {
        expression+="4";
        screen.setText(expression);

    }

    @FXML
    void add5(ActionEvent event) {
        expression+="5";
        screen.setText(expression);

    }

    @FXML
    void add6(ActionEvent event) {
        expression+="6";
        screen.setText(expression);

    }

    @FXML
    void add7(ActionEvent event) {
        expression+="7";
        screen.setText(expression);

    }

    @FXML
    void add8(ActionEvent event) {
        expression+="8";
        screen.setText(expression);

    }

    @FXML
    void add9(ActionEvent event) {
        expression+="9";
        screen.setText(expression);

    }

    @FXML
    void addA(ActionEvent event) {
        expression+="A";
        screen.setText(expression);

    }

    @FXML
    void addB(ActionEvent event) {
        expression+="B";
        screen.setText(expression);


    }

    @FXML
    void addC(ActionEvent event) {
        expression+="C";
        screen.setText(expression);


    }

    @FXML
    void addD(ActionEvent event) {
        expression+="D";
        screen.setText(expression);


    }

    @FXML
    void addDiv(ActionEvent event) {
        expression+="/";
        screen.setText(expression);


    }

    @FXML
    void addE(ActionEvent event) {
        expression+="E";
        screen.setText(expression);


    }

    @FXML
    void addF(ActionEvent event) {
        expression+="F";
        screen.setText(expression);


    }

    @FXML
    void addMinus(ActionEvent event) {
        expression+="-";
        screen.setText(expression);


    }

    @FXML
    void addMul(ActionEvent event) {
        expression+="*";
        screen.setText(expression);


    }

    @FXML
    void addPlus(ActionEvent event) {
        expression+="+";
        screen.setText(expression);

    }

    @FXML
    void clearString(ActionEvent event) {
        expression="";
        screen.setText(expression);

    }
    void stateEverything(boolean state){
        aBtn.setDisable(state);
        bBtn.setDisable(state);
        cBtn.setDisable(state);
        dBtn.setDisable(state);
        eBtn.setDisable(state);
        fBtn.setDisable(state);
        zeroBtn.setDisable(state);
        oneBtn.setDisable(state);
        twoBtn.setDisable(state);
        threeBtn.setDisable(state);
        fiveBtn.setDisable(state);
        fourBtn.setDisable(state);
        sixBtn.setDisable(state);
        sevenBtn.setDisable(state);
        eightBtn.setDisable(state);
        nineBtn.setDisable(state);
        mulBtn.setDisable(state);
        divBtn.setDisable(state);
        plusBtn.setDisable(state);
        minusBtn.setDisable(state);
        equalBtn.setDisable(state);
        modeBtn.setDisable(state);
        modeScreen.setDisable(state);
    }
    @FXML
    void getResult(ActionEvent event) {
        if(modeScreen.getText().equals("HEX")){
            ArithmeticApp newApp=new ArithmeticApp(expression);
            String result=newApp.getResult();
            expression=result;
                screen.setText(result);

        }
        else{
            DoubleEvaluator doubleevaluator = new DoubleEvaluator();
                String result = "" + (doubleevaluator.evaluate(expression).intValue());
                expression=result;
                screen.setText(result);
        }
    }

    @FXML
    void switchMode(ActionEvent event) {
        modeScreen.setText(modeScreen.getText().equals("HEX") ? "DEC": "HEX");
        screen.setText(expression);
        if(modeScreen.getText().equals("DEC")){
            aBtn.setDisable(true);
            bBtn.setDisable(true);
            cBtn.setDisable(true);
            dBtn.setDisable(true);
            eBtn.setDisable(true);
            fBtn.setDisable(true);
            if(screen.getText()!=""){
                //convert from hex to dec
                    expression=""+hextoint(screen.getText());
                    screen.setText(""+hextoint(screen.getText()));

            }
        }
        else{
            aBtn.setDisable(false);
            bBtn.setDisable(false);
            cBtn.setDisable(false);
            dBtn.setDisable(false);
            eBtn.setDisable(false);
            fBtn.setDisable(false);
            if(!screen.getText().equals("")){
                //convert from dec to hex
                    expression = inttoHex(Integer.parseInt(screen.getText()));
                    screen.setText(inttoHex(Integer.parseInt(screen.getText())));

            }
        }
    }
    String inttoHex(int number) {
        String hexResult = "";
        String digits = "0123456789ABCDEF";
        while (number >= 1) {
            hexResult=hexResult.concat(""+digits.charAt((int) number % 16));
            number /= 16;
        }
        hexResult = StringUtils.reverse(hexResult);
        return hexResult;
    }
    boolean isHex(String c) {
        return c.matches("[A-F0-9]");
    }
    boolean isDec(String c){
        return c.matches("[0-9]");
    }
    int hextoint(String hex) {
        int size=hex.length();
        String digits = "0123456789ABCDEF";
        int result=0;
        while(size>0){
            result+=(digits.indexOf(hex.charAt(size-1))*Math.pow(16,hex.length()-size));
            size-=1;
        }
        return result;
    }

}

