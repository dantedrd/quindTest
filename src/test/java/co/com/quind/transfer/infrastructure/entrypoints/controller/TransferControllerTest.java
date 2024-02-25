package co.com.quind.transfer.infrastructure.entrypoints.controller;

import co.com.quind.transfer.application.usecase.TransferUseCase;
import co.com.quind.transfer.domain.constants.TypeTransfer;
import co.com.quind.transfer.domain.models.Transfer;
import co.com.quind.transfer.infrastructure.entrypoints.model.TransferRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class TransferControllerTest {
    @Mock
    TransferUseCase transferUseCase;
    @InjectMocks
    TransferController transferController;

    @BeforeEach
    public void init(){
        this.transferController=new TransferController(transferUseCase);
    }

    @Test
    public void shouldCreatedTransfer(){
        TransferRequest transferRequest=TransferRequest
                .builder()
                .amount(3443.0)
                .typeTransfer(TypeTransfer.MOVEMENT.getTypeTransfer())
                .accountId("43254")
                .accountReceptorId("344543")
                .build();
        Transfer transfer=new Transfer();

        Mockito.when(this.transferUseCase.proccess(Mockito.any(Transfer.class))).thenReturn(transfer);

        ResponseEntity<Object> result=this.transferController.proccesTransfer(transferRequest);

        assertNotNull(result);
    }


}