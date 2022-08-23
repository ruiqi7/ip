public class MarkCommand extends Command {
    public static final String COMMAND_WORD = "mark";
    private int taskIndex;

    public MarkCommand(int taskNum) {
        super();
        this.taskIndex = taskNum - 1;
    }

    @Override
    public boolean isBye() {
        return false;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Task markedTask = taskList.changeTaskStatus(this.taskIndex, true);
        ui.showTaskDone(markedTask);
    }
}
