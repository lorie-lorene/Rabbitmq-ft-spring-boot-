package Lorene.Rabbitmq.web.rabbitmq.publisher;

import org.springframework.web.bind.annotation.RestController;

import Lorene.Rabbitmq.pojo.Compte;
import Lorene.Rabbitmq.service.CompteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@AllArgsConstructor
@RestController
public class CompteController {
    private CompteService service;

@PostMapping("comptes")
    public void enregistrer (@RequestBody Compte compte){
        this.service.enregistrer(compte);

    }
    
}
