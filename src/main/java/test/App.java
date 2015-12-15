package test;

import model.ContractEntity;
import model.TarifEntity;
import services.ContractManager;
import services.ContractManagerImpl;
import services.TarifManager;
import services.TarifManagerImpl;

/**
 * Created by oleg on 21.11.2015.
 */
public class App {
    public static void main( String[] args )
    {

        ContractManager cm = new ContractManagerImpl();
        TarifManager tm = new TarifManagerImpl();
        TarifEntity tarif = tm.findById(4);
        ContractEntity contract = cm.findById(3);
        cm.changeTarif(contract,tarif);

        /*System.out.println("Maven + Hibernate + MySQL");
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        ContractManager cm = new ContractManagerImpl();
        OptionsManager om = new OptionsManagerImpl();
        ContractEntity a = cm.findByPhone("5390846");
        List<OptionsEntity> list = a.getConnectionOptions();
        for (OptionsEntity d:list)
        {
            System.out.println(d.getName());
        }
        OptionsEntity b = om.findById(8);
        System.out.println(b.getName());
        cm.connectOption(b,a);
        ClientManager cm = new ClientManagerImpl();
        ClientEntity wanted = cm.findByPersonName("Oleg", "Arykov");
        System.out.println(wanted.toString());
        List<ContractEntity> set = wanted.getContractsByClientId();
        for (ContractEntity a:set)
        {
            System.out.println(a.getPhoneNum());
            System.out.println(a.getTarifsByContractId().getName());
        }
        List allClient = cm.loadAllClient();
        for (Object a:allClient)
        {
            System.out.println(a.toString());
        }
        //HashSet<ContractEntity> set1 = wanted.getContractsByClientId()
        //System.out.println(wanted.getContractsByClientId().get(0));
        //System.out.println(cm.getAllContracts(wanted));
        /*ClientEntity wan = cm.findById(1);
        System.out.println(wan);*/
    }
}
