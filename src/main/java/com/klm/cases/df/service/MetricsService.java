package com.klm.cases.df.service;

import com.klm.cases.df.model.ActuatorResponse;
import com.klm.cases.df.model.Metrics;
import com.klm.cases.df.model.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestOperations;

import java.util.List;

@Service
public class MetricsService {

    @Value("${actuator.url}")
    private String actuatorUrl;

    @Autowired
    private RestOperations restOperations;

    private long responseOKCount, response4XXCount, response5XXCount, totalRequestsCount, totalResponseTime, averageTime, minimumTime, maximumTime = 0;


    public Metrics getPerformanceMetrics(){
        ActuatorResponse actuatorResponse =restOperations.getForEntity(actuatorUrl, ActuatorResponse.class).getBody();
        return processPerformanceData(actuatorResponse);
    }

    private Metrics processPerformanceData(ActuatorResponse data){

        List<Trace> traces = data.getTraces();

        if (traces == null || traces.size() == 0) return new Metrics();
        for (Trace trace : traces){
            totalRequestsCount++;
            totalResponseTime += trace.getTimeTaken();
            maximumTime = Math.max(trace.getTimeTaken(),maximumTime);
            minimumTime = Math.min(trace.getTimeTaken(),minimumTime);
            int status = trace.getResponse().getStatus();
            if(status>=200 && status<300){
                responseOKCount++;
            }
            else if(status>=400 && status<500){
                response4XXCount++;
            }
            else if(status>=500){
                response5XXCount++;
            }
        }

        Metrics metrics = new Metrics();
        metrics.setTotalRequestsCount(totalRequestsCount);
        metrics.setResponseOKCount(responseOKCount);
        metrics.setResponse4XXCount(response4XXCount);
        metrics.setResponse5XXCount(response5XXCount);
        metrics.setMaxResponseTime(maximumTime);
        metrics.setMinResponseTime(minimumTime);
        metrics.setAvgResponseTime(totalResponseTime/totalRequestsCount);
        return metrics;
    }


}
