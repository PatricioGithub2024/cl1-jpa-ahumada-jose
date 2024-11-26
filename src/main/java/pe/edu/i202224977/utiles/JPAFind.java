package pe.edu.i202224977.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224977.domain.City;
import pe.edu.i202224977.domain.Country;

import java.util.List;

public class JPAFind {

    public static void main(String[] args) {

        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //obtener el codigo PER
        Country country = em.find(Country.class,"PER");

        List<City> cities = country.getCities();
        cities.forEach(
                (city)->{
                    if (city.getPopulation() > 700000){
                        System.out.println( country.getCode() + " - " + city.getName());
                    }
                });


    }
}
