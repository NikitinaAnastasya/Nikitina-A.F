package model;

import conteiner.Token;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;

public class Tokenizer {
    ArrayList<Token> rezult = new ArrayList<>();
    Vector<String> bufferInt = new Vector<>();
    public ArrayList<Token> tokenizer(String str){
        rezult.clear();

        String[] x;

        x = str.split("");

        detection(x);

        for(int i=0;i<rezult.size();i++){
            if (rezult.get(i).getValue().equals("")){
                rezult.remove(i);
            }
        }

        rezult.forEach(System.out::println);

        return rezult;

    }

    void detection(String[] x){
        int a =0;
        for (int i=0;i<x.length;i++) {
            if( isOperator(x[0]) & a == 0 & isDigit(x[1])){
                bufferInt.add(x[0]);
                a=1;
            }else{
                a = 1;
                if(Objects.equals(x[i], ".") | Objects.equals(x[i], ",")){
                    if (Objects.equals(x[i], ",")){
                        bufferInt.add(".");
                    }else {
                        bufferInt.add(x[i]);
                    }
                }else {
                    if (isDigit(x[i]) ){
                        bufferInt.add(x[i]);
                    }else {
                        if (isOperator(x[i])){
                            if (isValid(x[i-1])){
                                bufferInt.add(x[i]);
                            }else {
                                Buffer(bufferInt);
                                rezult.add(  new Token("Оператор",x[i]));
                            }
                        }else{
                            if (isValid(x[i])){
                                Buffer(bufferInt);
                                rezult.add(new Token("Скобка",x[i]));
                            }
                        }
                    }
                }
            }
        }
        Buffer(bufferInt);
    }
    void Buffer(Vector buffer){
        if(buffer != null ){
            rezult.add(new Token("Число",String.join("", buffer)));
            bufferInt.clear();
        }
    }
    //Проверка на число
    boolean isDigit(String ch){
        try {
            Double.valueOf(ch);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    //Проверка на оперватор
    boolean isOperator(String ch){
        return ch.equals("+") | ch.equals("-") | ch.equals("*") | ch.equals("/");
    }
    //Проверка на скобки
    boolean isValid(String ch){
        return ch.equals("(") | ch.equals(")");
    }
}
