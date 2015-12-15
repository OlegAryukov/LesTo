package model;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 24.11.2015.
 */
@Entity
@Table(name = "options", schema = "", catalog = "dbtelecom")
public class OptionsEntity {
    private int optionsId;
    private String name;
    private int price;
    private int conectCost;
    private List<TarifEntity> tarif = new ArrayList<TarifEntity>(0);
    private List<ContractEntity> contracts = new ArrayList<ContractEntity>(0);

    public OptionsEntity() {
    }

    public OptionsEntity(String name, int price, int conectCost) {
        this.name = name;
        this.price = price;
        this.conectCost = conectCost;
    }

    @Id
    @Column(name = "options_id", nullable = false, insertable = true, updatable = true)
    public int getOptionsId() {
        return optionsId;
    }

    public void setOptionsId(int optionsId) {
        this.optionsId = optionsId;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Basic
    @Column(name = "conect_cost", nullable = false, insertable = true, updatable = true)
    public int getConectCost() {
        return conectCost;
    }

    public void setConectCost(int conectCost) {
        this.conectCost = conectCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OptionsEntity that = (OptionsEntity) o;

        if (optionsId != that.optionsId) return false;
        if (price != that.price) return false;
        if (conectCost != that.conectCost) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = optionsId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + conectCost;
        return result;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "avaliableOptions")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<TarifEntity> getTarif() {
        return tarif;
    }

    public void setTarif(List<TarifEntity> avaliableOptionsesByOptionsId) {
        this.tarif = avaliableOptionsesByOptionsId;
    }

    @ManyToMany(cascade = CascadeType.PERSIST, mappedBy = "connectionOptions")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<ContractEntity> getContracts() {
        return contracts;
    }

    public void setContracts(List<ContractEntity> contractOptionsesByOptionsId) {
        this.contracts = contractOptionsesByOptionsId;
    }
}
