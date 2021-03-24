import java.util.ArrayList;
import java.util.Collections;

public class ToDo implements Comparable<ToDo> {
    private String description;
    private boolean isDone;
    private int priority;
    private static ArrayList<ToDo> activeToDos = new ArrayList<>();
    private static ArrayList<ToDo> historyToDos = new ArrayList<>();

    public ToDo(String description, boolean isDone, int priority) throws PriorityException {
        this.description = description;
        this.isDone = isDone;
        if (priority > 0 && priority < 8) {
            this.priority = priority;
        } else {
            throw new PriorityException("The priority should be from 1 to 7 inclusive!");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) throws PriorityException {
        if (priority > 0 && priority < 8) {
            this.priority = priority;
        } else {
            throw new PriorityException("The priority should be from 1 to 7 inclusive!");
        }
    }

    public static ArrayList<ToDo> getActiveToDos() {
        return activeToDos;
    }

    public static void setActiveToDos(ArrayList<ToDo> activeToDos) {
        ToDo.activeToDos = activeToDos;
    }

    public static ArrayList<ToDo> getHistoryToDos() {
        return historyToDos;
    }

    public static void setHistoryToDos(ArrayList<ToDo> historyToDos) {
        ToDo.historyToDos = historyToDos;
    }

    public static void addActiveToDos(ToDo toDo) {
        activeToDos.add(toDo);
        Collections.sort(activeToDos);
    }

    public static void removeFromActiveTodo(ToDo toDo) {
        activeToDos.remove(toDo);

    }

    public static void addHistoryToDos(ToDo toDo) {
        historyToDos.add(toDo);
    }

    public static void removeFromHistoryTodo(ToDo toDo) {
        historyToDos.remove(toDo);
    }

    @Override
    public String toString() {
        return description;
    }

    @Override
    public int compareTo(ToDo toDo) {
        if (priority > toDo.priority) {
            return 1;
        } else if (priority < toDo.priority) {
            return -1;
        } else {
            return 0;
        }
    }
}
