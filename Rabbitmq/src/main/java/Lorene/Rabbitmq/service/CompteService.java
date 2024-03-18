package Lorene.Rabbitmq.service;

import org.springframework.stereotype.Service;

import Lorene.Rabbitmq.pojo.Compte;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CompteService {
    private RabbitmqService service;

    // application des traitements
  public void enregistrer (Compte compte){
    this.service.publier(compte);
        
    }   
}
