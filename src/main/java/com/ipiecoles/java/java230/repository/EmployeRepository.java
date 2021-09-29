package com.ipiecoles.java.java230.repository;

        import com.ipiecoles.java.java230.model.Employe;
        import org.joda.time.LocalDate;
        import org.springframework.data.jpa.repository.JpaRepository;

        import java.util.List;

public interface EmployeRepository extends JpaRepository<Employe, Long> {
    Employe findByMatricule(String matricule);
    List<Employe> findByNomAndPrenom(String nom, String prenom);
    List<Employe> findByNomIgnoreCase(String nom);
    List<Employe> findByDateEmbaucheAfter(LocalDate dateEmbauche);
    List<Employe> findByDateEmbaucheBefore(LocalDate dateEmbauche);
    List<Employe> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);
}
