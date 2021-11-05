package challenges.model;

public record Melon(String type, int weight, String origin) {

    public String getType() {
        return type;
    }

    public int getWeight() {
        return weight;
    }

    public String getOrigin() {
        return origin;
    }

    @Override
    public String toString() {
        return type + "(" + weight + "g, " + origin + ")";
    }
}
