import java.time.LocalDate;

public class MaterialManager {

    private Material[] materialList;
    private int n = 0;

    public MaterialManager()
    {
        materialList = new Material[100];
        materialList[0] = new CrispyFlour("1","Ajinomoto", LocalDate.of(2016,6,5),70000,10);
        materialList[1] = new CrispyFlour("2","Vedan",LocalDate.of(2016,7,25),85000,8);
        materialList[2] = new CrispyFlour("3","Miwon",LocalDate.of(2016,5,8),75000,9);
        materialList[3] = new CrispyFlour("4","Yess",LocalDate.of(2016,4,23),55000,7);
        materialList[4] = new CrispyFlour("5"," A-One",LocalDate.of(2016,5,28),65000,7);
        materialList[5] = new Meat("6","Wagyu Beef",LocalDate.of(2016,9,15),570000,50);
        materialList[6] = new Meat("7","Kobe Beef",LocalDate.of(2016,10,13),2500000,56);
        materialList[7] = new Meat("8","Tokachi Beef",LocalDate.of(2016,7,8),375000,94);
        materialList[8] = new Meat("9","Matsuzaka Beef",LocalDate.of(2016,9,25),355000,67);
        materialList[9] = new Meat("10","USA Beef",LocalDate.of(2016,8,21),2065000,77);

        for (Material material : materialList)
        {
            if (material == null)
            {
                break;
            }
            this.n++;
        }
    }
    public void displayMaterial()
    {
        for (int i = 0; i < this.n; i++)
        {
            System.out.println(materialList[i].getId() + " " + materialList[i].getName() + " " + materialList[i].getAmount());
        }
    }
    public boolean addMaterial(Material value)
    {
        int i = 0;
        while (i < n && !materialList[i].getId().equalsIgnoreCase(value.getId()))
        {
           i++;
        }
        if (i >= n)
        {
            materialList[i] = value;
            this.n++;
            return false;
        }
        else
        {
            return true;
        }
    }
    public boolean removeMaterial(String id)
    {
        int i = 0;
        while (i < n && !materialList[i].getId().equalsIgnoreCase(id))
        {
            i++;
        }
        if (i >= n)
        {
            return false;
        }
        else
        {
            for (int j = i; j < n; j++)
            {
                materialList[j] = materialList[j+1];
            }
            this.n--;

           return true;
        }
    }
    public boolean updateMaterial(String id, String materialName)
    {
        int i = 0;
        while (i < n && !materialList[i].getId().equalsIgnoreCase(id))
        {
            i++;
        }
        if (i >= n)
        {
            return false;
        }
        else
        {
            Material materialUpdate = materialList[i];
            materialUpdate.setName(materialName);
            return true;
        }
    }
}
