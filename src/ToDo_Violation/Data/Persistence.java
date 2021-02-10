package ToDo_Violation.Data;

import edu.duke.FileResource;
import edu.duke.ResourceException;
import org.apache.commons.csv.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

public class Persistence {
    static String fileName="todo_save.csv";
    public static void Save(ArrayList<ToDoModel> toDoModels) throws IOException {
        FileWriter fileWriter=new FileWriter(fileName);
        String data="";
        for (ToDoModel todo:toDoModels){
            data+=todo.toString()+"\n";
        }
        data="\n"+data;
        fileWriter.write(data);
        fileWriter.close();
    }
    public static ArrayList<ToDoModel> GetSave() throws ParseException, IOException {
        FileResource fileResource=null;
        try {
            fileResource = new FileResource(fileName);
        }catch (ResourceException exception){
            System.out.println(exception.toString());
            Save(null);
        }
        ArrayList<ToDoModel> toDoModels=new ArrayList<>();
        for (CSVRecord record:fileResource.getCSVParser()) {
            toDoModels.add(ToDoModel.fromCSVRecord(record));
        }
        return toDoModels;
    }
}
