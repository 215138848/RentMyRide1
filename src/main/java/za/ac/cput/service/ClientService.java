package za.ac.cput.service;

/*
    @Description:CllientService
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 28 July 2021
*/

import org.springframework.stereotype.Service;
import za.ac.cput.entity.Client;
import za.ac.cput.repository.client.ClientRepository;
import za.ac.cput.service.client.IClientService;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ClientService implements IClientService {
    private static  ClientService service = null;
    private ClientRepository repository = null;

    private ClientService(){this.repository = ClientRepository.getRepository();}

    public static ClientService getService(){
        if(service == null){
            service = new ClientService();
        }
        return service;
    }
    @Override
    public Client create(Client client){return this.repository.create(client);}

    @Override
    public Client read(String clientID){return this.repository.read(clientID);}

    @Override
    public Client update(Client client){return this.repository.update(client);}

    @Override
    public boolean delete(String clientID){
       return this.repository.delete(clientID);
    }

    @Override
    public Set<Client> getAll() {
        return this.repository.getAll();
           // return this.repository.findAll().stream().collect(Collectors.toSet());

    }

    public Set<Client> getAllClientsStartWithA(){
        Set<Client> clientsWithA =  new HashSet<Client>();
        Set<Client> clients = getAll();
        for(Client client : clients){
            if(client.getName().trim().toLowerCase().startsWith("a")){
                clientsWithA.add(client);
            }
        }
        return clientsWithA;
    }

//    public Client getAllClientsGivenName(String clientName){
//        Client c = null;
//        Set<Client> clients = getAll();
//        for(Client client : clients){
//            if(client.getName().equals(clientName)){
//              c = client;
//              break;
//            }
//        }
//        return c;
//    }

}
