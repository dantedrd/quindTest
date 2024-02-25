package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.TransferUseCase;
import co.com.quind.transfer.domain.models.Transfer;
import co.com.quind.transfer.infrastructure.entrypoints.model.GenericResponse;
import co.com.quind.transfer.infrastructure.entrypoints.model.TransferRequest;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transfer")
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {})
public class TransferController {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    private final TransferUseCase transferUseCase;

    /**
     * Creates an instance of {@code TransferController} with necessary useCase.
     *
     * @param transferUseCase Port for operation calculations.
     */
    public TransferController(TransferUseCase transferUseCase) {
        this.transferUseCase = transferUseCase;
    }


    @PostMapping
    public ResponseEntity<Object> proccesTransfer(@Valid @RequestBody TransferRequest transferRequest){
        Transfer responseTransfer=this.transferUseCase.proccess(transferRequest.toDomain());
        return ResponseEntity
                .status(HttpStatus.CREATED.value())
                .body(GenericResponse.of(HttpStatus.CREATED.value(),"transferencia creado correctamente",responseTransfer));
    }


}