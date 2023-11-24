package com.example.centralapplication.converter;

import com.example.centralapplication.dto.CentralDto;
import com.example.centralapplication.entity.CentralEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DtoConverter {

    public CentralDto entiyToDto(CentralEntity centralEntity) {

        CentralDto centralDto = new CentralDto();

        centralDto.setId(centralEntity.getId());
        centralDto.setServiceName(centralEntity.getServiceName());
        centralDto.setRequestTime(centralEntity.getRequestTime());
        centralDto.setResponseTime(centralEntity.getResponseTime());
        centralDto.setStatusCode(centralEntity.getStatusCode());
        centralDto.setTimeTaken(centralEntity.getTimeTaken());
        centralDto.setRequestURI(centralEntity.getRequestURI());
        centralDto.setRequestMethod(centralEntity.getRequestMethod());
        centralDto.setRequestHeaderName(centralEntity.getRequestHeaderName());
        centralDto.setContentType(centralEntity.getContentType());
        centralDto.setQueryParam(centralEntity.getQueryParam());
        centralDto.setRequestID(centralEntity.getRequestID());
        centralDto.setHostName(centralEntity.getHostName());
        centralDto.setResponse(centralEntity.getResponse());
        centralDto.setErrorTrace(centralEntity.getErrorTrace());

        return centralDto;
    }

    public List<CentralDto> entitiesToDtos(List<CentralEntity> centralEntities) {
        return centralEntities.stream()
                .map(this::entiyToDto)
                .collect(Collectors.toList());
    }

    public CentralEntity dtoToEntity(CentralDto centralDto) {

        CentralEntity centralEntity = new CentralEntity();

        centralEntity.setId(centralDto.getId());
        centralEntity.setServiceName(centralDto.getServiceName());
        centralEntity.setResponseTime(centralDto.getResponseTime());
        centralEntity.setResponseTime(centralDto.getResponseTime());
        centralEntity.setStatusCode(centralDto.getStatusCode());
        centralEntity.setTimeTaken(centralDto.getTimeTaken());
        centralEntity.setRequestURI(centralDto.getRequestURI());
        centralEntity.setRequestMethod(centralDto.getRequestMethod());
        centralEntity.setRequestHeaderName(centralDto.getRequestHeaderName());
        centralEntity.setContentType(centralDto.getContentType());
        centralEntity.setQueryParam(centralDto.getQueryParam());
        centralEntity.setRequestID(centralDto.getRequestID());
        centralEntity.setHostName(centralDto.getHostName());
        centralEntity.setResponse(centralDto.getResponse());
        centralEntity.setErrorTrace(centralDto.getErrorTrace());

        return centralEntity;
    }

    public List<CentralEntity> dtoToEntity(List<CentralDto> centralDtos) {
        return centralDtos.stream()
                .map(this::dtoToEntity)
                .collect(Collectors.toList());
    }
}
