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
@Table(name = "tarif", schema = "", catalog = "dbtelecom")
public class TarifEntity {
    private int tarifId;
    private String name;
    private int price;
    private List<OptionsEntity> avaliableOptions = new ArrayList<OptionsEntity>();
    private List<ContractEntity> contractByContractId = new ArrayList<ContractEntity>();

    public TarifEntity() {
    }

    public TarifEntity(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Id
    @Column(name = "tarif_id", nullable = false, insertable = true, updatable = true)
    public int getTarifId() {
        return tarifId;
    }

    public void setTarifId(int tarifId) {
        this.tarifId = tarifId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TarifEntity that = (TarifEntity) o;

        if (tarifId != that.tarifId) return false;
        if (price != that.price) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tarifId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "avaliable_options", catalog = "dbtelecom", joinColumns = {
            @JoinColumn(name = "tarif_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "options_id",
                    nullable = false, updatable = false) })
    public List<OptionsEntity> getAvaliableOptions() {
        return avaliableOptions;
    }

    public void setAvaliableOptions(List<OptionsEntity> avaliableOptionsesByTarifId) {
        this.avaliableOptions = avaliableOptionsesByTarifId;
    }

    @OneToMany(mappedBy = "tarifsByContractId")
    @LazyCollection(LazyCollectionOption.FALSE)
    //@JoinColumn(name = "contract_id", referencedColumnName = "contract_id", nullable = false)
    public List<ContractEntity> getContractByContractId() {
        return contractByContractId;
    }

    public void setContractByContractId(List<ContractEntity> contractByContractId) {
        this.contractByContractId = contractByContractId;
    }

    @Override
    public String toString() {
        return "TarifEntity{" +
                "tarifId=" + tarifId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", avaliableOptions=" + avaliableOptions +
                ", contractByContractId=" + contractByContractId +
                '}';
    }
}
