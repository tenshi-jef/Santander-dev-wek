package me.dio.santander_dev_week_2023.Response;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

public class ApiResponse {
    public ApiResponse(Object data, String errorMessage, HttpStatus statusMessage) {
        this.data = data;
        this.errorMessage = errorMessage;
        this.statusMessage = statusMessage;
    }

    @JsonProperty("data")
    public Object data;

    @JsonProperty("errorMessage")
    public String errorMessage;

    @JsonProperty("statusMessage")
    public HttpStatus statusMessage;
}
