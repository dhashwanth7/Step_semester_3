package string.assigment_problems;

public class Playlist {

    private final String[] songs;
    private int songCount;

    public Playlist(int maxSongs) {
        if (maxSongs <= 0) {
            throw new IllegalArgumentException(
                "Maximum songs must be positive."
            );
        }

        songs = new String[maxSongs];
        songCount = 0;
    }

    public void addSong(String song) {
        if (song == null || song.trim().isEmpty()) {
            System.out.println("Invalid song title.");
            return;
        }

        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        } else {
            System.out.println("Playlist is full.");
        }
    }

    public String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int getSongCount() {
        return songCount;
    }
}