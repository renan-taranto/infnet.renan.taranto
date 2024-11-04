package br.edu.infnet.renan.taranto.adapter.loader;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AppDataLoader implements ApplicationRunner {
    private final List<EntityLoader> entityLoaders;

    public AppDataLoader(List<EntityLoader> entityLoaders) {
        this.entityLoaders = entityLoaders;
    }

    @Override
    public void run(ApplicationArguments args) {
        for (EntityLoader entityLoader : entityLoaders) {
            entityLoader.load();
        }
    }
}
