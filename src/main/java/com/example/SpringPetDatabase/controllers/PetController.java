package com.example.SpringPetDatabase.controllers;

import com.example.SpringPetDatabase.entities.Pet;
import com.example.SpringPetDatabase.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetService petService;

    // Get all pets
    @GetMapping
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    // Get a single pet by ID
    @GetMapping("/{id}")
    public ResponseEntity<Pet> getPetById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    // Create a new pet
    @PostMapping
    public ResponseEntity<Pet> createPet(@RequestBody Pet pet) {
        return ResponseEntity.ok(petService.createPet(pet));
    }

    // Change a pet's name
    @PatchMapping("/{id}")
    public ResponseEntity<Pet> updatePetName(@PathVariable Long id, @RequestParam String name) {
        Pet updatedPet = petService.updatePetName(id, name);
        return ResponseEntity.ok(updatedPet);
    }

    // Delete a pet
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deletePetById(id);
        return ResponseEntity.noContent().build();
    }
}