package chapter09.chainOfResponsability;

public class HeaderTextProcessor extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return "From me: " + input;
    }
}
