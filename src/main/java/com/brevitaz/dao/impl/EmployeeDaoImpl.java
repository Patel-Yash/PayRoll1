package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.dao.EmployeeDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.Employee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao
{
    private final String TYPE_NAME = "doc";

    @Value("${elasticsearch.Employee-IndexName}")
    private String indexName;

    @Autowired
    private Config config;

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(EmployeeDaoImpl.class);


    @Override
    public boolean create(Employee employee){
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        IndexRequest request = new IndexRequest(
                indexName,
                TYPE_NAME,employee.getId()
        );

        try {
            String json = config.getObjectMapper().writeValueAsString(employee);
            request.source(json, XContentType.JSON);
            IndexResponse indexResponse = config.getClient().index(request);
            System.out.println(indexResponse);
            if(indexResponse.status() == RestStatus.CREATED)
            {
                LOGGER.info("Employee Created!!"+employee);
                return true;
            }
        }
        catch (IOException e)
        {
            LOGGER.error("Error while serialiazing employee: {}",e);
        }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employees = new ArrayList<>();
        SearchRequest request = new SearchRequest(indexName);
        request.types(TYPE_NAME);

        try {
            SearchResponse response = config.getClient().search(request);
            SearchHit[] hits = response.getHits().getHits();

            Employee employee;

            for (SearchHit hit : hits)
            {
                employee = config.getObjectMapper().readValue(hit.getSourceAsString(), Employee.class);
                employees.add(employee);
            }

            if(response.status() == RestStatus.OK)
            {
                return employees;
            }
        }
        catch (IOException e) {
            LOGGER.error("Error while serialiazing employee: {}",e);
        }
        return null;

    }

    @Override
    public boolean update(String id,Employee employee) {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName,TYPE_NAME,
                    id).doc(config.getObjectMapper().writeValueAsString(employee), XContentType.JSON);
            UpdateResponse updateResponse = config.getClient().update(updateRequest);
            System.out.println("Update: "+updateResponse);
            if(updateResponse.status() == RestStatus.OK)
            {
                LOGGER.info("Update Successfull!!");
                return true;
            }

        } catch (IOException e) {
            LOGGER.error("Error while serialiazing employee: {}",e);
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        DeleteRequest request = new DeleteRequest(
                indexName,
                TYPE_NAME,
                id);

        try {
            DeleteResponse response = config.getClient().delete(request);
            if(response.status() == RestStatus.OK)
            {
                LOGGER.info("Employee Deleted!!!");
                return true;
            }
        } catch (IOException e) {
            LOGGER.error("Error while serialiazing employee: {}",e);
        }
        return false;
    }

    @Override
    public Employee getById(String id) {
        GetRequest getRequest = new GetRequest(
                indexName,
                TYPE_NAME,
                id);

        try {

            GetResponse response = config.getClient().get(getRequest);
            if (response.isExists()) {
                Employee employee = config.getObjectMapper().readValue(response.getSourceAsString(), Employee.class);
                LOGGER.info("Employee is:-" +employee);
                return employee;
            } else {
                LOGGER.info("Employee doesnot exists!!!");
                return null;
            }
        }
        catch (IOException | NullPointerException e)
        {
            LOGGER.error("Employee doesn't exists!!!",e);
            throw new InvalidIdException("Doesn't exists!!!");
        }
    }
}
