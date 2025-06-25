package com.danieldupree.conversor;

import com.google.gson.annotations.SerializedName;

public class ExchangeResponse {
    @SerializedName("base_code")
    private String baseCode;

    @SerializedName("target_code")
    private String targetCode;

    @SerializedName("conversion_rate")  // Mapeia o campo do JSON corretamente
    private double conversionRate;

    public double getConversionRate() {
        return conversionRate;
    }
}