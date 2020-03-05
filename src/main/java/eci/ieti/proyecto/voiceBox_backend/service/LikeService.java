package eci.ieti.proyecto.voiceBox_backend.service;

import java.util.List;

import eci.ieti.proyecto.voiceBox_backend.model.User;

public interface LikeService {
    long getByAudioId();

    void addLikeToAudio(long audioBookId, long userId);

    void deleteLikeOfAudio(long audioLike, long userId);
}