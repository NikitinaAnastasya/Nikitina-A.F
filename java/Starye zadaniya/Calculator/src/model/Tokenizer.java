package model;

import conteiner.Token;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;


public class Tokenizer {

    ArrayList<Token> rezult = new ArrayList<>();
    Vector<String> bufferInt = new Vector<>();
    Vector<String> bufferOper = new Vector<>();
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

        //для проверки Tokenizer

        //rezult.forEach(System.out::println);

        return rezult;

    }

    void detection(String[] x){
        try {
            int a =0;
            for (int i=0;i<x.length;i++) {
                if( isOperator(x[0]) & a == 0 & isDigit(x[1])){ //проверка 1-ого числа на -
                    bufferInt.add(x[0]);
                    a=1;
                }else{
                    a = 1;
                    if(Objects.equals(x[i], ".") | Objects.equals(x[i], ",")){ // проверка числа на дробность
                        if (Objects.equals(x[i], ",")){ // проверка на , в дроби
                            bufferInt.add(".");
                        }else {
                            bufferInt.add(x[i]);
                        }
                    }else {
                        if (isDigit(x[i]) ){ // проверка символа на число
                            bufferInt.add(x[i]);
                            bufferOper(bufferOper);
                        }else {
                            if (isOperator(x[i])){// проверка символа на оперетор
                                bufferOper.add(x[i]);
                                if (x[i].equals("%")){
                                    bufferInt.add(x[i]);
                                    bufferInt(bufferInt);
                                    bufferOper.clear();
                                }else {
                                    if (isValid(x[i-1]) && x[i].equals("-")){ // проверка числа на - после скобки
                                        bufferInt.add(x[i]);
                                        bufferOper.clear();
                                    }else {
                                        bufferInt(bufferInt);
                                        bufferOper(bufferOper);
                                    }
                                }
                            }else{
                                if (isValid(x[i])){ // проверка символа на скобку
                                    bufferInt(bufferInt);
                                    rezult.add(new Token("Скобка",x[i]));
                                }
                            }
                        }
                    }
                }
            }
            bufferInt(bufferInt);
            bufferOper(bufferOper);
        }catch (RuntimeException e){
            System.out.println("Ошибка в расчетах проверьте пример!!!");

        }

    }
    void bufferInt(Vector buffer){
        if(!buffer.isEmpty() ){
            rezult.add(new Token("Число",String.join("", buffer)));
            bufferInt.clear();
        }
    }
    void bufferOper(Vector buffer){
        if (!buffer.isEmpty()) {
            rezult.add(new Token("Оператор",String.join("", buffer)));
            bufferOper.clear();
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
        return ch.equals("+") | ch.equals("-") | ch.equals("*") | ch.equals("/") | ch.equals("**") | ch.equals("%") | ch.equals("//");
    }
    //Проверка на скобки
    boolean isValid(String ch){
        return ch.equals("(") | ch.equals(")");
    }
}
