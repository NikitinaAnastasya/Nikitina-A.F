package history;

import java.io.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Scanner;

public class Log {
    Scanner scanner = new Scanner(System.in);
    private final String path = "C:/Users/Xaker/IdeaProjects/calculator/save/";
    private final String nameLog = "log.txt";
    private final String lastStart = "C:/Users/Xaker/IdeaProjects/calculator/save/lastStart.txt";

    public void writeFile(ArrayList<String> x,String line,String nameFile){

        if (line.equals("0")){
            line = path;
        }
        if (nameFile.equals("0")){
            nameFile = nameLog;
        }
        try(FileWriter writer = new FileWriter(line + nameFile, true))
        {
                for (String d : x) {
                    writer.append(d).append(String.valueOf('\n'));

                    writer.flush();
                }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void writeLastStart(ArrayList<String> x){
        try(FileWriter writer = new FileWriter(lastStart, false))
        {
            for (String d : x){
                writer.append(d).append(String.valueOf('\n'));

                writer.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void writeFileName(String line , String nameFile , ArrayList<String> x){

        if (line.equals("0")){
            line = path;
        }
        if ( nameFile.equals("0.txt")){
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String time = String.valueOf(timestamp).replace(":","-");
            nameFile = time+".txt";
        }

        File file = new File(line + nameFile);
        System.out.println(line + nameFile);

        if(!file.exists() && !file.isDirectory()) {
            try {
                if (file.createNewFile()){
                    System.out.println("File is created!");

                        writeFile(x, line,nameFile);
                }
                else{
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else {
            if(!file.exists()){
                System.out.println("Не найден путь!!!\n" +
                        "Введите другой путь");
                line = scanner.next();
                writeFileName(line,nameFile + ".txt",x);

            }
            if (!file.isDirectory()){
                System.out.println("Файл с таким именем уже существует!!!\n" +
                        "Введите другое имя файла");
                nameFile = scanner.next();
                writeFileName(line,nameFile,x);
            }
        }


    }
    public ArrayList<String> readFile(){
        try(BufferedReader read = new BufferedReader(new FileReader(path)))
        {
            ArrayList<String> log = new ArrayList<>();
            String line = read.readLine();
            while (line != null) {

                log.add(line);
                line = read.readLine();

            }

            return log;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }
    public ArrayList<String> readLastStart(){
        try(BufferedReader read = new BufferedReader(new FileReader(lastStart)))
        {
            ArrayList<String> log = new ArrayList<>();

            String line = read.readLine();
            while (line != null) {

                log.add(line);
                line = read.readLine();

            }

            return log;
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
            return null;
        }
    }

}