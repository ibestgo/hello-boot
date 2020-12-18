package com.bestgo.helloboot.play;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

// Experiment

@Configuration
@ConfigurationProperties("db") // read all properties starts with "db." from application.properties
public class DbSettings {
  private String connection;  // then inject db.application to this application. The name should match
  private String host;
  private int port;

  public String getConnection() {
    return connection;
  }

  public void setConnection(String connection) {
    this.connection = connection;
  }

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }
}
