package br.com.igor.lotr_api;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class WarriorController {

    private final WarriorRepository repository;

    WarriorController(WarriorRepository repository) {
        this.repository = repository;
    }


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/warriors")
    List<Warrior> all() {
        return repository.findAll();
    }
    // end::get-aggregate-root[]

    @PostMapping("/warriors")
    Warrior newEmployee(@RequestBody Warrior newWarrior) {
        return repository.save(newWarrior);
    }

    // Single item

    @GetMapping("/warrior/{id}")
    Warrior one(@PathVariable Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new WarriorNotFoundException(id));
    }

    @PutMapping("/warrior/{id}")
    Warrior replaceWarrior(@RequestBody Warrior newWarrior, @PathVariable Long id) {

        return repository.findById(id)
                .map(warrior -> {
                    warrior.setName(newWarrior.getName());
                    warrior.setRole(newWarrior.getRole());
                    return repository.save(warrior);
                })
                .orElseGet(() -> {
                    return repository.save(newWarrior);
                });
    }

    @DeleteMapping("/warrior/{id}")
    void deleteEmployee(@PathVariable Long id) {
        repository.deleteById(id);
    }
}