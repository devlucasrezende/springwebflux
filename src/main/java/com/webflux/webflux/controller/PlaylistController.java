package com.webflux.webflux.controller;


import com.webflux.webflux.document.Playlist;
import com.webflux.webflux.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@AllArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @GetMapping("/findAll")
    public Flux<Playlist> findAll() {
        return playlistService.findAll();
    }

    @GetMapping("/findById/{id}")
    public Mono<Playlist> findById(@PathVariable String id) {
        return playlistService.findById(id);
    }

    @PostMapping("/save")
    public Mono<Playlist> save(@RequestBody Playlist playlist) {
        return playlistService.save(playlist);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Playlist>> getPlaylistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(3));
        Flux<Playlist> events = playlistService.findAll();
        System.out.println("deu");
        return Flux.zip(interval, events);
    }
}
