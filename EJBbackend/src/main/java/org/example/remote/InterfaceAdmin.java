package org.example.remote;


import org.example.CD;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface InterfaceAdmin  {
    //Déclaration des méthdoes à invoquer dans desktop client
    public String sayHello();
    public  CD saveCD(CD etud);
    public List<CD> retrieveAllCDs() ;
    public CD findCD(CD project);
    public CD update(CD project);
    public void delete(CD project);
}
