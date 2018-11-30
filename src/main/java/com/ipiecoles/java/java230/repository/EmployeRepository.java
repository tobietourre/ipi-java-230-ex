package com.ipiecoles.java.java230.repository;

import com.ipiecoles.java.java230.model.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
@Repository
//public interface EmployeRepository extends CrudRepository<Employe, Long>{
public interface EmployeRepository extends PagingAndSortingRepository<Employe, Long> {

    Employe findByMatricule(String matricule);

    @Query(value = "SELECT e from Employe e WHERE UPPER(e.nom) = UPPER(:nomOuPrenom) OR UPPER(e.prenom) = UPPER(:nomOuPrenom)", nativeQuery = true)
    List<Employe> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);

    List<Employe> findByNomAndPrenom(String nom, String prenom);

    List<Employe> findByNomIgnoreCase(String nom);

    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);

    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);

    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    @Query( value = "SELECT e FROM Employe e WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)")
    List<Employe> findEmployePlusRiches();

    //List*/

}
