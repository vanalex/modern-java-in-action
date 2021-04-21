package streams;

public class PalindromeEvaluator {
    public boolean isPalindrome(String s) {
        String forward = s.toLowerCase().codePoints()
                // .parallel() // whoa. Not worth it, though -- below minimum threshold
                .filter(Character::isLetterOrDigit)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        String backward = new StringBuilder(forward).reverse().toString();
        return forward.equals(backward);
    }
}
