package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.model.SalarySlip;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SalarySlipDaoImpl implements SalarySlipDao {
    private final String TYPE_NAME = "doc";

    @Value("${SalarySlip-Index-Name}")
    private String indexName;

    @Autowired
    private RestHighLevelClient client;

    @Autowired
    private ObjectMapper objectMapper;


    @Override
    public boolean create(SalarySlip salarySlip) {
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            IndexRequest request = new IndexRequest(
                    indexName,
                    TYPE_NAME, salarySlip.getId()
            );

            String json = objectMapper.writeValueAsString(salarySlip);

            request.source(json, XContentType.JSON);

            IndexResponse indexResponse = client.index(request);

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
    public List<SalarySlip> getAll() {
        try {
            List<SalarySlip> salarySlips = new ArrayList<>();
            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);
            SearchResponse response = client.search(request);
            SearchHit[] hits = response.getHits().getHits();

            SalarySlip salarySlip;

            for (SearchHit hit : hits) {
                salarySlip = objectMapper.readValue(hit.getSourceAsString(), SalarySlip.class);
                salarySlips.add(salarySlip);
            }
            if (response.status() == RestStatus.OK) {
                return salarySlips;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean update(SalarySlip salarySlip, String id) {
        try {
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName, TYPE_NAME,
                    id).doc(objectMapper.writeValueAsString(salarySlip), XContentType.JSON);
            UpdateResponse updateResponse = client.update(updateRequest);
            System.out.println("Update: " + updateResponse);
            if (updateResponse.status() == RestStatus.OK) {
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
    public boolean delete(String id) {
        try {
            DeleteRequest request = new DeleteRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            DeleteResponse response = client.delete(request);

            System.out.println(response.status());

            System.out.println(response);
            if (response.status() == RestStatus.OK) {
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
    public SalarySlip getById(String id) {
        try {
            GetRequest getRequest = new GetRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            GetResponse getResponse = client.get(getRequest);

            SalarySlip salarySlip = objectMapper.readValue(getResponse.getSourceAsString(), SalarySlip.class);

            System.out.println(salarySlip);
            if (getResponse.isExists())
            {
                return salarySlip;
            }
            else
            {
                return null;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }
}
