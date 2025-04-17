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
        if (recipes.isEmpty()) {
            System.out.println("No recipes found.");
        } else {
            System.out.println("Available Recipes:");
            for (Recipe recipe : recipes) {
                System.out.println("- " + recipe.getName());
            }
        }
    }

    public void findRecipeByIngredient(String ingredient) {
        boolean found = false;
        System.out.println("Recipes with ingredient: " + ingredient);
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println("- " + recipe.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes found with the ingredient: " + ingredient);
        }
    }

    public void filterRecipesByCalories(int maxCalories) {
        boolean found = false;
        System.out.println("Recipes with calories less than or equal to " + maxCalories + ":");
        for (Recipe recipe : recipes) {
            if (recipe.getCalories() <= maxCalories) {
                System.out.println("- " + recipe.getName());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No recipes found with calories less than or equal to " + maxCalories);
        }
    }

    public void deleteRecipe(String name) {
        boolean removed = recipes.removeIf(recipe -> recipe.getName().equalsIgnoreCase(name));
        if (removed) {
            System.out.println("Recipe deleted: " + name);
        } else {
            System.out.println("No recipe found with the name: " + name);
        }
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void deleteRecipe(int index) {
        if (index >= 0 && index < recipes.size()) {
            Recipe removedRecipe = recipes.remove(index);
            System.out.println("Recipe deleted: " + removedRecipe.getName());
        } else {
            System.out.println("Invalid index. No recipe deleted.");
        }
    }
}