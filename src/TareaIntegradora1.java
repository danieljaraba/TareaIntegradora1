import java.util.Scanner;

public class TareaIntegradora1{
	
	public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Entradas
        String[] namesOfMaterials; // Sirve para guardar el nombre de los materiales
        double[] pricesOfMaterialsInHC; // Guarda el precio de HomeCenter
        double[] pricesOfMaterialsInFC; // Guarda el precio de la ferreteria de centro
        double[] pricesOfMaterialsInFB; // Guarda el precio de la ferreteria de barrio
        double[] bestPrices; // Contiene los mejores precios de cada material
        int[] amountOfEveryMaterial; // Contiene la cantidad de cada material
        BuildingType[] buildingTypeMaterials; // Contiene el typo de obra de cada material
        int[] bestPlaceForEachMaterial; // Contiene donde es mejor comprar cada material
        int amountOfMaterials; // Contiene la cantidad de materiales
        int ubication = 0; // Opcion de la ubicacion del material

        System.out.println("Write the amount of materials solicited by the foreman:");
        amountOfMaterials = sc.nextInt();
		sc.nextLine();

        namesOfMaterials = new String[amountOfMaterials];
        pricesOfMaterialsInHC = new double[amountOfMaterials];
        pricesOfMaterialsInFC = new double[amountOfMaterials];
        pricesOfMaterialsInFB = new double[amountOfMaterials];
        bestPrices = new double[amountOfMaterials];
        amountOfEveryMaterial = new int[amountOfMaterials];
        buildingTypeMaterials = new BuildingType[amountOfMaterials];
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
        System.out.println("");

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
        System.out.println("");
        System.out.println("The total value of the materials are: "+totalForBestPrices(bestPrices, amountOfEveryMaterial, amountOfMaterials, ubication, buildingTypeMaterials));
        System.out.println("");

        arrayOfTypes(namesOfMaterials, amountOfMaterials, buildingTypeMaterials);
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

    public static BuildingType[] buildingTypeOfEachMaterial(String[] arrayNames, int amountOfMaterials){
        int option;
        BuildingType[] arrayType = new BuildingType[amountOfMaterials];
        for(int i = 0; i<amountOfMaterials; i++){
            System.out.print(arrayNames[i]+": ");
            option = sc.nextInt();
            switch(option){
                case 1:
                    arrayType[i] = BuildingType.WHITE;
                break;
                case 2:
                    arrayType[i] = BuildingType.BLACK;
                break;
                case 3:
                    arrayType[i] = BuildingType.PAINTING;
                break;
            }
        }
        return arrayType;
    }

    /**
     * Calculates the total of the materials in a stablishment. <br>
     * <b>pre: <b/> You need an array with the price of each material in the stablishment. <br>
     * <b>post: <b/> <br>
     * @param stablishment double array, contains the prices of the materials in the stablishment.
     * @param amountOfEachMaterial int array, amount of each material that gonna be purchased.
     * @param amountOfMaterials int, amount of materials that gonna be purchased.
     * @param typeOfBuilding BuildingType array, contains the type of building for each material.
     * @return total, double that contains the total price for the stablishment.
     */
    public static double totalForEachStablishment(double[] stablishment, int[] amountOfEachMaterial, int amountOfMaterials, BuildingType[] typeOfBuilding){
        int blackType = 0;
        int whiteType = 0;
        int paintingType = 0;
        double total = 0;
        for(int i = 0; i<amountOfMaterials; i++){
            total += (stablishment[i]*amountOfEachMaterial[i]);
            if(typeOfBuilding[i]==BuildingType.WHITE){
                whiteType++;
            }
            else if(typeOfBuilding[i]==BuildingType.BLACK){
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

    /**
     * Calculates the total price of the materials, using the best price for each material and adds the delivery. <br>
     * <b>pre: <b/> You need an array with the best prices for each stablishment, an array with the amount of each material, and array with the building type of each material. <br>
     * <b>post: <b/> <br>
     * @param bestPrices double array, contains the best price for each material.
     * @param amountOfEachMaterial int array, contains the quantity of each material.
     * @param amountOfMaterials int, the amount of materials that gonna be purchased.
     * @param ubication int, option of the ubication where is the building.
     * @param typeOfBuilding BuildingType array, contains the building type of each material.
     * @return total, double that is the total of the count.
     */
    public static double totalForBestPrices(double[] bestPrices, int[] amountOfEachMaterial, int amountOfMaterials, int ubication, BuildingType[] typeOfBuilding){
        int blackType = 0;
        int whiteType = 0;
        int paintingType = 0;
        double total = 0;
        for(int i = 0; i<amountOfMaterials; i++){
            total += (bestPrices[i]*amountOfEachMaterial[i]);
            if(typeOfBuilding[i]==BuildingType.WHITE){
                whiteType++;
            }
            else if(typeOfBuilding[i]==BuildingType.BLACK){
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

    /**
     * Prints the ammount of material for each type of building <br>
     * <b>pre: <b/> You need an array with the type of building of each material <br>
     * <b>pos: <b/> <br>
     * @param nameOfMaterials String array, contains the name of each material
     * @param amountOfMaterials int, is the ammount of the materials that gonna be purchased
     * @param typeOfBuilding BuildingType array, contains the type of building of each material.
     */
    public static void arrayOfTypes(String[] nameOfMaterials, int amountOfMaterials, BuildingType[] typeOfBuilding){
        int counterB = 0;
        int counterW = 0;
        int counterP = 0;
        String[] whiteArray;
        String[] blackArray;
        String[] paintingArray;
        for(int i = 0; i<amountOfMaterials; i++){
            if(typeOfBuilding[i]==BuildingType.WHITE){
                counterW++;
            } else if(typeOfBuilding[i]==BuildingType.BLACK){
                counterB++;
            } else{
                counterP++;
            }
        }
        whiteArray = new String[counterW];
        blackArray = new String[counterB];
        paintingArray = new String[counterP];
        counterB = 0;
        counterW = 0;
        counterP = 0;
        for(int i = 0; i<amountOfMaterials; i++){
            if(typeOfBuilding[i]==BuildingType.WHITE){
                whiteArray[counterW] = nameOfMaterials[i];
                counterW++;
            } else if(typeOfBuilding[i]==BuildingType.BLACK){
                blackArray[counterB] = nameOfMaterials[i];
                counterB++;
            } else{
                paintingArray[counterP] = nameOfMaterials[i];
                counterP++;
            }
        }
        if(counterW>0){
            System.out.println("Los materiales de la obra blanca son: ");
            for(int i = 0; i<whiteArray.length; i++){
                System.out.println(whiteArray[i]);
            }
        } else{
            System.out.println("No hay materiales de obra blanca");
        }
        if(counterB>0){
            System.out.println("Los materiales de la obra negra son: ");
            for(int i = 0; i<blackArray.length; i++){
                System.out.println(blackArray[i]);
            }
        } else{
            System.out.println("No hay materiales de obra negra");
        }
        if(counterP>0){
            System.out.println("Los materiales de pintura son: ");
            for(int i = 0; i<paintingArray.length; i++){
                System.out.println(paintingArray[i]);
            }
        } else{
            System.out.println("No hay materiales de pintura");
        }
    }
}