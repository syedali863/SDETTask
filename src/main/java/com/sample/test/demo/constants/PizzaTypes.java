package com.sample.test.demo.constants;


public enum PizzaTypes {
    SMALL_NOTOPPINGS("Small 6 Slices - no toppings"),
    SMALL_ONETOPPINGS("Small 6 Slices - 1 topping"),
    MEDIUM_TWOTOPPINGS("Medium 8 Slices - 2 toppings"),
    LARE_NOTOPPINGS("Large 10 Slices - no toppings"),
    LARGE_THREETOPPINGS("Large 10 Slices - 2 toppings");

    private String displayName;
    private double cost;

    private PizzaTypes(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getCost() {
        return cost;
    }

}
