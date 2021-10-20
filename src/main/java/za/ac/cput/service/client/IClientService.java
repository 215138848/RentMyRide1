package za.ac.cput.service.client;

/*
    @Description:ICllientService ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 28 July 2021
*/

import za.ac.cput.entity.Client;
import za.ac.cput.service.IService;
import java.util.Set;

public interface IClientService extends IService<Client,String> {
    Set<Client> getAll();
     //Client getAllClientsGivenName(String name);
}
