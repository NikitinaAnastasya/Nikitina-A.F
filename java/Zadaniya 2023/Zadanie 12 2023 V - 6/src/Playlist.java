import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Songs> playlist = new ArrayList<>();
    public void addSongs(Songs songs){
        playlist.add(songs);

    }
    public void  createPlaylist(){
        System.out.println("Плейлист:\n");
        for (Songs pl :
                playlist) {
            System.out.println(pl);
        }
    }
}
