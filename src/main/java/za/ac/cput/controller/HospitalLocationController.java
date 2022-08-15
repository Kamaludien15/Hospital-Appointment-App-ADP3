/* AddressController.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.HospitalLocationAPI;
import za.ac.cput.domain.HospitalLocation;


import java.util.List;


@RestController
@RequestMapping("/hospital_appointment_management-db/hospitalLocation")
public class HospitalLocationController {

    private HospitalLocationAPI api;

    @Autowired public HospitalLocationController(HospitalLocationAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<HospitalLocation> save(@Valid @RequestBody HospitalLocation hospitalLocation){
        log.info("Save request: {}", hospitalLocation);
        HospitalLocation response = this.api.save(hospitalLocation);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{hospital_location_id}")
    public ResponseEntity<HospitalLocation> read(@PathVariable String id){
        log.info("Read request: {}", id);
        HospitalLocation response = this.api.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Hospital Location not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{hospitalLocation}")
    public ResponseEntity<Void> delete(@PathVariable HospitalLocation hospitalLocation){
        log.info("Delete request: {}", hospitalLocation);
        this.api.delete(hospitalLocation);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<HospitalLocation>> getAll(){
        List<HospitalLocation> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
