package fitr;

public class Food {
    protected String nameOfFood; // The name of the Food
    protected Calorie caloriesInFood;// Amount of calories consumed
    protected int amountOfFood = 1; // Amount of food in grams, if not it will be taken as arbritary unit e.g, 1 banana
    protected String createdDate; // Date the food entry was created

    public Food(String createdDate, String nameOfFood, Calorie calories, int amount) {
        this.createdDate = createdDate;
        this.nameOfFood = nameOfFood;
        this.amountOfFood = amount;
        this.caloriesInFood = new Calorie(calories.get() * amount);
    }

    public Food(String createdDate, String name, Calorie caloriesBurnt) {
        this.createdDate = createdDate;
        this.nameOfFood = name;
        this.caloriesInFood = caloriesBurnt;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public int getCalories() {
        return caloriesInFood.get();
    }

    public String getFoodName() {
        return nameOfFood;
    }

    public int getAmountOfFood() {
        return amountOfFood;
    }
}