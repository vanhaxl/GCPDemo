package com.example.GCPDemo.constant;

import java.util.Arrays;
import java.util.List;

public class AppConstant {
    public static final String DATE_TIME_PATTERN = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    public static final String TIME_ZONE_CST = "America/Chicago";
    public static final String TIME_ZONE_UTC = "UTC";


    public static final List<String> appNames = Arrays.asList(
            "cpc-bin-service", "cpc-cart-app", "cpc-checkout-app",
            "cpc-oper-auth", "cpc-order-management", "cpc-payment-auth",
            "cpc-tc-service", "girservice", "posoe", "receipt-service-app",
            "secrets-manager-cpc", "tiller-deploy", "wmtwebpos"
    );


}
