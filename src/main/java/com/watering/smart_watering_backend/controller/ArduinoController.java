package com.watering.smart_watering_backend.controller;

import com.watering.smart_watering_backend.dto.CommandDto;
import com.watering.smart_watering_backend.dto.SensorDataDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ArduinoController {

    @PostMapping("/data")
    public ResponseEntity<Void> receiveData(@RequestBody SensorDataDto data){
        // Here you can process the received data as needed
        System.out.println("Received data: " + data.getMoisture());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/command")
    public ResponseEntity<CommandDto> getCommand(){
        // Here you can determine the command to send back to the Arduino
        CommandDto command = new CommandDto();
        command.setAction("WATER_ON");
        return ResponseEntity.ok(command);
    }
}
