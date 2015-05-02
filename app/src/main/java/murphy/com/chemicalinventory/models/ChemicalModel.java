package murphy.com.chemicalinventory.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ChemicalModel extends RealmObject {
    @PrimaryKey
    private String name;
    private  String chemicalAbstractServiceRegistryNumber;
    private int quantity;
    private String quantityUnit;

    private LabModel lab;

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

    public LabModel getLab() {
        return lab;
    }

    public void setLab(LabModel lab) {
        this.lab = lab;
    }
}
