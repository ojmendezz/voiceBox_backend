package eci.ieti.proyecto.voiceBox_backend.model;

import java.util.ArrayList;

public class Like{
    private long likeId;
    private long userId;
    private long audioId;

    public Like(long likeId, long userId, long audioId) {
        this.likeId = likeId;
        this.userId = userId;
        this.audioId = audioId;
    }

    public long getLikeId() {
        return likeId;
    }

    public void setLikeId(long likeId) {
        this.likeId = likeId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAudioId() {
        return audioId;
    }

    public void setAudioId(long audioId) {
        this.audioId = audioId;
    }
}