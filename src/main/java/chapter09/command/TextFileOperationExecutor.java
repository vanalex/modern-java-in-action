package chapter09.command;

import java.util.ArrayList;
import java.util.List;

public class TextFileOperationExecutor {

    private final List<TextFileOperation> textFileOperations = new ArrayList<>();

    public List<TextFileOperation> getTextFileOperations() {
        return textFileOperations;
    }

    public String executeOperation(TextFileOperation textFileOperation) {
        textFileOperations.add(textFileOperation);
        return textFileOperation.execute();
    }

    public static void main(String[] args) {
        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();
        textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt");
        textFileOperationExecutor.executeOperation(() -> "Saving file file1.txt");
        textFileOperationExecutor.getTextFileOperations().stream().forEach(textFileOperation -> System.out.println(textFileOperation.execute()));

    }
}
