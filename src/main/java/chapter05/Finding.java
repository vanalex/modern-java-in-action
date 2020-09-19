package chapter05;

import chapter04.Dish;

import java.util.Optional;

import static chapter04.Dish.menu;

public class Finding {
  public static void main(String[] args) {
    System.out.println(isVegetarianFriendlyMenu() ? "Yes it is vegetarian friendly" : "No, it is not vegetarian friendly");
      System.out.println(isHealthyMenu());
      System.out.println(isHealthyMenu2());

      Optional<Dish> dish = findVegetarianDish();
      dish.ifPresent(d -> System.out.println(d.getName()));
  }

  private static boolean isVegetarianFriendlyMenu(){ return menu.stream().anyMatch(Dish::isVegetarian); }

  private static boolean isHealthyMenu() {
        return menu.stream().allMatch(d -> d.getCalories() < 1000);
    }
    private static boolean isHealthyMenu2() {
        return menu.stream().noneMatch(d -> d.getCalories() >= 1000);
    }
    private static Optional<Dish> findVegetarianDish() {
        return menu.stream().filter(Dish::isVegetarian).findAny();
    }

}
