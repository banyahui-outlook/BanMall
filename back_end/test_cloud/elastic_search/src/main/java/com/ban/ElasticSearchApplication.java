package com.ban;

import com.ban.entity.Hotel;
import com.ban.service.IHotelService;
import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticSearchApplication implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ElasticSearchApplication.class, args);
    }

    @Autowired
    private IHotelService hotelService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Hotel hotel = hotelService.getById(36934L);
        System.out.println(hotel);

        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("192.168.1.11", 9200, "http")
                )
        );


//        CreateIndexRequest createIndexRequest = new CreateIndexRequest("hotel");
//        createIndexRequest.source("{\n" +
//                "  \"settings\": {\n" +
//                "    \"analysis\": {\n" +
//                "      \"analyzer\": {\n" +
//                "        \"chi_analyzer\":{\n" +
//                "          \"type\": \"custom\",\n" +
//                "          \"filter\": \"lowercase\",\n" +
//                "          \"tokenizer\": \"ik_max_word\"\n" +
//                "        }\n" +
//                "      }\n" +
//                "    }\n" +
//                "  },\n" +
//                "  \"mappings\": {\n" +
//                "    \"properties\": {\n" +
//                "      \"id\": {\n" +
//                "        \"type\": \"keyword\"\n" +
//                "      },\n" +
//                "      \"name\":{\n" +
//                "        \"type\": \"text\",\n" +
//                "        \"analyzer\": \"ik_smart\"\n" +
//                "      }\n" +
//                "    }\n" +
//                "  }\n" +
//                "}", XContentType.JSON);
//        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(createIndexResponse);

//        GetIndexRequest getIndexRequest = new GetIndexRequest("hotel");
//        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(exists);

//        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest("hotel");
//        AcknowledgedResponse acknowledgedResponse = client.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(acknowledgedResponse);
//
//        GetIndexRequest getIndexRequest = new GetIndexRequest("hotel");
//        boolean exists = client.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
//        System.out.println(exists);


//        IndexRequest indexRequest = new IndexRequest("hotel");
//        indexRequest.id("1");
//        String jsonString = "{" +
//                "\"name\":\"zhangsan\"" +
//                "}";
//        indexRequest.source(jsonString, XContentType.JSON);
//        IndexResponse indexResponse = client.index(indexRequest, RequestOptions.DEFAULT);
//        System.out.println(indexResponse);

//        GetRequest getRequest = new GetRequest("hotel", "1");
//        GetResponse getResponse = client.get(getRequest, RequestOptions.DEFAULT);
//        System.out.println(getResponse);

//        UpdateRequest updateRequest = new UpdateRequest("hotel", "1");
//        String jsonString = "{" +
//                "\"name\":\"liis\"" +
//                "}";
//        updateRequest.doc(jsonString, XContentType.JSON);
//        updateRequest.docAsUpsert(true);
//        UpdateResponse updateResponse = client.update(updateRequest, RequestOptions.DEFAULT);
//        System.out.println(updateResponse);


//        DeleteRequest deleteRequest = new DeleteRequest("hotel", "1");
//        DeleteResponse deleteResponse = client.delete(deleteRequest, RequestOptions.DEFAULT);
//        System.out.println(deleteResponse);

    }
}
