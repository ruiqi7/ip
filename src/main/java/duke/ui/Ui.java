package duke.ui;

import duke.common.Message;
import duke.data.TaskList;
import duke.tasks.Task;

import java.util.Scanner;

/**
 * Displays messages to the user to provide information of the tasks or of errors encountered.
 */
public class Ui {
    private final Scanner in;

    /**
     * Constructor for a UI.
     */
    public Ui() {
        this.in = new Scanner(System.in);
    }

    /**
     * Reads and returns the user input per line.
     * @return the user input.
     */
    public String readInput() {
        return in.nextLine();
    }

    /**
     * Displays a message to the user.
     * @param message The message to be shown to the user.
     */
    public void show(String message) {
        System.out.println(message);
    }

    /**
     * Displays the greeting message to the user.
     */
    public void showGreeting() {
        show(Message.GREETING);
    }

    /**
     * Displays the goodbye message to the user.
     */
    public void showGoodbye() {
        show(Message.GOODBYE);
        this.in.close();
    }

    /**
     * Displays the task added to the user.
     */
    public void showTaskAdded(Task task) {
        show(Message.TASK_ADDED + task);
    }

    /**
     * Displays the task removed to the user.
     */
    public void showTaskRemoved(Task task) {
        show(Message.TASK_REMOVED + task);
    }

    /**
     * Displays the task marked as done to the user.
     */
    public void showTaskDone(Task task) {
        show(Message.TASK_DONE + task);
    }

    /**
     * Displays the task marked as not done to the user.
     */
    public void showTaskNotDone(Task task) {
        show(Message.TASK_NOT_DONE + task);
    }

    /**
     * Displays the number of tasks to the user.
     */
    public void showNumberOfTasks(int count) {
        show(String.format(Message.NUMBER_OF_TASKS, count));
    }

    /**
     * Displays all tasks on the list to the user.
     */
    public void showAllTasks(TaskList taskList) {
        int size = taskList.numTasks();
        if (size != 0) {
            show(Message.TASK_LIST);
            for (int i = 0; i < size; i++) {
                int taskNum = i + 1;
                Task task = taskList.getTask(i);
                show(taskNum + "." + task);
            }
        } else {
            show(Message.EMPTY_TASK_LIST);
        }
    }
}