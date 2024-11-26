package pe.edu.i202224977.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224977.domain.Country;

public class JPARemove {

    public static void main(String[] args) {

        //Referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //Referenciar a Country
        Country country = em.find(Country.class, "ABC");

        // remove
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
    }
}
