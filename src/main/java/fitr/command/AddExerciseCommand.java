package fitr.command;

import fitr.Calorie;
import fitr.Exercise;
import fitr.exception.FitrException;
import fitr.list.ExerciseList;
import fitr.list.FoodList;
import fitr.storage.Storage;
import fitr.ui.Ui;
import fitr.user.User;

import java.io.IOException;

public class AddExerciseCommand extends Command {
    protected String createdDateTime;

    public AddExerciseCommand(String command, String createdDateTime) {
        this.command = command;
        this.createdDateTime = createdDateTime;
    }

    @Override
    public void execute(FoodList foodList, ExerciseList exerciseList, Storage storage, User user) {
        command = command.split(" ", 2)[1];
        try {
            String nameOfExercise = command.split("/", 2)[0];
            if (nameOfExercise.isEmpty()) {
                throw new ArrayIndexOutOfBoundsException();
            }
            nameOfExercise = nameOfExercise.trim();
            command = command.split("/", 2)[1];
            if (command.split(" ").length == 1) {
                Calorie amountOfCaloriesBurnt = new Calorie(Integer.parseInt(command.split(" ")[0]));
                if (amountOfCaloriesBurnt.get() < -1) {
                    throw new NumberFormatException();
                }
                //exerciseList.addExercise(new Exercise(nameOfExercise, amountOfCaloriesBurnt, createdDateTime));
                exerciseList.addExercise(new Exercise(nameOfExercise, amountOfCaloriesBurnt));
                storage.writeExerciseList(exerciseList);
                Ui.printCustomMessage("The following exercise has been added: " + nameOfExercise);
            } else if (command.split(" ").length == 2) {
                Calorie amountOfCaloriesBurnt = new Calorie(Integer.parseInt(command.split(" ")[0]));
                int durationOfExercise = Integer.parseInt(command.split(" ", 2)[1]);
                if (amountOfCaloriesBurnt.get() < 0) {
                    throw new NumberFormatException();
                }
                if (durationOfExercise < 0) {
                    throw new FitrException();
                }
                //exerciseList.addExercise(new Exercise(nameOfExercise, amountOfCaloriesBurnt,
                // durationOfExercise, createdDateTime));
                exerciseList.addExercise(new Exercise(nameOfExercise, amountOfCaloriesBurnt, durationOfExercise));
                storage.writeExerciseList(exerciseList);
                Ui.printCustomMessage("The following exercise has been added: " + nameOfExercise);
            }
        } catch (NumberFormatException | NullPointerException e) {
            Ui.printCustomError("Sorry, invalid calorie amount entered");
        } catch (ArrayIndexOutOfBoundsException e) {
            Ui.printCustomError("Please key in the correct format");
        } catch (IOException e) {
            Ui.printCustomError("Sorry, there is an error in the file");
        } catch (FitrException e) {
            Ui.printCustomError("Sorry, the duration has to be a positive number");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
