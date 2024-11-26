package pe.edu.i202224977.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "countrylanguage")
public class CountryLanguage {

    @EmbeddedId
    private CountryLanguagePk countryLanguagePk;

    private String IsOfficial;
    private Double Percentage;

    //variable de la llave foranea
    @ManyToOne
    @JoinColumn(name = "CountryCode")
    @MapsId("CountryCode")
    private Country country;


    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePk countryLanguagePk, String isOfficial, Double percentage, Country country) {
        this.countryLanguagePk = countryLanguagePk;
        IsOfficial = isOfficial;
        Percentage = percentage;
        this.country = country;
    }

    public CountryLanguagePk getCountryLanguagePk() {
        return countryLanguagePk;
    }

    public void setCountryLanguagePk(CountryLanguagePk countryLanguagePk) {
        this.countryLanguagePk = countryLanguagePk;
    }

    public String getIsOfficial() {
        return IsOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        IsOfficial = isOfficial;
    }

    public Double getPercentage() {
        return Percentage;
    }

    public void setPercentage(Double percentage) {
        Percentage = percentage;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
