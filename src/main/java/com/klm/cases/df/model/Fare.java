package com.klm.cases.df.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Fare
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")


public class Fare   {
  @JsonProperty("amount")
  private Double amount = null;

  @JsonProperty("currency")
  private String currency = null;

  @JsonProperty("origin")
  private String origin = null;

  @JsonProperty("destination")
  private String destination = null;

  public Fare amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  **/
  @ApiModelProperty(value = "")


  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public Fare currency(String currency) {
    this.currency = currency;
    return this;
  }

  /**
   * Currency type - EUR or USD
   * @return currency
  **/
  @ApiModelProperty(value = "Currency type - EUR or USD")


  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public Fare origin(String origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Origin airport code
   * @return origin
  **/
  @ApiModelProperty(value = "Origin airport code")


  public String getOrigin() {
    return origin;
  }

  public void setOrigin(String origin) {
    this.origin = origin;
  }

  public Fare destination(String destination) {
    this.destination = destination;
    return this;
  }

  /**
   * Destination airport code
   * @return destination
  **/
  @ApiModelProperty(value = "Destination airport code")


  public String getDestination() {
    return destination;
  }

  public void setDestination(String destination) {
    this.destination = destination;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fare fare = (Fare) o;
    return Objects.equals(this.amount, fare.amount) &&
        Objects.equals(this.currency, fare.currency) &&
        Objects.equals(this.origin, fare.origin) &&
        Objects.equals(this.destination, fare.destination);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, currency, origin, destination);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fare {\n");
    
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    destination: ").append(toIndentedString(destination)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

