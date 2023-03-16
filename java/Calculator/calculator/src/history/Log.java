package history;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Log {
    private final String path = "C:/Users/Xaker/IdeaProjects/calculator/log.txt";
    public void writFile(String x, String rezult){
        try(FileWriter writer = new FileWriter(path, true))
        {
            writer.append(x).append(" = ").append(rezult).append(String.valueOf('\n'));

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public void readFile(){
        try(FileReader reader = new FileReader(path))
        {
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}