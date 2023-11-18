public class Main {
    public static void main(String[] args) {
        Album album = new Album();
        Playlist playlist = new Playlist();
        Songs first = new Songs("Молния - Билан");
        Songs second = new Songs("Сдавайся - Лазарев");
        Songs third = new Songs("Пачка ***** - Лизер");

        album.addSongs(first);
        album.addSongs(third);
        playlist.addSongs(second);

        album.createAlbum();
        playlist.createPlaylist();
    }
}