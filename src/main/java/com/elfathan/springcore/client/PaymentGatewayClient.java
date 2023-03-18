package com.elfathan.springcore.client;

import lombok.Data;

@Data
public class PaymentGatewayClient {
    private String url;
    private String privateKey;
    private String publicKey;
}
