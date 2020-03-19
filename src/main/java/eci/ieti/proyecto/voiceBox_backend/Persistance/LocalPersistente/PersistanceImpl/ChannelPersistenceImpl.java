package eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistanceImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.ChannelPersistence;
import eci.ieti.proyecto.voiceBox_backend.Persistance.LocalPersistente.PersistenceException;
import eci.ieti.proyecto.voiceBox_backend.model.AudioBook;
import eci.ieti.proyecto.voiceBox_backend.model.Channel;

@Service
public class ChannelPersistenceImpl implements ChannelPersistence {
    private final HashMap<String, Channel> channels = new HashMap<>();

    public ChannelPersistenceImpl(){
        Channel channel1 = new Channel("Tiburonsin");
        Channel channel2 = new Channel("Viajando en el tiempo");
        Channel channel3 = new Channel("Cocinando al oído");
        
        
    }

    @Override
    public Channel createChannel(Channel channel) throws PersistenceException {
        if (channels.containsKey(channel.getName())) {
            throw new PersistenceException("Ya existe un canal con el mismo nombre.");
        } else {
            channels.put(channel.getName(), channel);
        }
        return channel;
    }

    @Override
    public Channel updateChannel(Channel channel) throws PersistenceException {
        if (!channels.containsKey(channel.getName())) {
            throw new PersistenceException("No existe un canal con el mismo nombre.");
        } else {
            channels.replace(channel.getName(), channel);
        }
        return channel;
    }

    @Override
    public void addAudioBook(String channelName, AudioBook audiobook) throws PersistenceException{
        if (!existChannel(channelName)) {
            throw new PersistenceException("No existe un canal con el mismo nombre.");
        }else{
            Channel channel = channels.get(channelName);
            HashMap<String, AudioBook> audioBooks = channel.getAudioBooks();
            if (!audioBooks.containsKey(audiobook.getName())) {
                throw new PersistenceException("Ya hay un audiolibro con el mismo nombre.");
            }else{
                audioBooks.put(audiobook.getName(), audiobook);
            }
        }
    }

    @Override
    public List<AudioBook> getAudioBooksByChannelName(String channelName, AudioBook audioBook) throws PersistenceException{
        if (!existChannel(channelName)) {
            throw new PersistenceException("No existe un canal con el mismo nombre.");
        }else{
            Channel channel = channels.get(channelName);
            HashMap<String, AudioBook> audioBooks = channel.getAudioBooks();
            return (List<AudioBook>) audioBooks.values();
        }
    }

    @Override
    public void updateAudioBook(String channelName, AudioBook audioBook) throws PersistenceException {
        if (!channels.containsKey(channelName)) {
            throw new PersistenceException("No existe un canal con el mismo nombre.");
        }else{
            Channel channel = channels.get(channelName);
            HashMap<String, AudioBook> audioBooks = channel.getAudioBooks();
            if (!audioBooks.containsKey(audioBook.getName())) {
                throw new PersistenceException("No existe un audiolibro con el mismo nombre.");
            }else{
                audioBooks.replace(audioBook.getName(), audioBook);
            }
        }
    }

    @Override
    public void removeAudioBook(String channelName, String audioBookName) throws PersistenceException {
        if (!channels.containsKey(channelName)) {
            throw new PersistenceException("No existe un canal con el mismo nombre.");
        }else{
            Channel channel = channels.get(channelName);
            HashMap<String, AudioBook> audioBooks = channel.getAudioBooks();
            if (!audioBooks.containsKey(audioBookName)) {
                throw new PersistenceException("No existe un audiolibro con el mismo nombre.");
            }else{
                audioBooks.remove(audioBookName);
            }
        }
    }

    public boolean existChannel(String channelName) throws PersistenceException {
        boolean exist = false;
        if (!channels.containsKey(channelName)) {
            exist = true;
        }
        return exist;
    }

    public boolean existAudioBookBForchannelName(String channelName, String audioBookName) throws PersistenceException {
        boolean exist = false;
        Channel channel = channels.get(channelName);
        HashMap<String, AudioBook> audioBooks = channel.getAudioBooks();
        if (audioBooks.containsKey(audioBookName)) {
            exist = true;
        }
        return exist;
    }
}