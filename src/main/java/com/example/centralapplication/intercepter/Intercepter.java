package com.example.centralapplication.intercepter;

import com.example.centralapplication.entity.CentralEntity;
import com.example.centralapplication.service.CentralService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;


@Component
@Slf4j
public class Intercepter implements HandlerInterceptor {
    private long startTime;

    @Autowired
    private CentralService centralService;

    Date requestTime = new Date(); // Capture the current date and time

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        startTime = System.currentTimeMillis();
        Date requestTime = new Date(); // Capture the current date and time
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Request Time: " + dateFormat.format(requestTime));
        request.setAttribute("startTime", startTime);
        return true;

    }


    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           @Nullable ModelAndView modelAndView) throws Exception {
    }


    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                @Nullable Exception ex) throws Exception {

        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        Date responseTime = new Date(); // Capture the current date and time for response
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        CentralEntity centralEntity = new CentralEntity();

        //for error trace
        String errorStackTrace = null;
        if (ex != null) {
            // Capture the exception stack trace in a variable
            StringWriter sw = new StringWriter();
            ex.printStackTrace(new PrintWriter(sw));
            errorStackTrace = sw.toString();
            System.out.println(" error trace : " + errorStackTrace);
        }

        //for response
        ContentCachingResponseWrapper wrapper;
        if (response instanceof ContentCachingResponseWrapper) {
            wrapper = (ContentCachingResponseWrapper) response;
        } else {
            wrapper = new ContentCachingResponseWrapper(response);
        }
        String responseContent = getResponse(wrapper);


//        ContentCachingResponseWrapper wrapper = (ContentCachingResponseWrapper) response;
//        String responseContent = getResponse(wrapper);



        System.out.println("Response Time: " + dateFormat.format(responseTime));
        System.out.println("Response Time: " + dateFormat.format(responseTime));
        System.out.println("Status Code :" + response.getStatus());
        System.out.println("Time Taken : " + timeTaken + " ms");
        System.out.println("Context path : " + request.getRequestURI());
        System.out.println("Method Used : " + request.getMethod());
        System.out.println("Content Type : " + request.getContentType());
        System.out.println("Request ID : " + request.getRequestId());
        System.out.println("Host Name : " + request.getServerName());
        System.out.println("Response Content: " + responseContent);


        //for storing into database
        centralEntity.setRequestTime(dateFormat.format(requestTime));
        centralEntity.setResponseTime(dateFormat.format(responseTime));
        centralEntity.setStatusCode(response.getStatus());
        centralEntity.setTimeTaken(String.valueOf(timeTaken));
        centralEntity.setRequestURI(request.getRequestURI());
        centralEntity.setRequestMethod(request.getMethod());
        centralEntity.setRequestHeaderName(getRequestHeaderNames(request));
        centralEntity.setContentType(request.getContentType());
        centralEntity.setRequestID(request.getRequestId()); //
        centralEntity.setHostName(request.getServerName());
        centralEntity.setResponse(responseContent);
        centralEntity.setErrorTrace(errorStackTrace);


//        centralService.saveEntity(centralEntity);


    }


    private String getRequestHeaderNames(HttpServletRequest request) {
        Enumeration<String> headerNames = request.getHeaderNames();
        StringBuilder headerNamesStr = new StringBuilder();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headerNamesStr.append(headerName).append(", ");
        }
        return headerNamesStr.toString();
    }

    private String getResponse(ContentCachingResponseWrapper contentCachingResponseWrapper) {

        String response = IOUtils.toString(contentCachingResponseWrapper.getContentAsByteArray(), contentCachingResponseWrapper.getCharacterEncoding());
        return response;
    }


}


