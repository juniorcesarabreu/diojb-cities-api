package dev.juniorcesarabreu.citiesapi.entities;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import javax.persistence.*;
import java.util.List;

@Entity(name = "State")
@Table(name = "estado")
@TypeDefs({ // ensina ao hibernate como ler o dado em json
        @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
public class State {

    @Id
    private Long id;

    @Column(name = "nome")
    private String name;

    private String uf;

    private Integer ibge;

    // 1st
//    @Column(name = "pais")
//    private Integer countryId;

    // 2nd - @ManyToOne
    // exige que o hibernate faça uma query a mais, deve ser pensado se é necessário
    @ManyToOne // indica o relacionamento muitos para um
    @JoinColumn(name = "pais", referencedColumnName = "id") // referencia na tabela pais na coluna id
    private Country country;

    // a lista de ddd no banco está armazenada como um json.
    // o hibernate não sabe lidar
    @Type(type = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    @Column(name = "ddd", columnDefinition = "jsonb")
    private List<Integer> ddd;

    public State() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUf() {
        return uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public List<Integer> getDdd() {
        return ddd;
    }

    public Country getCountry() {
        return country;
    }

//  public Integer getCountryId() {
//      return countryId;
//  }
}