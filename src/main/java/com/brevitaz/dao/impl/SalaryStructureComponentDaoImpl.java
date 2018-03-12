package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.dao.SalaryStructureComponentDao;
import com.brevitaz.model.SalaryStructureComponent;
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
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalaryStructureComponentDaoImpl implements SalaryStructureComponentDao {

    private final String TYPE_NAME = "doc";

    @Value("${SalaryStructureComponent-Index-Name}")
    private String indexName;

    @Autowired
    private Config config;

    @Override
    public boolean create(SalaryStructureComponent salaryStructureComponent) {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            IndexRequest request = new IndexRequest(
                    indexName,
                    TYPE_NAME, salaryStructureComponent.getId()
            );

            String json = config.getObjectMapper().writeValueAsString(salaryStructureComponent);

            request.source(json, XContentType.JSON);

            IndexResponse indexResponse = config.getClient().index(request);

            System.out.println(indexResponse);
            if (indexResponse.status() == RestStatus.CREATED) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<SalaryStructureComponent> getAll(){
        List<SalaryStructureComponent > salaryStructureComponents = new ArrayList<>();
        try {
            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);
            SearchResponse response = config.getClient().search(request);
            SearchHit[] hits = response.getHits().getHits();

            SalaryStructureComponent salaryStructureComponent;

            for (SearchHit hit : hits) {
                salaryStructureComponent = config.getObjectMapper().readValue(hit.getSourceAsString(), SalaryStructureComponent.class);
                salaryStructureComponents.add(salaryStructureComponent);
            }
            if (response.status() == RestStatus.OK)
            {
                return salaryStructureComponents;
            }
            else
            {
                return null;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(SalaryStructureComponent salaryStructureComponent,String id) {
        ObjectMapper objectMapper = new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
        try {
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName, TYPE_NAME,
                    id).doc(objectMapper.writeValueAsString(salaryStructureComponent), XContentType.JSON);
            UpdateResponse updateResponse = config.getClient().update(updateRequest);
            System.out.println("Update: " + updateResponse);
            if (updateResponse.status() == RestStatus.OK)
            {
                return true;
            }
            else
            {
                return false;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        try {
            DeleteRequest request = new DeleteRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            DeleteResponse response = config.getClient().delete(request);

            System.out.println(response.status());

            System.out.println(response);
            if (response.status() == RestStatus.OK){
            return true;}
            else
            {
                return false;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public SalaryStructureComponent getById(String id) {
        try {
            GetRequest getRequest = new GetRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            GetResponse getResponse = config.getClient().get(getRequest);

            SalaryStructureComponent salaryStructureComponent = config.getObjectMapper().readValue(getResponse.getSourceAsString(), SalaryStructureComponent.class);

            System.out.println(salaryStructureComponent);
            if (getResponse.isExists()){
            return salaryStructureComponent;}
            else
            {
                return null;
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
