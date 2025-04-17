import java.util.ArrayList;
import java.util.List;

public class CalorieCare {
    private List<Recipe> recipes;

    public CalorieCare() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
        System.out.println("Recipe added: " + recipe.getName());
    }

    public void listRecipes() {
        System.out.println("Available Recipes:");
        for (Recipe recipe : recipes) {
            System.out.println("- " + recipe.getName());
        }
    }

    public void findRecipeByIngredient(String ingredient) {
        System.out.println("Recipes with ingredient: " + ingredient);
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println("- " + recipe.getName());
            }
        }
    }

    public void filterRecipesByCalories(int maxCalories) {
        System.out.println("Recipes with calories less than or equal to " + maxCalories + ":");
        for (Recipe recipe : recipes) {
            if (recipe.getCalories() <= maxCalories) {
                System.out.println("- " + recipe.getName());
            }
        }
    }

    public void deleteRecipe(String name) {
        recipes.removeIf(recipe -> recipe.getName().equalsIgnoreCase(name));
        System.out.println("Recipe deleted: " + name);
    }
}