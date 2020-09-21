public class Main {
    public static void main(String[] args) {
        new Download().downloadFileByUrlAndFile(
                "http://dicasdejava.com.br/images/logo-java.png",
                "C:\\temp\\arquivo-baixado.png");
    }
}
