package app.sensores;

import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class SensorService {
    @Autowired
    private SensorRepository sensorRepo;

    public Iterable<SensorDTO> findAll(){
        return sensorRepo.findAll().stream().map(SensorDTO::new).toList();
    }

    public SensorDTO findOne(long id) {
        Optional<Sensor> resultado = sensorRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }

        return new SensorDTO(resultado.get());
    }

    public SensorDTO insert(SensorInsertDTO dados) {
        Sensor Sensor = new Sensor();
        Sensor.setUnidade(dados.unidade());
        Sensor.setValor(dados.valor());
        Sensor.setLocal(dados.local());
    
        return new SensorDTO(sensorRepo.save(Sensor));
    }

    public SensorDTO update(long id, SensorInsertDTO dados) {
        Optional<Sensor> resultado = sensorRepo.findById(id);

        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }

        resultado.get().setUnidade(dados.unidade());
        return new SensorDTO(sensorRepo.save(resultado.get()));
    }

    public void delete(long id) {
        if(!sensorRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Sensor não encontrado"
            );
        }
        sensorRepo.deleteById(id);
    }
}