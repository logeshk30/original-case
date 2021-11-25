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
 * Metrics
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")


public class Metrics   {
  @JsonProperty("totalRequestsCount")
  private Long totalRequestsCount = null;

  @JsonProperty("responseOKCount")
  private Long responseOKCount = null;

  @JsonProperty("response4XXCount")
  private Long response4XXCount = null;

  @JsonProperty("response5XXCount")
  private Long response5XXCount = null;

  @JsonProperty("maxResponseTime")
  private Long maxResponseTime = null;

  @JsonProperty("minResponseTime")
  private Long minResponseTime = null;

  @JsonProperty("avgResponseTime")
  private Long avgResponseTime = null;

  public Metrics totalRequestsCount(Long totalRequestsCount) {
    this.totalRequestsCount = totalRequestsCount;
    return this;
  }

  /**
   * Get totalRequestsCount
   * @return totalRequestsCount
  **/
  @ApiModelProperty(value = "")


  public Long getTotalRequestsCount() {
    return totalRequestsCount;
  }

  public void setTotalRequestsCount(Long totalRequestsCount) {
    this.totalRequestsCount = totalRequestsCount;
  }

  public Metrics responseOKCount(Long responseOKCount) {
    this.responseOKCount = responseOKCount;
    return this;
  }

  /**
   * Get responseOKCount
   * @return responseOKCount
  **/
  @ApiModelProperty(value = "")


  public Long getResponseOKCount() {
    return responseOKCount;
  }

  public void setResponseOKCount(Long responseOKCount) {
    this.responseOKCount = responseOKCount;
  }

  public Metrics response4XXCount(Long response4XXCount) {
    this.response4XXCount = response4XXCount;
    return this;
  }

  /**
   * Get response4XXCount
   * @return response4XXCount
  **/
  @ApiModelProperty(value = "")


  public Long getResponse4XXCount() {
    return response4XXCount;
  }

  public void setResponse4XXCount(Long response4XXCount) {
    this.response4XXCount = response4XXCount;
  }

  public Metrics response5XXCount(Long response5XXCount) {
    this.response5XXCount = response5XXCount;
    return this;
  }

  /**
   * Get response5XXCount
   * @return response5XXCount
  **/
  @ApiModelProperty(value = "")


  public Long getResponse5XXCount() {
    return response5XXCount;
  }

  public void setResponse5XXCount(Long response5XXCount) {
    this.response5XXCount = response5XXCount;
  }

  public Metrics maxResponseTime(Long maxResponseTime) {
    this.maxResponseTime = maxResponseTime;
    return this;
  }

  /**
   * Get maxResponseTime
   * @return maxResponseTime
  **/
  @ApiModelProperty(value = "")


  public Long getMaxResponseTime() {
    return maxResponseTime;
  }

  public void setMaxResponseTime(Long maxResponseTime) {
    this.maxResponseTime = maxResponseTime;
  }

  public Metrics minResponseTime(Long minResponseTime) {
    this.minResponseTime = minResponseTime;
    return this;
  }

  /**
   * Get minResponseTime
   * @return minResponseTime
  **/
  @ApiModelProperty(value = "")


  public Long getMinResponseTime() {
    return minResponseTime;
  }

  public void setMinResponseTime(Long minResponseTime) {
    this.minResponseTime = minResponseTime;
  }

  public Metrics avgResponseTime(Long avgResponseTime) {
    this.avgResponseTime = avgResponseTime;
    return this;
  }

  /**
   * Get avgResponseTime
   * @return avgResponseTime
  **/
  @ApiModelProperty(value = "")


  public Long getAvgResponseTime() {
    return avgResponseTime;
  }

  public void setAvgResponseTime(Long avgResponseTime) {
    this.avgResponseTime = avgResponseTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Metrics metrics = (Metrics) o;
    return Objects.equals(this.totalRequestsCount, metrics.totalRequestsCount) &&
        Objects.equals(this.responseOKCount, metrics.responseOKCount) &&
        Objects.equals(this.response4XXCount, metrics.response4XXCount) &&
        Objects.equals(this.response5XXCount, metrics.response5XXCount) &&
        Objects.equals(this.maxResponseTime, metrics.maxResponseTime) &&
        Objects.equals(this.minResponseTime, metrics.minResponseTime) &&
        Objects.equals(this.avgResponseTime, metrics.avgResponseTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(totalRequestsCount, responseOKCount, response4XXCount, response5XXCount, maxResponseTime, minResponseTime, avgResponseTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Metrics {\n");
    
    sb.append("    totalRequestsCount: ").append(toIndentedString(totalRequestsCount)).append("\n");
    sb.append("    responseOKCount: ").append(toIndentedString(responseOKCount)).append("\n");
    sb.append("    response4XXCount: ").append(toIndentedString(response4XXCount)).append("\n");
    sb.append("    response5XXCount: ").append(toIndentedString(response5XXCount)).append("\n");
    sb.append("    maxResponseTime: ").append(toIndentedString(maxResponseTime)).append("\n");
    sb.append("    minResponseTime: ").append(toIndentedString(minResponseTime)).append("\n");
    sb.append("    avgResponseTime: ").append(toIndentedString(avgResponseTime)).append("\n");
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

