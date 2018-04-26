package com.brevitaz.config;

import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.client.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class IndexInitializer
{
    @Autowired
    private Config config;

    @Value("${elasticsearch.Employee-IndexName}")
    private String employeeIndex;

    @Value("${elasticsearch.Salary-IndexName}")
    private String salaryIndex;

    @Value("${elasticsearch.SalarySlip-IndexName}")
    private String salarySlipIndex;

    @Value("${elasticsearch.SalaryStructure-IndexName}")
    private String salaryStructureIndex;

    private CreateIndexRequest indexRequest;

    private String indexName;

    @PostConstruct
    public void doInitialSetup() {
        List<String> indexNames = new ArrayList<>();
        indexNames.add(employeeIndex);
        indexNames.add(salaryIndex);
        indexNames.add(salarySlipIndex);
        indexNames.add(salaryStructureIndex);

        System.out.println(indexNames);

        for (String indexName : indexNames) {
            if (isIndexExists(indexName)==false)
            {
                createIndexIfNotExists(indexName);
            }
        }
    }

    private void createIndexIfNotExists(String indexName)
    {
        try {
            CreateIndexRequest request = new CreateIndexRequest(indexName);
            CreateIndexResponse createIndexResponse = config.getClient().indices().create(request);
            boolean acknowledged = createIndexResponse.isAcknowledged();
            System.out.println("IndexCreated!!!"+acknowledged);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isIndexExists(String indexName) {
        boolean isExist = true;
        try {
            Response response;
            response = config.getClient().getLowLevelClient().performRequest("HEAD", "/" + indexName);
            int statusCode = response.getStatusLine().getStatusCode();
            if(statusCode == 404)
            {
                System.out.println("=============================================================");
                isExist = false;
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        return isExist;
    }
}
