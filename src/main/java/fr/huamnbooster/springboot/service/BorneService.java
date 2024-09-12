package fr.huamnbooster.springboot.service;

import fr.huamnbooster.springboot.model.Borne;
import fr.huamnbooster.springboot.repository.BorneRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BorneService {
    private final BorneRepository borneRepository;

    public List<Borne> findBorneAll() {
        return borneRepository.findAll();
    }

    public Optional<Borne> findBorneById(Long id) {
        return borneRepository.findById(id);
    }

    public Borne createBorne(Borne borne) {
        return borneRepository.save(borne);
    }

    public Borne updateBorne(Long id, Borne borne) {
        Borne existingBorne = borneRepository.findById(id).orElse(null);
        if (existingBorne != null) {
            borne.setId(existingBorne.getId());
            return borneRepository.save(borne);
        } else {
            return null;
        }
    }

    public void deleteBorne(Long id) {
        borneRepository.deleteById(id);
    }

}
