package com.ipiecoles.java.java230;

import com.ipiecoles.java.java230.model.Employe;
import com.ipiecoles.java.java230.model.Manager;
import com.ipiecoles.java.java230.model.Technicien;
import com.ipiecoles.java.java230.repository.EmployeRepository;
import com.ipiecoles.java.java230.repository.ManagerRepository;
import com.ipiecoles.java.java230.repository.TechnicienRepository;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyRunner implements CommandLineRunner {



    @Autowired
    private EmployeRepository employeRepository;

    @Autowired
    private TechnicienRepository technicienRepository;

    @Autowired
    private  ManagerRepository managerRepository;

    @Override
    public void run(String... strings) throws Exception {
        // Read
        /*Employe e = employeRepository.findOne(5L);
        System.out.println(e.toString());

        // Update
        e.setMatricule("XXXX");
        e = employeRepository.save(e);
        System.out.println(e.toString());

        // Create
        /*Employe e2 = new Employe("Doe", "John", "X666", LocalDate.now(), 3000.0);
        System.out.println(e2.getId());
        e2 = employeRepository.save(e2);
        System.out.println(e2.getId());

        // Delete
        employeRepository.delete(2504L);

        Iterable<Employe> allEmployes = employeRepository.findAll();
        for(Employe emp : allEmployes){
            System.out.println(emp);
        }

        Iterable<Employe> allEmployes = employeRepository.findAll(new Sort(Sort.Direction.DESC, "matricule"));
        for(Employe emp : allEmployes){
            System.out.println(emp);
        }

        Page<Employe> allEmployes = employeRepository.findAll(new PageRequest(1, 20, Sort.Direction.ASC, "dateEmbauche"));
        System.out.println("Nb employes : " + allEmployes.getTotalElements());
        System.out.println("Nb pages : " + allEmployes.getTotalPages());

        for(Employe emp : allEmployes){
            System.out.println(emp);
        }

        List<Technicien> techniciens = technicienRepository.findByGradeBetween(1,3);

        for(Technicien tech : techniciens){
            System.out.println(tech);
        }

        Employe t = employeRepository.findByMatricule("T02141");
        Technicien technicien = (Technicien) t;
        System.out.println(technicien.getManager());

        Employe m = employeRepository.findByMatricule("M02149");
        Manager manager = (Manager) m;
        for (Technicien te : manager.getEquipe()){
            System.out.println(te);
        } */


        Employe m = managerRepository.findById(11L);
        Manager manager = (Manager) m;
        for (Technicien te : manager.getEquipe()){
            System.out.println(te);
        }


    }

    public static void print(Object t) {
        System.out.println(t);
    }
}
