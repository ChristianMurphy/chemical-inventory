package murphy.com.chemicalinventory.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Chemical extends RealmObject {
    @PrimaryKey
    private String name;
    private  String chemicalAbstractServiceRegistryNumber;
    private int quantity;
    private String quantityUnit;

    private Lab lab;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChemicalAbstractServiceRegistryNumber() {
        return chemicalAbstractServiceRegistryNumber;
    }

    public void setChemicalAbstractServiceRegistryNumber(String chemicalAbstractServiceRegistryNumber) {
        this.chemicalAbstractServiceRegistryNumber = chemicalAbstractServiceRegistryNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getQuantityUnit() {
        return quantityUnit;
    }

    public void setQuantityUnit(String quantityUnit) {
        this.quantityUnit = quantityUnit;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }
}
