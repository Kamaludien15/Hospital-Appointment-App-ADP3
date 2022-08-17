/* AddressController.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.api.AppointmentAPI;
import za.ac.cput.domain.Appointment;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/hospital_appointment_management-db/appointment")
@Slf4j
public class AppointmentController {

    private AppointmentAPI api;

    @Autowired public AppointmentController(AppointmentAPI api) {
        this.api = api;
    }

    @PostMapping("save")
    public ResponseEntity<Appointment> save(@Valid @RequestBody Appointment appointment){
        log.info("Save request: {}", appointment);
        Appointment response = this.api.save(appointment);
        return ResponseEntity.ok(response);
    }

    @GetMapping("read/{appointment_id}")
    public ResponseEntity<Appointment> read(@PathVariable String id){
        log.info("Read request: {}", id);
        Appointment response = this.api.read(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Appointment not found"));
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("delete/{appointment}")
    public ResponseEntity<Void> delete(@PathVariable Appointment appointment){
        log.info("Delete request: {}", appointment);
        this.api.delete(appointment);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("all")
    public ResponseEntity<List<Appointment>> getAll(){
        List<Appointment> response = this.api.getAll();
        return ResponseEntity.ok(response);
    }
}
