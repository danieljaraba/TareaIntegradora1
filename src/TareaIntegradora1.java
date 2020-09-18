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
        int[] bestPlaceForEachMaterial;
        int amountOfMaterials;
        int ubication = 0;

        System.out.println("Write the amount of materials solicited by the foreman:");
        amountOfMaterials = sc.nextInt();
		sc.nextLine();

        namesOfMaterials = new String[amountOfMaterials];
        pricesOfMaterialsInHC = new double[amountOfMaterials];
        pricesOfMaterialsInFC = new double[amountOfMaterials];
        pricesOfMaterialsInFB = new double[amountOfMaterials];
        bestPrices = new double[amountOfMaterials];
        amountOfEveryMaterial = new int[amountOfMaterials];
        buildingTypeMaterials = new Object[amountOfMaterials];
        bestPlaceForEachMaterial = new int[amountOfMaterials];

        System.out.println("Write the names of the materials solicited by the foreman:");
        for(int i = 0; i<amountOfMaterials; i++){
            namesOfMaterials[i] = sc.nextLine();
        }

        System.out.println("Write the amount of each material");
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.print(namesOfMaterials[i]+": ");
            amountOfEveryMaterial[i] = sc.nextInt();
        }

        System.out.println("Write the price of each material in HomeCenter");
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.print(namesOfMaterials[i]+": ");
            pricesOfMaterialsInHC[i] = sc.nextDouble();
        }

        System.out.println("Write the price of each material in Central HardWard Store");
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.print(namesOfMaterials[i]+": ");
            pricesOfMaterialsInFC[i] = sc.nextDouble();
        }

        System.out.println("Write the price of each material in Neighborhood HardWard Store");
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.print(namesOfMaterials[i]+": ");
            pricesOfMaterialsInFB[i] = sc.nextDouble();
        }

        System.out.print("Select the type of building for each material: \n 1: For white building \n 2: For black building \n 3: For painting building \n");
        buildingTypeMaterials = buildingTypeOfEachMaterial(namesOfMaterials, amountOfMaterials);

        System.out.print("Select the ubication of the building: \n 1: For north \n 2: For center \n 3: For south \n");
        ubication = sc.nextInt();

        System.out.println("The total price in each stablishment is:");
        System.out.println("HomeCenter: "+totalForEachStablishment(pricesOfMaterialsInHC, amountOfEveryMaterial, amountOfMaterials, buildingTypeMaterials));
        System.out.println("Central HardWard Store: "+totalForEachStablishment(pricesOfMaterialsInFC, amountOfEveryMaterial, amountOfMaterials, buildingTypeMaterials));
        System.out.println("Neighborhood HardWard Store: "+totalForEachStablishment(pricesOfMaterialsInFB, amountOfEveryMaterial, amountOfMaterials, buildingTypeMaterials));

        System.out.println("The best place and price for each material is:");
        bestPrices = bestPriceOfMaterials(pricesOfMaterialsInHC, pricesOfMaterialsInFC, pricesOfMaterialsInFB, bestPlaceForEachMaterial, amountOfMaterials);
        for(int i = 0; i<amountOfMaterials; i++){
            switch(bestPlaceForEachMaterial[i]){
                case 1:
                    System.out.println(namesOfMaterials[i]+": "+"HomeCenter for: "+bestPrices[i]);
                break;
                case 2:
                    System.out.println(namesOfMaterials[i]+": "+"Central HardWare Store for: "+bestPrices[i]);
                break;
                case 3:
                    System.out.println(namesOfMaterials[i]+": "+"Neighborhood HardWare Store for: "+bestPrices[i]);
                break;
            }
        }
        System.out.println("The total value of the materials are: "+totalForBestPrices(bestPrices, amountOfEveryMaterial, amountOfMaterials, ubication, buildingTypeMaterials));
    }

    /**
     * Compares the prices of the markets and gives the best price for each material. <br>
     * <b>pre: <b/> You need have the price of each material in each market stored in an array. <br>
     * <b>post: <b/> <br>
     * @param homeCenterPrices Doubles array, contains the HomeCenter's prices.
     * @param centerHardwardStorePrices Doubles array, contains the Center Hardward Store's prices.
     * @param neighborhoodHardwardStorePrices Doubles array, contains the Neighborhood Hardward Store's prices.
     * @param bestPlaceForEachMaterial
     * @param amountOfMaterials Int, amount of materials that gonna be purchased.
     * @return bestPrice, array of doubles that contains the best price of each material.
     */

    public static double[] bestPriceOfMaterials(double[] homeCenterPrices, double[] centerHardwardStorePrices, double[] neighborhoodHardwardStorePrices, int[] bestPlaceForEachMaterial, int amountOfMaterials){
        double[] bestPrice = new double[amountOfMaterials];
        for(int i = 0; i<amountOfMaterials; i++){
            if((homeCenterPrices[i]<centerHardwardStorePrices[i])&&(homeCenterPrices[i]<neighborhoodHardwardStorePrices[i])){
                bestPrice[i] = homeCenterPrices[i];
                bestPlaceForEachMaterial[i] = 1;
            }
            else if((centerHardwardStorePrices[i]<homeCenterPrices[i])&&(centerHardwardStorePrices[i]<neighborhoodHardwardStorePrices[i])){
                bestPrice[i] = centerHardwardStorePrices[i];
                bestPlaceForEachMaterial[i] = 2;
            }
            else{
                bestPrice[i] = neighborhoodHardwardStorePrices[i];
                bestPlaceForEachMaterial[i] = 3;
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
            System.out.print(arrayNames[i]+": ");
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

    public static double totalForEachStablishment(double[] stablishment, int[] amountOfEachMaterial, int amountOfMaterials, Object[] typeOfBuilding){
        int blackType = 0;
        int whiteType = 0;
        int paintingType = 0;
        double total = 0;
        for(int i = 0; i<amountOfMaterials; i++){
            total += (stablishment[i]*amountOfEachMaterial[i]);
            if(typeOfBuilding[i]==buildingType.WHITE){
                whiteType++;
            }
            else if(typeOfBuilding[i]==buildingType.BLACK){
                blackType++;
            }
            else{
                paintingType++;
            }
        }
        if(whiteType>0){
            total += 2600000;
        }
        if(blackType>0){
            total += 1300000;
        }
        if(paintingType>0){
            total += 980000;
        }

        return total;
    }

    public static double totalForBestPrices(double[] bestPrices, int[] amountOfEachMaterial, int amountOfMaterials, int ubication, Object[] typeOfBuilding){
        int blackType = 0;
        int whiteType = 0;
        int paintingType = 0;
        double total = 0;
        for(int i = 0; i<amountOfMaterials; i++){
            total += (bestPrices[i]*amountOfEachMaterial[i]);
            if(typeOfBuilding[i]==buildingType.WHITE){
                whiteType++;
            }
            else if(typeOfBuilding[i]==buildingType.BLACK){
                blackType++;
            }
            else{
                paintingType++;
            }
        }
        switch(ubication){
            case 1:
                if(total<80000){
                    total += 120000;
                } else if(total <300000){
                    total += 28000;
                } else{
                    total += 0;
                }
            break;
            case 2:
                if(total<80000){
                    total += 50000;
                } else if(total <300000){
                    total += 0;
                } else{
                    total += 0;
                }
            break;
            case 3:
                if(total<80000){
                    total += 120000;
                } else if(total <300000){
                    total += 55000;
                } else{
                    total += 0;
                }
            break;
        }
        if(whiteType>0){
            total += 2600000;
        }
        if(blackType>0){
            total += 1300000;
        }
        if(paintingType>0){
            total += 980000;
        }

        return total;
    }
}