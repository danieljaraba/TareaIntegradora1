import java.util.Scanner;

public class TareaIntegradora1{
	
	public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        String[] namesOfMaterials;
        double[] pricesOfMaterialsInHC;
        double[] pricesOfMaterialsInFC;
        double[] pricesOfMaterialsInFB;
        double[] bestPrices;
        int[] amountOfEveryMaterial;
        Object[] buildingTypeMaterials;
        int amountOfMaterials;

        System.out.println("Write the amount of materials solicited by the foreman:");
        amountOfMaterials = sc.nextInt();

        namesOfMaterials = new String[amountOfMaterials];
        pricesOfMaterialsInHC = new double[amountOfMaterials];
        pricesOfMaterialsInFC = new double[amountOfMaterials];
        pricesOfMaterialsInFB = new double[amountOfMaterials];
        bestPrices = new double[amountOfMaterials];
        amountOfEveryMaterial = new int[amountOfMaterials];
        buildingTypeMaterials = new Object[amountOfMaterials];

        System.out.println("Write the names of the materials solicited by the foreman:");
        for(int i = 0; i<amountOfMaterials; i++){
            namesOfMaterials[i] = sc.nextLine();
            System.out.println(namesOfMaterials[i]);
        }

        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println("Write the amount of the material "+namesOfMaterials[i]);
            amountOfEveryMaterial[i] = sc.nextInt();
        }

        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println("Write the price of the material "+namesOfMaterials[i]+" in HomeCenter");
            pricesOfMaterialsInHC[i] = sc.nextDouble();
        }

        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println("Write the price of the material "+namesOfMaterials[i]+" in center hardward store");
            pricesOfMaterialsInFC[i] = sc.nextDouble();
        }

        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println("Write the price of the material "+namesOfMaterials[i]+" in neighborhood hardward store");
            pricesOfMaterialsInFB[i] = sc.nextDouble();
        }

        bestPrices = bestPriceOfMaterials(pricesOfMaterialsInHC, pricesOfMaterialsInFC, pricesOfMaterialsInFB, amountOfMaterials);

        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println(bestPrices[i]);
        }

        System.out.print("Select the type of building for each material: \n 1: For white building \n 2: For black building \n 3: For painting building \n");
        buildingTypeOfEachMaterial(namesOfMaterials, amountOfMaterials);
    }

    /**
     * Compares the prices of the markets and gives the best price for each material. <br>
     * <b>pre: <b/> You need have the price of each material in each market stored in an array. <br>
     * <b>post: <b/> <br>
     * @param homeCenterPrices Doubles array, contains the HomeCenter's prices.
     * @param centerHardwardStorePrices Doubles array, contains the Center Hardward Store's prices.
     * @param neighborhoodHardwardStorePrices Doubles array, contains the Neighborhood Hardward Store's prices.
     * @param amountOfMaterials Int, amount of materials that gonna be purchased.
     * @return bestPrice, array of doubles that contains the best price of each material.
     */

    public static double[] bestPriceOfMaterials(double[] homeCenterPrices, double[] centerHardwardStorePrices, double[] neighborhoodHardwardStorePrices, int amountOfMaterials){
        double[] bestPrice = new double[amountOfMaterials];
        for(int i = 0; i<amountOfMaterials; i++){
            if((homeCenterPrices[i]<centerHardwardStorePrices[i])&&(homeCenterPrices[i]<neighborhoodHardwardStorePrices[i])){
                bestPrice[i] = homeCenterPrices[i];
            }
            else if((centerHardwardStorePrices[i]<homeCenterPrices[i])&&(centerHardwardStorePrices[i]<neighborhoodHardwardStorePrices[i])){
                bestPrice[i] = centerHardwardStorePrices[i];
            }
            else{
                bestPrice[i] = neighborhoodHardwardStorePrices[i];
            }
        }
        return bestPrice;
    }

    /**
     * Stores the type of building for each material in an array. <br>
     * <b>pre: <b/> You need have the name of each material stored in an array. <br>
     * <b>post: <b/> <br>
     * @param arrayNames String array, contains the name of each material.
     * @param amountOfMaterials Int, amount of materials that gonna be purchased.
     * @return arrayType, array of the type buildingType that contains the type of building for each material.
     */

    public static Object[] buildingTypeOfEachMaterial(String[] arrayNames, int amountOfMaterials){
        int option;
        Object[] arrayType = new Object[amountOfMaterials];
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.println("Select the type of building for the material: "+arrayNames[i]);
            option = sc.nextInt();
            switch(option){
                case 1:
                    arrayType[i] = buildingType.WHITE;
                break;
                case 2:
                    arrayType[i] = buildingType.BLACK;
                break;
                case 3:
                    arrayType[i] = buildingType.PAINTING;
                break;
            }
        }
        return arrayType;
    }
}