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
@Table(name = "client", schema = "", catalog = "dbtelecom")
public class ClientEntity {
    private int clientId;
    private String name;
    private String family;
    private String berthdate;
    private String passport;
    private String adress;
    private String password;
    private String email;
    private List<ContractEntity> contractsByClientId = new ArrayList<ContractEntity>(0);

    public ClientEntity() {
    }

    public ClientEntity(String name, String family, String berthdate, String passport, String adress) {
        this.name = name;
        this.family = family;
        this.berthdate = berthdate;
        this.passport = passport;
        this.adress = adress;
    }

    @Id
    @Column(name = "client_id", nullable = false, insertable = true, updatable = true)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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
    @Column(name = "family", nullable = false, insertable = true, updatable = true, length = 45)
    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    @Basic
    @Column(name = "berthdate", nullable = false, insertable = true, updatable = true, length = 45)
    public String getBerthdate() {
        return berthdate;
    }

    public void setBerthdate(String berthdate) {
        this.berthdate = berthdate;
    }

    @Basic
    @Column(name = "passport", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    @Basic
    @Column(name = "adress", nullable = false, insertable = true, updatable = true, length = 45)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "password", nullable = false, insertable = true, updatable = true, length = 45)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email", nullable = false, insertable = true, updatable = true, length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClientEntity that = (ClientEntity) o;

        if (clientId != that.clientId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (family != null ? !family.equals(that.family) : that.family != null) return false;
        if (berthdate != null ? !berthdate.equals(that.berthdate) : that.berthdate != null) return false;
        if (passport != null ? !passport.equals(that.passport) : that.passport != null) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (family != null ? family.hashCode() : 0);
        result = 31 * result + (berthdate != null ? berthdate.hashCode() : 0);
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientByClientId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public List<ContractEntity> getContractsByClientId() {
        return contractsByClientId;
    }

    public void setContractsByClientId(List<ContractEntity> contractsByClientId) {
        this.contractsByClientId = contractsByClientId;
    }

    @Override
    public String toString() {
        return "ClientEntity{" +
                "clientId=" + clientId +
                ", name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", berthdate='" + berthdate + '\'' +
                ", passport='" + passport + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
