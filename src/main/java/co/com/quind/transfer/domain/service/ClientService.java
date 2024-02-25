package co.com.quind.transfer.domain.service;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.config.exception.SPError;
import co.com.quind.transfer.domain.models.Client;

import java.time.LocalDate;
import java.time.Period;

public class ClientService {

    public void validateAge(Client domain) {
        int age = Period.between(domain.getBirthdate(), LocalDate.now()).getYears();
        if(age<18){
            throw new CustomException(SPError.INVALID_AGE_CLIENT.getErrorCode(),SPError.INVALID_AGE_CLIENT.getErrorMessage());
        }
    }

    public void validateProducts(Client domain) {
        if(domain.getAccounts().size()>0){
            throw new CustomException(SPError.INVALID_CLIENT_HAS_PRODUCTS.getErrorCode(),SPError.INVALID_CLIENT_HAS_PRODUCTS.getErrorMessage());
        }
    }

}
