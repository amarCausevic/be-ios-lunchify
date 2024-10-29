package com.lunchify.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;
import org.aeonbits.owner.Config.Sources;

@LoadPolicy(LoadType.MERGE)
@Sources({
    "system:properties",
    "system:env",
    "file:${user.dir}/src/main/resources/application.properties",
})
public interface LunchifyConfig extends Config {

  @DefaultValue("LOCAL")
  String environment();

  @Key("${environment}.mongo.connection.string")
  String mongoConnectionString();
}
