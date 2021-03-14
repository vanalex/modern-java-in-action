package java15;

public class TextBlock {

    private static final String html = "<html>\n" +
            "   <body>\n" +
            "      <p>Hello, World</p>\n" +
            "   </body>\n" +
            "</html>\n";

    private static final String java15 = """
                  <html>
                      <body>
                          <p>Hello, World</p>
                      </body>
                  </html>
                  """;

    public static void main(String[] args) {
        System.out.println(html);
        System.out.println(java15);
    }
}
