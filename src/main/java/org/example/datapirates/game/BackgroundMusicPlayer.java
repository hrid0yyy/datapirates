package org.example.datapirates.game;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class BackgroundMusicPlayer {
    private static BackgroundMusicPlayer instance;
    private MediaPlayer mediaPlayer;
    private String currentMusicFilePath;

    private BackgroundMusicPlayer() {
        // Private constructor to prevent instantiation from outside
    }

    public static BackgroundMusicPlayer getInstance() {
        if (instance == null) {
            instance = new BackgroundMusicPlayer();
        }
        return instance;
    }

    public void playMusic(String musicFilePath) {
        // Check if the requested music file is different from the currently playing music
        if (!musicFilePath.equals(currentMusicFilePath)) {
            // Stop the currently playing music, if any
            stopMusic();

            // Load and play the new music
            Media media = new Media(getClass().getResource(musicFilePath).toExternalForm());
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
            mediaPlayer.play();
            currentMusicFilePath = musicFilePath;
        }
    }

    public void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            mediaPlayer.dispose();
            mediaPlayer = null;
            currentMusicFilePath = null;
        }
    }
}
