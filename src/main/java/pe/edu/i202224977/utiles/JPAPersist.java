package pe.edu.i202224977.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202224977.domain.City;
import pe.edu.i202224977.domain.Country;
import pe.edu.i202224977.domain.CountryLanguage;
import pe.edu.i202224977.domain.CountryLanguagePk;

import java.util.Arrays;

public class JPAPersist {

    public static void main(String[] args) {

        // referenciar a la unidad de persistencia
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        //crear pais
        Country country = new Country("ABC", "Imaginaria", "Oceania", "Fantasia", 12345.67, 2000, 123456, 75.3, 98765.43, 87654.32, "Fantástico", "República", "John Doe", 1, "IM",null,null);

        //Crear ciudades
        City city1 = new City(null, "Metropolis", "Central Dist", 1000000, country);
        City city2 = new City(null, "Cair Paravel", "East Shore", 250000, country);
        City city3 = new City(null, "Birnin Zana", "Golden Dist", 500000, country);

        //para lenguajesNativos
        CountryLanguage countryLanguage1 = new CountryLanguage(new CountryLanguagePk("ABC", "POrtugues"), "T", 75.5, country);
        CountryLanguage countryLanguage2 = new CountryLanguage(new CountryLanguagePk("ABC", "MAndarin"), "F", 30.0, country);

        country.setCities(Arrays.asList(city1, city2, city3));
        country.setCountrylanguages(Arrays.asList(countryLanguage1, countryLanguage2));

        // Persist
        em.getTransaction().begin();
        em.persist(country); //Cascadetype.PERSIST (colocado en la entidad)
        em.getTransaction().commit();

    }

}
