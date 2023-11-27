package com.example.centralapplication.dto;

import lombok.Data;

@Data
public class CentralDto {
    private String serviceName = "microservice-one";
    private long id;

    //extra fields
    private String requestTime;
    private String responseTime;
    private int StatusCode;
    private String timeTaken;
    private String requestURI;
    private String requestMethod;
    private String requestHeaderName;
    private String contentType;
    private String queryParam;
    private String requestID;
    private String hostName;
    private String response;
    private String errorTrace;
    private String client_id;
}
