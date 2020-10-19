package fitr.command;

import fitr.list.ExerciseList;
import fitr.list.FoodList;
import fitr.storage.Storage;
import fitr.user.User;

public class AddGoalCommand extends Command {
    protected String createdDateTime;

    public AddGoalCommand(String command, String createdDateTime) {
        this.command = command;
        this.createdDateTime = createdDateTime;
    }

    @Override
    public void execute(FoodList foodList, ExerciseList exerciseList, Storage storage, User user) {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}
