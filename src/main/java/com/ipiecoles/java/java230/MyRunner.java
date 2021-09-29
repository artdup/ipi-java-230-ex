package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class MyRunner implements CommandLineRunner {
    @Autowired
    private EmployeRepository employeRepository;

    @Override
    public void run(String... strings) throws Exception {
        //Communiquer avec la base
        //Afficher le nombre d'employés en base
        System.out.println(employeRepository.count());
        //Est-ce que l'employé d'id 5 existe ?
        if(employeRepository.existsById(5L)){
            System.out.println("L'employé d'id 5 existe");
            //Récupérer l'employé d'id 5 et afficher nom/prénom
            Optional<Employe> employe = employeRepository.findById(5L);
            if(employe.isPresent()){
                System.out.println(employe.get().getPrenom());
                System.out.println(employe.get().getNom());
            }
        }
        //Afficher les matricules de tous les employés de la base
        List<Employe> employes = employeRepository.findAll();
        for(Employe e : employes){
            System.out.println(e.getMatricule());
        }
        //Créer et sauvegarder en base l'employé John Doe de matricule X12345
        Employe e1 = new Employe("Doe", "John", "X12345", LocalDate.now(), 1500d);
        e1 = employeRepository.save(e1);
        System.out.println(e1.getId());
        System.out.println(e1);
        //Modifier le prénom John => Jane et sauvegarder
        Employe e1 = employeRepository.findById(2517L).get();
//UPDATE
        e1.setPrenom("Jane");
        e1 = employeRepository.save(e1);
        System.out.println(e1);
        //Supprimer l'employé précédemment créé.
        employeRepository.delete(e1);
    }

    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
