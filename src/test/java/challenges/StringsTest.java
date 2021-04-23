package challenges;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class StringsTest {

    private static final String TEXT = "Be strong, be fearless, be beautiful. "
            + "And believe that anything is possible when you have the right "
            + "people there to support you. ";
    // Ӝ -> Unicode: \u04DC, Code Point: 1244
    // 💕 -> Unicode: \uD83D\uDC95, Code Point: 128149
    // 🎼 -> \uD83C\uDFBC, Code Point: 127932
    // 😍 ->\uD83D\uDE0D, Code Point: 128525
    private static final String TEXT_CP = TEXT + "😍 I love 💕 you Ӝ so much 💕 😍 🎼🎼🎼!";


    @Test
    void testCountingChars(){
        Map<String, Long> result = Strings.countDuplicateCharacters(TEXT);
        assertThat(result.get("a")).isEqualTo(5);
    }

    @Test
    void testFirstNonRepeatableChar(){

        String text = "My high school, the Illinois Mathematics and Science Academy, "
                + "showed me that anything is possible and that you're never too young to think big. "
                + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
                + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
                + "computer science.";

        String result = Strings.firstNonRepeatedCharacter(text);
        assertThat(result).isEqualTo("'");
    }

    @Test
    void testReverse(){

        String text = "My high school, the Illinois Mathematics and Science Academy, "
                + "showed me that anything is possible and that you're never too young to think big. "
                + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
                + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
                + "computer science.";

        String result = Strings.reverse(text);
        assertThat(result).isEqualTo(".ecneics retupmoc dna scimonoce ni eerged a rof drofnatS dednetta I ,gnitaudarg retfA .balimreF ro ,yrotarobaL rotareleccA lanoitaN imreF eht ta remmargorp retupmoc a sa dekrow I ,51 tA .gib kniht ot gnuoy oot reven er'uoy taht dna elbissop si gnihtyna taht em dewohs ,ymedacA ecneicS dna scitamehtaM sionillI eht ,loohcs hgih yM");
    }
}
