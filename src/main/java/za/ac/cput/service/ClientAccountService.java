package za.ac.cput.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.repository.clientAccount.impl.ClientAccountRepository;
import za.ac.cput.service.clientAccount.IClientAccountService;

import java.util.Locale;
import java.util.Set;
/*
    @Description: Client Account Service ->
    @Author: Asiphiwe Hanjiwe
    @Student Number: 218336675
    @Date: 30 July 2021
 */

@Service
public class ClientAccountService implements IClientAccountService
{
    private static ClientAccountService service = null;
    private ClientAccountRepository repo = null;

    private ClientAccountService() {
        this.repo = ClientAccountRepository.getRepository();
    }

    public static ClientAccountService getService(){
        if(service == null){
            service = new ClientAccountService();
        }
        return service;
    }

    @Override
    public ClientAccount create(ClientAccount account) {
        return this.repo.create(account);
    }

    @Override
    public ClientAccount read(String accountID) {
        return this.repo.read(accountID);
    }

    @Override
    public ClientAccount update(ClientAccount account) {
        return this.repo.update(account);
    }

    @Override
    public boolean delete(String accountID) {
        return this.repo.delete(accountID);
    }

    @Override
    public Set<ClientAccount> getAll() {
        return this.repo.getAll();
    }

    public Set<ClientAccount> getClientAccountWithNum15()
    {
        Set<ClientAccount> clientAccountsWithNum15 = null;
        Set<ClientAccount> clientAccounts = getAll();
        for (ClientAccount clientAccount : clientAccounts)
        {
            if(clientAccount.getAccountNum().trim().toLowerCase().startsWith("51"))
            {
                clientAccountsWithNum15.add(clientAccount);
            }
        }
        return clientAccountsWithNum15;
    }

}
