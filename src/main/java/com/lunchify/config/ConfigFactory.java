package com.lunchify.config;

import org.aeonbits.owner.ConfigCache;

public final class ConfigFactory {

  private ConfigFactory() {
  }

  public static LunchifyConfig lunchifyConfig() {
    return ConfigCache.getOrCreate(LunchifyConfig.class);
  }
}
