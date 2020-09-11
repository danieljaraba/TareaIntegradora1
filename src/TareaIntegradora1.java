import java.util.Scanner;

public class TareaIntegradora1{

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        String[] namesOfMaterials;
        double[] pricesOfMaterialsInHC;
        double[] pricesOfMaterialsInFC;
        double[] pricesOfMaterialsInFB;
        int amountOfMaterials;

        System.out.println("Write the amount of materials solicited by the foreman:");
        amountOfMaterials = sc.nextInt();

        namesOfMaterials = new String[amountOfMaterials];
        pricesOfMaterialsInHC = new double[amountOfMaterials];
        pricesOfMaterialsInFC = new double[amountOfMaterials];
        pricesOfMaterialsInFB = new double[amountOfMaterials];

        System.out.println("Write the names of the materiales solicited by the foreman:");
        for(int a = 0; a<amountOfMaterials; a++){
            namesOfMaterials[a] = sc.nextLine();
        }

        for(int b = 0; b<amountOfMaterials; b++){
            System.out.println("Write the price of the material "+namesOfMaterials[b]+" in HomeCenter");
            pricesOfMaterialsInHC[b] = sc.nextDouble();
        }

        for(int c = 0; c<amountOfMaterials; c++){
            System.out.println("Write the price of the material "+namesOfMaterials[c]+" in center hardward store");
            pricesOfMaterialsInFC[c] = sc.nextDouble();
        }

        for(int d = 0; d<amountOfMaterials; d++){
            System.out.println("Write the price of the material "+namesOfMaterials[d]+" in neighborhood hardward store");
            pricesOfMaterialsInFB[d] = sc.nextDouble();
        }


    }
}