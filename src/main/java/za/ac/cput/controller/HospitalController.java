/* AddressController.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.HospitalAPI;
import za.ac.cput.domain.Hospital;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/hospital_appointment_management-db/hospital")
@Log4j2
public class HospitalController {

    private HospitalAPI api;

    @Autowired public HospitalController(HospitalAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Hospital> save(@Valid @RequestBody Hospital hospital){
        log.info("Save request: {}", hospital);
        Hospital response = this.api.save(hospital);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{hospital_id}")
    public ResponseEntity<Hospital> read(@PathVariable String hospital_id){
        log.info("Read request: {}", hospital_id);
        Hospital response = this.api.read(hospital_id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{hospital}")
    public ResponseEntity<Void> delete(@PathVariable Hospital hospital){
        log.info("Delete request: {}", hospital);
        this.api.delete(hospital);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Hospital>> getAll(){
        List<Hospital> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
