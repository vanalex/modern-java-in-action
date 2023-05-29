package java18;

public class Stringify {

 /* public String convertoToString(Object value) {
    return switch (value) {
      // the constant must be before the guarded pattern (otherwise it will never hit)
      case Integer i && i == 42 -> "42 is the answer";
      case Integer i && i > 0 -> "positive number";
      case Integer i && i < 0 -> "negative number";
      // this must be after because it will match all integers
      case Integer i -> "should be 0";

      case String s && s.isEmpty() -> "empty string";
      case String s && s.length() > 50 -> "long string";
      // this must be after because it will match all strings
      case String s -> "non-empty string";
      // same here
      case CharSequence cs -> "any other CharSequence";

      case null -> "null =s";
      default -> "unhandled type";
    };
  }*/
}
