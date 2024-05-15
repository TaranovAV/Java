package ru.sgu.singletonExample;

//музыкальный плеер - имеет один кэш, куда музыка попадает при прослушивании в первый раз
public class MusicPlayer {
    private final Cache cache = Cache.INSTANCE;

    private void playTrack(Track track) {
        System.out.println("Играет песня " + track.getName());
        cache.addTrack(track);
    }

    public static void main(String[] args) {
        Track song1 = new Track("Hail and Kill | Manowar");
        Track song2 = new Track("Under The Gun | Deep Purple");

        MusicPlayer player = new MusicPlayer();
        player.playTrack(song1);
        player.playTrack(song2);
    }
}
