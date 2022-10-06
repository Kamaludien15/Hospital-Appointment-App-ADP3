package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.ContactTypeAPI;
import za.ac.cput.domain.ContactType;

import java.util.List;

@RestController
@RequestMapping("/hospital_appointment_management-db/ContactType")
@Slf4j
public class ContactTypeController {

    private ContactTypeAPI api;

    @Autowired public ContactTypeController(ContactTypeAPI api){this.api = api;}

    @PostMapping("save")
    public ResponseEntity<ContactType> save(@RequestBody ContactType contactType){
        log.info("Save request: {}", contactType);
        ContactType response = this.api.save(contactType);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{contact_type_id}")
    public ResponseEntity<ContactType> read(@PathVariable String id){
        log.info("Read request: {}", id);
        ContactType response = this.api.read(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "ContactType not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{contactType}")
    public ResponseEntity<Void> delete(@PathVariable ContactType contactType){
        log.info("Delete request: {}", contactType);
        this.api.delete(contactType);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<ContactType>> getAll(){
        List<ContactType> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }


}
