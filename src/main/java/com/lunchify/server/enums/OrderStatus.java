package com.lunchify.server.enums;

public enum OrderStatus {
  PLACED("PLACED"),
  UPDATED("UPDATED"),
  COOKING("COOKING"),
  DONE("DONE"),
  CLOSED("CLOSED");

  public final String val;

  private OrderStatus(String val) {
    this.val = val;
  }

  public String val() {
    return this.val;
  }
}
