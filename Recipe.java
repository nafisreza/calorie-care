import java.util.List;

public class Recipe {
    private String name;
    private List<String> ingredients;
    private int calories;

    public Recipe(String name, List<String> ingredients, int calories) {
        this.name = name;
        this.ingredients = ingredients;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public int getCalories() {
        return calories;
    }

    public void displayRecipe() {
        System.out.println("Recipe: " + name);
        System.out.println("Ingredients: " + String.join(", ", ingredients));
        System.out.println("Calories: " + calories);
    }
}