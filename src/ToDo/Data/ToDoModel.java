package ToDo.Data;

import org.apache.commons.csv.CSVRecord;

import java.text.ParseException;

public class ToDoModel {
    public String toDoTitle;
    public String toDoDesc;
    public String date;
    public Boolean isDone;

    public ToDoModel(String toDoTitle, String toDoDesc, String date, int isDone) throws ParseException {
        this.toDoTitle = toDoTitle;
        this.toDoDesc = toDoDesc;
        this.date = date;
        this.isDone = (isDone == 1);
    }

    @Override
    public String toString() {
        return toDoTitle + "," + toDoDesc + "," + date + "," + (isDone ? 1 : 0);
    }

    public static ToDoModel fromCSVRecord(CSVRecord record) throws ParseException {
        ToDoModel toDoModel = new ToDoModel(
                record.get(0),
                record.get(1),
                record.get(2),
                Integer.parseInt(record.get(3))
        );
        return toDoModel;
    }
}
