package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView inputText, outputText;
    Button bu1, bu2, bu3, bu4, bu5, bu6, bu7, bu8, bu9, bu0, buMultiply, buDivide, buMinus, buPlus, buEqual, buDot, buPercent,
            buAC, buPlusMinus;
    String input, output, newOutput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bu0 = findViewById(R.id.bu0);
        bu1 = findViewById(R.id.bu1);
        bu2 = findViewById(R.id.bu2);
        bu3 = findViewById(R.id.bu3);
        bu4 = findViewById(R.id.bu4);
        bu5 = findViewById(R.id.bu5);
        bu6 = findViewById(R.id.bu6);
        bu7 = findViewById(R.id.bu7);
        bu8 = findViewById(R.id.bu8);
        bu9 = findViewById(R.id.bu9);
        buPlus = findViewById(R.id.buPlus);
        buMinus = findViewById(R.id.buMinus);
        buDivide = findViewById(R.id.buDivide);
        buMultiply = findViewById(R.id.buMultiply);
        buEqual = findViewById(R.id.buEqual);
        buDot = findViewById(R.id.buDot);
        buPercent = findViewById(R.id.buPercent);
        buAC = findViewById(R.id.buAC);
        buPlusMinus = findViewById(R.id.buPlusMinus);
        inputText = findViewById(R.id.input_text);
        outputText = findViewById(R.id.output_text);
    }
    public void numberEvent(View view){
        Button button = (Button) view;
        String data = button.getText().toString();
        switch (data) {
            case "AC":
                input = null;
                output = null;
                outputText.setText("");
                break;
            case "*":
                solve();
                input+="*";
                break;
            case "+":
                solve();
                input+="+";
                break;
            case "-":
                solve();
                input+="-";
                break;
            case "=":
                solve();
                break;
            case "/":
                solve();
                input+="/";
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(inputText.getText().toString())/100;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if(input==null){
                    input = "";
                }
                if(data.equals("+")|| data.equals("/")|| data.equals("-")){
                    solve();
                }
                input+=data;
        }
        inputText.setText(input);
    }
    public void solve(){
        if(input.split("\\+").length==2){
            String number[] = input.split("\\+");
            try{
                double a = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                output = Double.toString(a);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = a+" ";
            }
            catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length==2){
            String number[] = input.split("\\-");
            try{
                double a = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                output = Double.toString(a);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = a+" ";
            }
            catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length==2){
            String number[] = input.split("\\*");
            try{
                double a = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                output = Double.toString(a);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = a+" ";
            }
            catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length==2){
            String number[] = input.split("\\/");
            try{
                double a = Double.parseDouble(number[0]) / Double.parseDouble(number[1]);
                output = Double.toString(a);
                newOutput = cutDecimal(output);
                outputText.setText(newOutput);
                input = a+" ";
            }
            catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
    }
    //This is for Vanishing Decimal number. Because we don't want our sum in floating number
    private String cutDecimal(String number){
        String n[] = number.split("\\.");
        if(n.length>1){
            if(n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}