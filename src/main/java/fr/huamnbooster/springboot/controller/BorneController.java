package fr.huamnbooster.springboot.controller;

import fr.huamnbooster.springboot.model.Borne;
import fr.huamnbooster.springboot.model.Reservation;
import fr.huamnbooster.springboot.service.BorneService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/bornes")
public class BorneController {
    private final BorneService borneService;

    @GetMapping
    public List<Borne> getAllBornes() {
        return borneService.findBorneAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borne> getBorneById(@PathVariable Long id, @RequestBody Borne borne) {
        return borneService.findBorneById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public Borne createBorne(@RequestBody Borne borne) {
        return borneService.createBorne(borne);
    }

    @PutMapping("/{id}")
    public Borne updateBorne(@PathVariable Long id, @RequestBody Borne borne) {
        return borneService.updateBorne(id, borne);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        borneService.deleteBorne(id);
        return ResponseEntity.ok().build();
    }


}
