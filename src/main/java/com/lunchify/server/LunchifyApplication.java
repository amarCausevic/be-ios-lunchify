package com.lunchify.server;

import com.lunchify.config.ConfigFactory;
import com.lunchify.config.LunchifyConfig;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bson.BsonDocument;
import org.bson.BsonInt64;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LunchifyApplication {

  public static void main(String[] args) {
    final LunchifyConfig CONFIG = ConfigFactory.lunchifyConfig();
    final String uri = CONFIG.mongoConnectionString();
    final Logger LOGGER = LogManager.getLogger(LunchifyApplication.class);

    SpringApplication.run(LunchifyApplication.class, args);

    ServerApi serverApi = ServerApi.builder().version(ServerApiVersion.V1).build();

    MongoClientSettings settings = MongoClientSettings.builder()
        .applyConnectionString(new ConnectionString(uri))
        .serverApi(serverApi)
        .build();

    // Create a new client and connect to the servers
    try (MongoClient mongoClient = MongoClients.create(settings)) {
      MongoDatabase database = mongoClient.getDatabase("lunchify");

      try {
        // Send a ping to confirm a successful connection
        Bson command = new BsonDocument("ping", new BsonInt64(1));
        Document commandResult = database.runCommand(command);
        LOGGER.info("Pinged your deployment. You successfully connected to MongoDB!");
      } catch (MongoException me) {
        LOGGER.error(me);
      }
    }
  }

}
