import java.util.Scanner;

public class ToDoApp {


    public static void main(String[] args) throws PriorityException {

        Scanner scanner = new Scanner(System.in);
        boolean startApp = true;
        while (startApp) {
            System.out.println("If you want to add task press 1 " + "\n" +
                    "If you want to mark task as completed press 2 " + "\n" +
                    "If you want to exit press 0" + "\n");
            int result = scanner.nextInt();
            scanner.nextLine();

            switch (result) {
                case 1: {
                    System.out.println("Add task: ");
                    String task = scanner.nextLine();
                    System.out.println("Enter the priority of the task where 1 is the highest,and" +
                            " 7 is the lowest: ");
                    int priority = scanner.nextInt();
                    ToDo toDo = new ToDo(task, false, priority);
                    ToDo.addActiveToDos(toDo);
                    System.out.println("Your list of tasks: " + ToDo.getActiveToDos());
                }
                break;
                case 2: {
                    System.out.println("Your list of tasks: " + ToDo.getActiveToDos());
                    System.out.println("What task to delete: ");
                    String task2 = scanner.nextLine();
                    for (int i = 0; i < ToDo.getActiveToDos().size(); i++) {
                        if (task2.equals(ToDo.getActiveToDos().get(i).getDescription())) {
                            ToDo.getHistoryToDos().add(ToDo.getActiveToDos().get(i));
                            ToDo.getActiveToDos().remove(ToDo.getActiveToDos().get(i));
                            System.out.println("Your list of tasks: " + ToDo.getActiveToDos());
                            System.out.println("History: " + ToDo.getHistoryToDos());
                        }
                    }
                }
                break;
                case 0: {
                    System.out.println("Good Bye!");
                    startApp = false;
                }
                break;
                default:
                    System.out.println("You should press 1,2 or 0.Please try again! ");
            }
        }

    }

}
