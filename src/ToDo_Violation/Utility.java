package ToDo_Violation;

import ToDo_Violation.Commands.Command;
import ToDo_Violation.Data.ScreenData;
import ToDo_Violation.Data.ToDoModel;
import edu.duke.FileResource;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Utility {
    private static Scanner inputScanner;

    static {
        inputScanner=new Scanner(System.in);
    }
    public static String[] stringFileToStringArray(String fileName){
        return new FileResource(fileName).asString().split("\n");
    }
    public static String[] toDoMapToTitle(ArrayList<ToDoModel> toDoModels){
        return Arrays.copyOf(toDoModels.stream().map(toDoModel -> toDoModel.toDoTitle)
                .collect(Collectors.toList()).toArray(),toDoModels.size(),String[].class);
    }
    public static String takeStringInput(){
        return inputScanner.nextLine();
    }
    public static int takeIntInput(){
        System.out.print("Enter Option Index: ");
        return inputScanner.nextInt();
    }
    public static Object[] formatToDoModel(String[] formatText, ArrayList<ToDoModel> allToDo){
        ArrayList<String> formattedStrings=new ArrayList<String>();
        for(ToDoModel toDoModel:allToDo){
            formattedStrings.add(formatOneToDo(toDoModel,formatText));
        }
        return formattedStrings.toArray();
    }
    public static String formatOneToDo(ToDoModel toDoModel,String[] formatText){
        String temp="";
        temp+=formatText[0]+toDoModel.toDoTitle+"\n";
        temp+=formatText[1]+toDoModel.toDoDesc+"\n";
        temp+=formatText[2]+ DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").parse(toDoModel.date)+"\n";
        temp+=formatText[3]+toDoModel.isDone+"\n";
        temp+="\n";
        return temp;
    }

    public static ScreenData editButton(Command editCommand){
        return new ScreenData(
            "Press To Flip IsDone",
            editCommand
        );
    }
    public static ScreenData deleteButton(Command deleteCommand){
        return new ScreenData(
                "Press To Delete",
                deleteCommand
        );
    }


}
