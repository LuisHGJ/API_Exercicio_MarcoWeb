package app.sensores;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/sensores")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping
    public Iterable<SensorDTO> list() {
        return sensorService.findAll();
    }

    @GetMapping("/{id}")
    public SensorDTO getOne(@PathVariable long id) {
        return sensorService.findOne(id);
    }

    @PostMapping
    public SensorDTO insert(@RequestBody SensorInsertDTO novosensor) {
        return sensorService.insert(novosensor);
    }

    @PutMapping("/{id}")
    public SensorDTO update(@PathVariable long id, @RequestBody SensorInsertDTO modif){
        return sensorService.update(id, modif);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        sensorService.delete(id);
    }
}