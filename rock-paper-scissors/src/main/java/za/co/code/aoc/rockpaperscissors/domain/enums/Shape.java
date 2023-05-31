package za.co.code.aoc.rockpaperscissors.domain.enums;

public enum Shape {
    R("ROCK", 1),
    P("PAPER", 2),
    S("SCISSORS", 3);

    private String shapeName;
    private int weight;

    Shape(String shapeName, int weight) {
        this.shapeName = shapeName;
        this.weight = weight;
    }

    public String getShapeName() {
        return this.shapeName;
    }

    public int getWeight() {
        return this.weight;
    }
}
