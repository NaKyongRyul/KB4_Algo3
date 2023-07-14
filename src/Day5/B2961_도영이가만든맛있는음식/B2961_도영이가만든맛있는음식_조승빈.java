package Day5.B2961_도영이가만든맛있는음식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B2961_도영이가만든맛있는음식_조승빈 {
    static int N;
    static int minDifference = Integer.MAX_VALUE;

    static List<Ingredient> ingredients;
    static List<Integer> selectedIngredients;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ingredients = new ArrayList<>();
        selectedIngredients = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sour = Integer.parseInt(st.nextToken());
            int bitter = Integer.parseInt(st.nextToken());
            ingredients.add(new Ingredient(sour, bitter));
        }

        combination(0);
        System.out.println(minDifference);
    }

    private static void combination(int idx) {
        if (idx == N) {
            if (selectedIngredients.size() > 0) {

                int selectedSour = 1;
                int selectedBitter = 0;

                for (int ingredientIdx : selectedIngredients) {
                    Ingredient ingredient = ingredients.get(ingredientIdx);
                    selectedSour *= ingredient.sourTaste;
                    selectedBitter += ingredient.bitterTaste;
                }

                int difference = Math.abs(selectedSour - selectedBitter);
                minDifference = Math.min(minDifference, difference);
            }
            return;
        }

        selectedIngredients.add(idx);
        combination(idx + 1);
        selectedIngredients.remove(selectedIngredients.size() - 1);
        combination(idx + 1);
    }
}

class Ingredient {
    int sourTaste;
    int bitterTaste;

    public Ingredient(int sourTaste, int bitterTaste) {
        this.sourTaste = sourTaste;
        this.bitterTaste = bitterTaste;
    }
}

