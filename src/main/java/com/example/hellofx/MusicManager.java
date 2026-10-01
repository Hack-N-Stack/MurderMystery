package com.example.hellofx;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicManager {

    private static MediaPlayer player;
    private static String currentTrack = "";

    public static void play(String fileName) {

        // --- If same music is already playing → DON'T restart it ---
        if (player != null && currentTrack.equals(fileName))
            return;

        // --- Stop previous if different track requested ---
        if (player != null)
            player.stop();

        // Load new music
        Media media = new Media(MusicManager.class.getResource("/sounds/" + fileName).toExternalForm());
        player = new MediaPlayer(media);

        currentTrack = fileName;

        player.setCycleCount(MediaPlayer.INDEFINITE); // loop
        player.setVolume(0.4);
        player.play();
    }

    public static void stop() {
        if (player != null) {
            player.stop();
        }
    }
}