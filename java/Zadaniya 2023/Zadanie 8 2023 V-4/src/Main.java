public class Main {
    public static void main(String[] args) throws InterruptedException {
        Draving draving = new Draving();
        GitHubRepo gitHubRepo = new GitHubRepo();

        draving.setDravingAndDate("Полный рисунок");
        System.out.println(draving);
        gitHubRepo.setSave(draving.save());

        Thread.sleep(5000);

        draving.setDravingAndDate("Рисунок стерт наполовину");
        System.out.println(draving);
        draving.load(gitHubRepo.getSave());
        System.out.println(draving);
    }
}