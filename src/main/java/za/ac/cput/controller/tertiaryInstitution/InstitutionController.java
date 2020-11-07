package za.ac.cput.controller.tertiaryInstitution;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.tertiaryInstitution.Institution;
import za.ac.cput.factory.tertiaryInstitution.InstitutionFactory;
import za.ac.cput.service.tertiaryInstitution.impl.InstitutionServiceImpl;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/applicationassistant/institution")

public class InstitutionController {

    @Autowired
    private InstitutionServiceImpl institutionService;

    @PostMapping("/create")
    public Institution create(@RequestBody Institution institution) {
        Institution newInstitution = InstitutionFactory.createInstitution(institution.getInstitutionName(), institution.getInstitutionCode());
        return institutionService.create(newInstitution);
    }

    @GetMapping("/allwith/{letter}")
    public Set<Institution> getAllStartingWith(@PathVariable String letter) { return institutionService.getAllStartingWith(letter); }

    @GetMapping("/read/{institutionId}")
    public Institution read(@PathVariable String institutionId) { return institutionService.read(institutionId); }

    @PostMapping("/update")
    public Institution update(@RequestBody Institution institution) { return institutionService.update(institution); }

    @GetMapping("/all")
    public Set<Institution> getAll() { return institutionService.getAll(); }

    @DeleteMapping("/delete/{institutionId}")
    public boolean delete(@PathVariable String institutionId) { return institutionService.delete(institutionId); }
}
