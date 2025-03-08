package com.tsswebapps.lapinformatica.whatslap.api.local.dto;

public class MensagemPadrao {
    private String Token;
    private String VersaoApi;
    private String PhoneNumberId;

    public MensagemPadrao(String token, String versaoApi, String phoneNumberId) {
        Token = token;
        VersaoApi = versaoApi;
        PhoneNumberId = phoneNumberId;
    }

    public MensagemPadrao() {
    }

    public String getToken() {
        return Token;
    }

    public String getVersaoApi() {
        return VersaoApi;
    }

    public String getPhoneNumberId() {
        return PhoneNumberId;
    }

    @Override
    public String toString() {
        return "MensagemPadrao{" +
                "Token='" + Token + '\'' +
                ", VersaoApi='" + VersaoApi + '\'' +
                ", PhoneNumberId='" + PhoneNumberId + '\'' +
                '}';
    }
}
