package chapter09.chainOfResponsability;

public class SpellCheckProcessor extends ProcessingObject<String>{
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}
