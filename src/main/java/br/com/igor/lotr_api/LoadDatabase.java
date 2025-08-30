package br.com.igor.lotr_api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(WarriorRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Warrior("Bilbo Bolseiro", "burglar")));
            log.info("Preloading " + repository.save(new Warrior("Frodo Bolseiro", "thief")));
            log.info("Preloading " + repository.save(new Warrior("Gandalf", "wizard")));
            log.info("Preloading " + repository.save(new Warrior("Aragorn", "ranger")));
            log.info("Preloading " + repository.save(new Warrior("Legolas", "archer")));
            log.info("Preloading " + repository.save(new Warrior("Gimli", "warrior")));
            log.info("Preloading " + repository.save(new Warrior("Boromir", "soldier")));
            log.info("Preloading " + repository.save(new Warrior("Samwise Gamgi", "gardener")));
            log.info("Preloading " + repository.save(new Warrior("Meriadoc Brandebuque", "knight")));
            log.info("Preloading " + repository.save(new Warrior("Peregrin Tûk", "squire")));
            log.info("Preloading " + repository.save(new Warrior("Sauron", "dark lord")));
            log.info("Preloading " + repository.save(new Warrior("Saruman", "white wizard")));
            log.info("Preloading " + repository.save(new Warrior("Gollum", "creature")));
        };
    }
}
