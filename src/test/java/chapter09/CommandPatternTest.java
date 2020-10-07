package chapter09;

import chapter09.command.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CommandPatternTest {

    @Test
    public void testCommandPattern(){

        TextFileOperationExecutor textFileOperationExecutor
                = new TextFileOperationExecutor();
        String result = textFileOperationExecutor.executeOperation(() -> "Opening file file1.txt");
        assertThat(result).isEqualTo("Opening file file1.txt");
        result = textFileOperationExecutor.executeOperation(() -> "Saving file file1.txt");
        assertThat(result).isEqualTo("Saving file file1.txt");
    }
}
