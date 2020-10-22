package fitr;

public class Exercise {
    protected String nameOfExercise; // The name of the Exercise
    protected Calorie caloriesBurnt;// Amount of calories burnt from exercise
    protected String createdDate; // Date the exercise entry was created

    public Exercise(String createdDate, String name, Calorie caloriesBurnt) {
        this.createdDate = createdDate;
        this.nameOfExercise = name;
        this.caloriesBurnt = caloriesBurnt;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public int getCalories() {
        return caloriesBurnt.get();
    }

    public String getNameOfExercise() {
        return nameOfExercise;
    }

}
