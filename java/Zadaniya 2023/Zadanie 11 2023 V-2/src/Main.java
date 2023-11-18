public class Main {
    public static void main(String[] args) {
        Document document = new Document("Курсовая", "В реализации");
        System.out.println(document);
        Document documentClone = document.copy();
        documentClone.setName("Курсовая - копия");
        System.out.println("-----------------\n"+ documentClone);

    }
}