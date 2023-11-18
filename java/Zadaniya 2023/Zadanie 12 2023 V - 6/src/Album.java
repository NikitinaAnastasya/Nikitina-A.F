import java.util.ArrayList;
import java.util.List;

public class Album {
    private List<Songs> album = new ArrayList<>();
    public void addSongs(Songs songs){
        album.add(songs);

    }
    public void  createAlbum(){
        System.out.println("Альбом:\n");
        for (Songs al :
                album) {
            System.out.println(al);
        }
    }
}

