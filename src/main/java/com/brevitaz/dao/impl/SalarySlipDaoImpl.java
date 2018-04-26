package com.brevitaz.dao.impl;

import com.brevitaz.config.Config;
import com.brevitaz.dao.SalarySlipDao;
import com.brevitaz.errors.InvalidIdException;
import com.brevitaz.model.Salary;
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
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class SalarySlipDaoImpl implements SalarySlipDao {
    private final String TYPE_NAME = "doc";

    @Value("${elasticsearch.SalarySlip-IndexName}")
    private String indexName;

    @Autowired
    private Config config;


    @Override
    public boolean create(SalarySlip salarySlip) {
        config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        try {
            IndexRequest request = new IndexRequest(
                    indexName,
                    TYPE_NAME, salarySlip.getId()
            );

            String json = config.getObjectMapper().writeValueAsString(salarySlip);

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
    public List<SalarySlip> getAll() {
        try {
            List<SalarySlip> salarySlips = new ArrayList<>();
            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);
            SearchResponse response = config.getClient().search(request);
            SearchHit[] hits = response.getHits().getHits();

            SalarySlip salarySlip;

            for (SearchHit hit : hits) {
                salarySlip = config.getObjectMapper().readValue(hit.getSourceAsString(), SalarySlip.class);
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
    public boolean update(String id,SalarySlip salarySlip) {
        try {
            config.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
            UpdateRequest updateRequest = new UpdateRequest(
                    indexName, TYPE_NAME,
                    id).doc(config.getObjectMapper().writeValueAsString(salarySlip), XContentType.JSON);
            UpdateResponse updateResponse = config.getClient().update(updateRequest);
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

   /* @Override
    public boolean delete(String id) {
        try {
            DeleteRequest request = new DeleteRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            DeleteResponse response = config.getClient().delete(request);

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
*/
    @Override
    public SalarySlip getById(String id) {
        try {
            GetRequest getRequest = new GetRequest(
                    indexName,
                    TYPE_NAME,
                    id);

            GetResponse getResponse = config.getClient().get(getRequest);

            SalarySlip salarySlip = config.getObjectMapper().readValue(getResponse.getSourceAsString(), SalarySlip.class);

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
        catch (IOException |NullPointerException e)
        {
            throw new InvalidIdException("Id doesnot exists!!!");
        }
    }

    @Override
    public List<SalarySlip> getByEmployeeId(String employeeId) {
        try {

            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

            sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("employeeId", employeeId)));
            request.source(sourceBuilder);

            SearchResponse response = config.getClient().search(request);
            if(response.status() == RestStatus.OK) {
                List<SalarySlip> salarySlips=new ArrayList<>();

                SearchHit[] hits = response.getHits().getHits();

                SalarySlip salarySlip;
                for (SearchHit hit : hits)
                {
                    salarySlip = config.getObjectMapper().readValue(hit.getSourceAsString(),SalarySlip.class);
                    salarySlips.add(salarySlip);
                }

                return salarySlips;
            }
        } catch (IOException | NullPointerException e) {
            throw new InvalidIdException("doesn't exists!!!");
        }
        return null;
    }


    @Override
    public List<SalarySlip> getByMonth(String month) {
        try {

            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();

            sourceBuilder.query(QueryBuilders.boolQuery().must(matchQuery("month",month)));
            request.source(sourceBuilder);

            SearchResponse response = config.getClient().search(request);
            if(response.status() == RestStatus.OK) {
                List<SalarySlip> salarySlips=new ArrayList<>();

                SearchHit[] hits = response.getHits().getHits();

                SalarySlip salarySlip;
                for (SearchHit hit : hits)
                {
                    salarySlip = config.getObjectMapper().readValue(hit.getSourceAsString(),SalarySlip.class);
                    salarySlips.add(salarySlip);
                }

                return salarySlips;
            }
        } catch (IOException | NullPointerException e) {
            throw new InvalidIdException("doesn't exists!!!");
        }
        return null;

    }

    @Override
    public SalarySlip getLatestSalarySlip(List<SalarySlip> salarySlips) {
        try {
            //List<SalarySlip> salarySlips = new ArrayList<>();

            SearchRequest request = new SearchRequest(indexName);
            request.types(TYPE_NAME);

            SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
            sourceBuilder.sort("createdDate", SortOrder.DESC);

            request.source(sourceBuilder);

            SearchResponse response = config.getClient().search(request);
            if(response.status() == RestStatus.OK)
            {

                SearchHit[] hits = response.getHits().getHits();
                SalarySlip salarySlip;

                for (SearchHit hit : hits)
                {
                    salarySlip = config.getObjectMapper().readValue(hit.getSourceAsString(), SalarySlip.class);
                    salarySlips.add(salarySlip);
                }
                return salarySlips.get(0);
            }
            else
            {
                return null;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            //  throw new IndexNotFoundException("Index doesn't exists!!!");
        }
        return null;
    }
}
