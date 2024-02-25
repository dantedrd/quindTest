package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.CreateClientUseCase;
import co.com.quind.transfer.domain.models.Client;
import co.com.quind.transfer.infrastructure.entrypoints.model.ClientRequest;
import co.com.quind.transfer.infrastructure.entrypoints.model.GenericResponse;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final CreateClientUseCase createClientUseCase;

    /**
     * Creates an instance of {@code ClientController} with necessary useCase.
     *
     * @param createClientUseCase Port for operation calculations.
     */
    public ClientController(CreateClientUseCase createClientUseCase) {
        this.createClientUseCase = createClientUseCase;
    }


    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody ClientRequest client){
        Client responseClient=this.createClientUseCase.createClient(client.toDomain());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"Cliente creado correctamente",responseClient));
    }

    @DeleteMapping("/{nit}")
    public ResponseEntity<Object> deleteClient(@PathVariable String nit){
        this.createClientUseCase.deleteClient(nit);
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"Eliminado correctamente",null));
    }

}
