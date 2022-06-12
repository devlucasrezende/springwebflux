package com.webflux.webflux;

import com.webflux.webflux.document.Playlist;
import com.webflux.webflux.repository.PlaylistRepository;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

//@Component
//@AllArgsConstructor
//@Log4j2
//public class DummyData implements CommandLineRunner {
//
//    private final PlaylistRepository playlistRepository;
//
//    @Override
//    public void run(String... args) {
//
//    	playlistRepository.deleteAll()
//                .thenMany(
//                        Flux.just("Metallica", "Alice in Chains", "Iron Maiden",
//                                "Judas Priest", "Megadeth", "Shaman", "Tenacious D")
//                                .map(nome -> new Playlist(UUID.randomUUID().toString(), nome))
//                                .flatMap(playlistRepository::save))
//                .subscribe(System.out::println);
//    }
//}
