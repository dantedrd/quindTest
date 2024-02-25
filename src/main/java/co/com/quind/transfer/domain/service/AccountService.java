package co.com.quind.transfer.domain.service;

import co.com.quind.transfer.config.exception.CustomException;
import co.com.quind.transfer.config.exception.SPError;
import co.com.quind.transfer.domain.models.Account;

import java.util.Random;


public class AccountService {
    public void validate(Account domain) {
       if(domain.getAmount()<0){
           throw new CustomException(SPError.INVALID_ACCOUNT_AMOUNT.getErrorCode(),SPError.INVALID_ACCOUNT_AMOUNT.getErrorMessage());
       }
    }

    public String generateNumber(Account domain){
        switch (domain.getAccountType()){
            case SAVINGS_ACCOUNT -> {
                return "53"+this.generateRandomNumber(8);
            }
            case CHECKING_ACCOUNT ->{
                return "33"+this.generateRandomNumber(8);
            }
            default -> {
                return "";
            }
        }
    }

    private static String generateRandomNumber(int longitud) {
        Random random = new Random();
        StringBuilder numero = new StringBuilder();
        random.ints(longitud, 0, 10).forEach(numero::append);
        return numero.toString();
    }

}
