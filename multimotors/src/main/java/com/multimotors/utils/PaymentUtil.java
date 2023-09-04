package com.multimotors.utils;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.Charge;
import com.stripe.model.Token;
import com.stripe.param.TokenCreateParams;
import java.util.HashMap;

/**
 * @author Sergio
 * @author Fabian
 */
public class PaymentUtil {

    //Stripe.apiKey = "sk_test_51NBx2bJBTDUdg7G7yVvh2cZ2GitcIqStt8P5iZqntmIbZqESJ6UAA8hm70OZYEMHjONXl98W3mQfOGYqhv8BTezE000Ksoceje";
    //Stripe.apiKey = "pk_live_51NBx2bJBTDUdg7G7gKJ0m0qMMui3mz48ii1XaaHStF4wlPSo6jId1D2TjW5BLeEBQeAKX32Kx6SRl4WBJ0THUL4D006xIkomRR";
    
    public void paymentFunc(String number_card, String month, String year, String cvc) {
        
        Stripe.apiKey = "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";
        
        try {
            TokenCreateParams params = TokenCreateParams.builder()
                    .setCard(TokenCreateParams.Card.builder()
                            .setNumber(number_card)
                            .setExpMonth(month)
                            .setExpYear(year)
                            .setCvc(cvc)
                            .build())
                    .build();
            Token token = Token.create(params);
            HashMap<String, Object> chargeParams = new HashMap<>();

            chargeParams.put( "amount", 50); // Monto en centimos
            chargeParams.put( "currency", "eur");
            chargeParams.put( "source", token.getId());
            Charge charge = Charge.create(chargeParams);
            
            System.out.println("Cargo creado: " + charge.getId());
            
        } catch (StripeException e) {
            System.out.println("Error al completar pago");
        }
    }
}