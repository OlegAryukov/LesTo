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
@Table(name = "contract", schema = "", catalog = "dbtelecom")
public class ContractEntity {
    private int contractId;
    private String phoneNum;
    private ClientEntity clientByClientId;
    private List<OptionsEntity> connectionOptions = new ArrayList<OptionsEntity>(0);
    private TarifEntity tarifsByContractId;

    public ContractEntity() {
    }

    public ContractEntity(String phoneNum, TarifEntity tarifsByContractId) {
        this.phoneNum = phoneNum;
        this.tarifsByContractId = tarifsByContractId;
    }

    @Id
    @Column(name = "contract_id", nullable = false, insertable = true, updatable = true)
    public int getContractId() {
        return contractId;
    }

    public void setContractId(int contractId) {
        this.contractId = contractId;
    }

    @Basic
    @Column(name = "phone_num", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContractEntity that = (ContractEntity) o;

        if (contractId != that.contractId) return false;
        if (phoneNum != null ? !phoneNum.equals(that.phoneNum) : that.phoneNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contractId;
        result = 31 * result + (phoneNum != null ? phoneNum.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    public ClientEntity getClientByClientId() {
        return clientByClientId;
    }

    public void setClientByClientId(ClientEntity clientByClientId) {
        this.clientByClientId = clientByClientId;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "contract_options", catalog = "dbtelecom", joinColumns = {
            @JoinColumn(name = "contract_id", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "options_id",
                    nullable = false, updatable = false) })
    public List<OptionsEntity> getConnectionOptions() {
        return connectionOptions;
    }

    public void setConnectionOptions(List<OptionsEntity> contractOptionsesByContractId) {
        this.connectionOptions = contractOptionsesByContractId;
    }

    @ManyToOne
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "tarif_id", referencedColumnName = "tarif_id", nullable = false)
    public TarifEntity getTarifsByContractId() {
        return tarifsByContractId;
    }

    public void setTarifsByContractId(TarifEntity tarifsByContractId) {
        this.tarifsByContractId = tarifsByContractId;
    }

    @Override
    public String toString() {
        return "ContractEntity{" +
                "contractId=" + contractId +
                ", phoneNum='" + phoneNum + '\'' +
                ", clientByClientId=" + clientByClientId +
                ", connectionOptions=" + connectionOptions +
                ", tarifsByContractId=" + tarifsByContractId +
                '}';
    }
}
