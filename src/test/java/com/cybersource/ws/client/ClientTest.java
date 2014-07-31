/*
* Copyright 2003-2014 CyberSource Corporation
*
* THE SOFTWARE AND THE DOCUMENTATION ARE PROVIDED ON AN "AS IS" AND "AS
* AVAILABLE" BASIS WITH NO WARRANTY.  YOU AGREE THAT YOUR USE OF THE SOFTWARE AND THE
* DOCUMENTATION IS AT YOUR SOLE RISK AND YOU ARE SOLELY RESPONSIBLE FOR ANY DAMAGE TO YOUR
* COMPUTER SYSTEM OR OTHER DEVICE OR LOSS OF DATA THAT RESULTS FROM SUCH USE. TO THE FULLEST
* EXTENT PERMISSIBLE UNDER APPLICABLE LAW, CYBERSOURCE AND ITS AFFILIATES EXPRESSLY DISCLAIM ALL
* WARRANTIES OF ANY KIND, EXPRESS OR IMPLIED, WITH RESPECT TO THE SOFTWARE AND THE
* DOCUMENTATION, INCLUDING ALL WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE,
* SATISFACTORY QUALITY, ACCURACY, TITLE AND NON-INFRINGEMENT, AND ANY WARRANTIES THAT MAY ARISE
* OUT OF COURSE OF PERFORMANCE, COURSE OF DEALING OR USAGE OF TRADE.  NEITHER CYBERSOURCE NOR
* ITS AFFILIATES WARRANT THAT THE FUNCTIONS OR INFORMATION CONTAINED IN THE SOFTWARE OR THE
* DOCUMENTATION WILL MEET ANY REQUIREMENTS OR NEEDS YOU MAY HAVE, OR THAT THE SOFTWARE OR
* DOCUMENTATION WILL OPERATE ERROR FREE, OR THAT THE SOFTWARE OR DOCUMENTATION IS COMPATIBLE
* WITH ANY PARTICULAR OPERATING SYSTEM.
*/

package com.cybersource.ws.client;

import com.cybersource.ws.client.Client;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Properties;

/**
 * Junit Test case for validating Client.java class.
 * This aimed at validating the Transaction which are sent as Name -value pair or HashMap as the input for Client.java
 * User: sunagara
 * 
 */
public class ClientTest {

    /**
     * validated the RunTransaction method of client.java
     */
    @Test
    public void testRunTransaction() throws Exception {
        HashMap<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("ccAuthService_run", "true");
        requestMap.put("merchantReferenceCode", "jasoneatoncorp");
        requestMap.put("billTo_firstName", "John");
        requestMap.put("billTo_lastName", "Doe");
        requestMap.put("billTo_street1", "1295 Charleston Road");
        requestMap.put("billTo_city", "Mountain View");
        requestMap.put("billTo_state", "CA");
        requestMap.put("billTo_postalCode", "94043");
        requestMap.put("billTo_country", "US");
        requestMap.put("billTo_email", "nobody@cybersource.com");
        requestMap.put("billTo_ipAddress", "10.7.7.7");
        requestMap.put("billTo_phoneNumber", "650-965-6000");
        requestMap.put("shipTo_firstName", "Jane");
        requestMap.put("shipTo_lastName", "Doe");
        requestMap.put("shipTo_street1", "100 Elm Street");
        requestMap.put("shipTo_city", "San Mateo");
        requestMap.put("shipTo_state", "CA");
        requestMap.put("shipTo_postalCode", "94401");
        requestMap.put("shipTo_country", "US");
        requestMap.put("card_accountNumber", "4111111111111111");
        requestMap.put("card_expirationMonth", "12");
        requestMap.put("card_expirationYear", "2020");
        requestMap.put("purchaseTotals_currency", "USD");
        requestMap.put("item_0_unitPrice", "12.34");
        requestMap.put("item_1_unitPrice", "56.78");
        requestMap.put("merchant_id", "jasoneatoncorp");

        Properties merchantProperties = new Properties();
        merchantProperties.setProperty("merchantID", "jasoneatoncorp");
        merchantProperties.setProperty("keysDirectory", "src/test/resources");
        //merchantProperties.setProperty("keyAlias", "jasoneatoncorp");
        //merchantProperties.setProperty("keyPassword", "jasoneatoncorp");
        merchantProperties.setProperty("targetAPIVersion", "1.97");
        merchantProperties.setProperty("sendToProduction", "false");
        merchantProperties.setProperty("serverURL", "https://ics2wstest.ic3.com/commerce/1.x/transactionProcessor/");
       // merchantProperties.setProperty("serverURL", "http://mvqsstage002d.qa.intra:11080/commerce/1.x/transactionProcessor/");
        merchantProperties.setProperty("timeout", "1000");
        merchantProperties.setProperty("enableLog", "true");
        merchantProperties.setProperty("logDirectory", ".");
        merchantProperties.setProperty("logMaximumSize", "10");

        HashMap<String, String> replyMap = Client.runTransaction(requestMap, merchantProperties);
        Assert.assertEquals("100", replyMap.get("reasonCode"));
    }
}