package co.com.quind.transfer.application.usecase;

import co.com.quind.transfer.application.port.out.ClientRepository;
import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.config.exception.SPError;
import co.com.quind.transfer.domain.models.Client;
import co.com.quind.transfer.domain.service.ClientService;

import java.time.LocalDateTime;
import java.util.Optional;

import static co.com.quind.transfer.config.exception.SPError.INVALID_USER_NOT_EXIST;

public class CreateClientUseCase {
    ClientService clientService;
    ClientRepository clientRepository;

    /**
     * Constructs a new instance of {@code CreateClientUseCase} with the given storage repository and service
     * @param repository The storage repository used for persisting clients.
     * @param service The util client service is responsible for managing all client validation operations.
     */
    public CreateClientUseCase(ClientRepository repository,ClientService service) {
        this.clientRepository=repository;
        this.clientService = service;
    }

    public Client createClient(Client client){
        this.clientService.validateAge(client);
        client.setCreateAt(LocalDateTime.now());
        client.setChangeDate(LocalDateTime.now());
        return this.clientRepository.saveClient(client);
    }

    public void deleteClient(String nit){
        Optional<Client> client=this.clientRepository.findClientAndTransferByNit(nit);
        if(!client.isPresent()){
            throw new CustomException(INVALID_USER_NOT_EXIST.getErrorCode(),INVALID_USER_NOT_EXIST.getErrorMessage());
        }
        this.clientService.validateProducts(client.get());
       try {
           this.clientRepository.deleteClient(nit);
       }catch (Exception ex){
           throw new CustomException(SPError.ERROR_DELETE_USER.getErrorCode(),SPError.ERROR_DELETE_USER.getErrorMessage());
       }
    }





}
