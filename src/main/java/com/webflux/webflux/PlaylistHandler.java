package com.webflux.webflux;

import com.webflux.webflux.controller.PlaylistController;
import com.webflux.webflux.document.Playlist;
import com.webflux.webflux.services.PlaylistService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.created;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
@AllArgsConstructor
public class PlaylistHandler {

    private final PlaylistService playlistService;

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findAll(), Playlist.class);
    }

    public Mono<ServerResponse> events(ServerRequest serverRequest) {
        return ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(playlistService.getPlaylistByEvents(), Playlist.class);
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(playlistService.findById(id), Playlist.class);
    }

    public Mono<ServerResponse> save(ServerRequest serverRequest) {
        final Mono<Playlist> playlist = serverRequest.bodyToMono(Playlist.class);
        return created(serverRequest.uri())
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(playlist.flatMap(playlistService::save), Playlist.class));
    }
}
