package duke.data;

import duke.data.exception.DukeException;
import duke.common.Message;
import duke.tasks.Task;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public int numTasks() {
        return this.tasks.size();
    }

    public Task getTask(int index) {
        return this.tasks.get(index);
    }

    public Task changeTaskStatus(int index, boolean isDone) throws DukeException {
        if (index >=0 && index < this.tasks.size()) {
            Task task = this.tasks.get(index);
            task.changeStatus(isDone);
            return task;
        } else {
            throw new DukeException(Message.NO_SUCH_TASK);
        }
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public Task deleteTask(int index) throws DukeException {
        if (index >=0 && index < this.tasks.size()) {
            Task task = this.tasks.get(index);
            this.tasks.remove(task);
            return task;
        } else {
            throw new DukeException(Message.NO_SUCH_TASK);
        }
    }

    public ArrayList<Task> getMatchingTasks(String keyword) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.hasKeyword(keyword)) {
                matchingTasks.add(task);
            }
        }
        return matchingTasks;
    }
}
