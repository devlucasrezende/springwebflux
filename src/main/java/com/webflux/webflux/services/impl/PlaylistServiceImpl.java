package com.webflux.webflux.services.impl;

import com.webflux.webflux.document.Playlist;
import com.webflux.webflux.repository.PlaylistRepository;
import com.webflux.webflux.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@Service
@AllArgsConstructor
public class PlaylistServiceImpl implements PlaylistService {

    private final PlaylistRepository playlistRepository;

    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    public Mono<Playlist> save(Playlist playlist) {
        return playlistRepository.save(playlist);
    }

    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
        Flux<Playlist> events = findAll();
        System.out.println("deu");
        return Flux.zip(interval, events);
    }
}
