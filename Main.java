import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to CalorieCare!");
        CalorieCare app = new CalorieCare();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Add a recipe");
            System.out.println("2. View all recipes");
            System.out.println("3. Find recipes by ingredient");
            System.out.println("4. Filter recipes by calories");
            System.out.println("5. Delete a recipe");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter recipe name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter ingredients (comma-separated):");
                    String ingredientsInput = scanner.nextLine();
                    System.out.println("Enter calories:");
                    int calories = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    app.addRecipe(new Recipe(name, Arrays.asList(ingredientsInput.split(",")), calories));
                    break;

                case 2:
                    if (app.getRecipes().isEmpty()) {
                        System.out.println("No recipes available.");
                        break;
                    }

                    System.out.println("Select a recipe to view details:");
                    for (int i = 0; i < app.getRecipes().size(); i++) {
                        System.out.println((i + 1) + ". " + app.getRecipes().get(i).getName());
                    }

                    int recipeDetailIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    app.viewRecipeDetails(recipeDetailIndex);
                    break;

                case 3:
                    System.out.println("Enter ingredient to search for:");
                    String ingredient = scanner.nextLine();
                    app.findRecipeByIngredient(ingredient);
                    break;

                case 4:
                    System.out.println("Enter maximum calories:");
                    int maxCalories = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    app.filterRecipesByCalories(maxCalories);
                    break;

                case 5:
                    if (app.getRecipes().isEmpty()) {
                        System.out.println("No recipes available to delete.");
                        break;
                    }

                    System.out.println("Select a recipe to delete:");
                    for (int i = 0; i < app.getRecipes().size(); i++) {
                        System.out.println((i + 1) + ". " + app.getRecipes().get(i).getName());
                    }

                    int recipeIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline

                    if (recipeIndex >= 0 && recipeIndex < app.getRecipes().size()) {
                        String deletedRecipeName = app.getRecipes().get(recipeIndex).getName();
                        app.deleteRecipe(deletedRecipeName);
                    } else {
                        System.out.println("Invalid selection. No recipe deleted.");
                    }
                    break;

                case 6:
                    System.out.println("Thank you for using 'Savour the Flavours of Health'! Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}