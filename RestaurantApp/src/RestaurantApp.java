import java.util.Scanner;

public class RestaurantApp {

	public static void main(String[] args) {
		
		// DATA LAYER
		final double feeDelivery = 50.00;
        final String CURRENCY = "MDL";
        
        final String FOOD_1_NAME = "Pizza";
        int food_1_available_quantity = 5; 
        final float FOOD_1_PRICE = 75.5f;
        
        final String FOOD_2_NAME = "Mamaliga";
        int food_2_available_quantity = 5;
        final float FOOD_2_PRICE = 150f;
        
        final String FOOD_3_NAME = "Salad";
        final float FOOD_3_PRICE = 30f;
        int food_3_available_quantity = 5;
        

        // PRESENTATION & LOGIC LAYER
        System.out.printf("\n********** MENU ***********\n" +
                        "1. \"%-5s\" %12.2f %s\n" +
                        "2. \"%-8s\" %9.2f %s\n" +
                        "3. \"%-5s\" %12.2f %s\n" +
                        "***************************\n\n",
                FOOD_1_NAME, FOOD_1_PRICE, CURRENCY,
                FOOD_2_NAME, FOOD_2_PRICE, CURRENCY,
                FOOD_3_NAME, FOOD_3_PRICE, CURRENCY);
        
        System.out.print("CHOOSE AN OPTION >>> ");
        Scanner in = new Scanner(System.in);
        //scanner
        int option = in.nextInt();

        if (option == 1) {
            System.out.printf("Your choise is: \"%s\"\n", FOOD_1_NAME);
            System.out.print("How many do you want ? ");
            
            //scanner
            int countOrderProduct = in.nextInt();
            
            if( countOrderProduct <= food_1_available_quantity && countOrderProduct > 0) {
            	double totalForPay = (double) countOrderProduct * FOOD_1_PRICE;
            	System.out.printf(" %d x \"%s\"   (%.2f%s) = %.2f %s\n" +
            					"Confirm order ( 1 - yes, 0 - no )?", 
            			countOrderProduct, FOOD_1_NAME, FOOD_1_PRICE, CURRENCY, totalForPay, CURRENCY
            			);
            	
                //scanner
            	int confirmOrder = in.nextInt();
            	
            	if ( confirmOrder == 1) {
            		System.out.printf("THANK YOU.\n" +
            				"Your order will be available in 30 minutes!\n" + 
            				"Will you pick up the product or do you want it delivered?\n" + 
            				"Choose an option order ( 1 - Delivery (fee - %.2f%s), 0 - Pickup (0%s) )? ",
            			feeDelivery, CURRENCY, CURRENCY);
            		
            		//scanner
                	int receiveOrder = in.nextInt();
                	if (receiveOrder == 1 && totalForPay <= 199) {
                		double totalForPayAndDelivery = (double) (countOrderProduct * FOOD_1_PRICE) + feeDelivery;
                    	System.out.printf(" %d x \"%s\"   (%.2f%s) = %.2f %s\n" +
                    					"+ Delivery fee: %.2f%s\n" +
                    					"Total: %.2f%s" +
                    					"Confirm order with Delivery fee ( 1 - yes, 0 - no )?", 
                    			countOrderProduct, FOOD_1_NAME, FOOD_1_PRICE, CURRENCY, totalForPay, CURRENCY, 
                    			feeDelivery, CURRENCY,
                    			totalForPayAndDelivery, CURRENCY
                    			);
                    	//scanner
                    	int confirmOrderDelivery = in.nextInt();
                    	if ( confirmOrderDelivery == 1 ) {
                    		System.out.printf("THANK YOU.\n" +
                    				"Your order will be delivered in one hour!\n");
                    	} else {
                    		System.out.printf("OHHH...\n" +
                    				"...seeing you soon!");
                    	}
                    
                	}else if (receiveOrder == 1 && totalForPay > 199){
                		System.out.printf("THANK YOU.\n" +
                				"Delivery fee: 0%s\n" +
                				"TOTAL: %f%s" +
                				"Your order will be delivered in one hour!\n", 
                				CURRENCY,
                				totalForPay, CURRENCY);
                	}else if (receiveOrder == 0) {
                		System.out.printf("THANK YOU.\n" +
                				"Your order will be available in 30 minutes!\n" + 
                				"we are waiting for you");
                	}
            		
            	} else {
            		System.out.printf("OHHH...\n" +
            				"...seeing you soon!");
            	}
            	
            } else {
            	System.out.printf("You've ordered too many \"%s\", we only have %d\r\n"
            			+ "PLEASE TRY AGAIN!",
            			FOOD_1_NAME, food_1_available_quantity);

            }
        }
   } 

}


