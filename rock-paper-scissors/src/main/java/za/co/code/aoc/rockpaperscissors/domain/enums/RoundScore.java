package za.co.code.aoc.rockpaperscissors.domain.enums;

public enum RoundScore {
    W("WIN", 6),
    D("DRAW", 3),
    L("LOSE", 0);

    private String desc;
    private int weight;

    RoundScore(String desc, int weight) {
        this.desc = desc;
        this.weight = weight;
    }

    public String getDescription() {
        return this.desc;
    }

    public int getWeight() {
        return this.weight;
    }
}
