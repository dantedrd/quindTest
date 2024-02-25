package co.com.quind.transfer.application.port.out;

import co.com.quind.transfer.domain.models.Client;

import java.util.Optional;

public interface ClientRepository {

    Optional<Client> findClientAndTransferByNit(String nit);
    Client saveClient(Client employee);

    void deleteClient(String nit);
}
