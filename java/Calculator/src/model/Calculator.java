package model;

import conteiner.Token;

import java.util.ArrayList;
import java.util.Vector;

import static java.lang.Math.*;

public class Calculator {

    private final ArrayList<Token> tokens;
    private int pos;

    public Calculator(ArrayList<Token> tokens){
        this.tokens = tokens;
        this.pos = 0;
    }

    public double calculate(){
        double first = multiply();

        while (pos < tokens.size()) {
            String operator = tokens.get(pos).getValue();
            if (!operator.equals("+") && !operator.equals("-")) {
                break;
            } else {
                pos++;
            }

            double second;
            if (check(tokens.get(pos).getValue())){
                second = first *(splitPerc(tokens.get(pos).getValue()) / 100);
                pos++;
            }
            else {
                second = multiply();
            }

            if (operator.equals("+")) {
                first += second;
            } else {
                first -= second;
            }

        }
        return first;
    }
    public double multiply(){
        double first = erect();

        while (pos < tokens.size()){
            String operator = tokens.get(pos).getValue();
            if (!operator.equals("*") && !operator.equals("/")){
                break;
            }else{
                pos++;
            }

            double second;

            if (check(tokens.get(pos).getValue())){
                if(operator.equals("*")){
                    second = splitPerc(tokens.get(pos).getValue()) / 100;
                    pos++;
                }else{
                    second = first / 100 * splitPerc(tokens.get(pos).getValue());
                    pos++;
                }
            }else {
                second = erect();
            }

            if(operator.equals("*")){
                first *= second;
            }else {
                first /= second;
            }
        }
        return first;
    }
    public double erect(){

        double first = factor();

        while (pos < tokens.size()){
            String operator = tokens.get(pos).getValue();
            if (!operator.equals("**") && !operator.equals("//")){
                break;
            }else{
                pos++;
            }

            double second = factor();
            if(operator.equals("**")){

                first = pow(first, second);

            }else {
                if (second == 2){
                    first = sqrt(first);
                }
                if (second == 3){
                    first = cbrt(first);
                }
            }
        }

        return first;
    }

    public double factor(){
        String next = tokens.get(pos).getValue();
        double result;
        if(next.equals("(")){
            pos++;
            result = calculate();
            String closingBracket;
            if (pos < tokens.size()){
                closingBracket = tokens.get(pos).getValue();
            }else {
                try {
                    throw new IllegalAccessException("Unexpected end of expression");
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            if (closingBracket.equals(")")){
                pos++;
                return result;
            }
            try {
                throw new IllegalAccessException(") expected but " + closingBracket + " found");
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        pos++;
        return Double.parseDouble(next);
    }
    public boolean check(String x){

        String[] d = x.split("");

        for (String s : d) {
            if (s.equals("%")) {
                return true;
            }
        }

        return false;
    }

    public double splitPerc(String x){
        Vector<String> s = new Vector<>();
        String[] d = x.split("");

        for (String value : d) {
            if (!value.equals("%")) {
                s.add(value);
            }
        }
        return Double.parseDouble(String.join("",s));

    }
}
