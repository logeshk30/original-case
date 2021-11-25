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
 * Location
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")


public class Location   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  public Location code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Airport code
   * @return code
  **/
  @ApiModelProperty(value = "Airport code")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Location name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the Airport
   * @return name
  **/
  @ApiModelProperty(value = "Name of the Airport")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location description(String description) {
    this.description = description;
    return this;
  }

  /**
   * description about Airport
   * @return description
  **/
  @ApiModelProperty(value = "description about Airport")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Location location = (Location) o;
    return Objects.equals(this.code, location.code) &&
        Objects.equals(this.name, location.name) &&
        Objects.equals(this.description, location.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, name, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Location {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

