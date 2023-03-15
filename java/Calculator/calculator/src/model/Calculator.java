package model;

import conteiner.Token;

import java.util.ArrayList;

public class Calculator {

    private ArrayList<Token> tokens;
    private int pos;
    static String expr;

    public Calculator(ArrayList<Token> tokens){
        this.tokens = tokens;
        this.pos = 0;
    }

    public double calculate(){

        double first = multiply();

        while (pos < tokens.size()){
            String operator = tokens.get(pos).getValue();
            if (!operator.equals("+") && !operator.equals("-")){
                break;
            }else{
                pos++;
            }

            double second = multiply();
            if(operator.equals("+")){
                first+=second;
            }else {
                first-=second;
            }
        }
        return first;
    }
    public double multiply(){
        double first = factor();

        while (pos < tokens.size()){
            String operator = tokens.get(pos).getValue();
            if (!operator.equals("*") && !operator.equals("/")){
                break;
            }else{
                pos++;
            }

            double second = factor();
            if(operator.equals("*")){
                first *= second;
            }else {
                first /= second;
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
}
