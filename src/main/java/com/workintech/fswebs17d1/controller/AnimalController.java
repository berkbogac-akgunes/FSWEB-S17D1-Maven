package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AnimalController {
    private Map<Integer, Animal> animals;

    @PostConstruct
    public void loadAll() {
        animals = new HashMap<>();
    }

    @GetMapping("/workintech/animal")
    public List<Animal> getAnimals() {
        return animals.values().stream().toList();
    }

    @GetMapping("/workintech/animal/{id}")
    public Animal getAnimalById(@PathVariable Integer id) {
        if (id < 0) {
            System.out.println("id cannot be lower than 0");
            return null;
        }
        return animals.get(id);
    }
    @PostMapping("/workintech/animal")
    public Animal addAnimal(@RequestBody Animal animal) {
            return animals.put(animal.getId(), animal);
    }

    @PutMapping("/workintech/animal/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal animal) {
        return animals.replace(id, animal);
    }

    @DeleteMapping("/workintech/animal/{id}")
    public Animal deleteAnimal(@PathVariable Integer id) {
        return animals.remove(id);
    }
}
