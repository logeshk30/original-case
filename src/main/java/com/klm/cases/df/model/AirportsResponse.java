package com.klm.cases.df.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * AirportsResponse
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2021-11-25T10:47:55.767Z")


public class AirportsResponse   {
  @JsonProperty("locations")
  @Valid
  private List<Location> locations = null;

  @JsonProperty("page")
  private Page page = null;

  public AirportsResponse locations(List<Location> locations) {
    this.locations = locations;
    return this;
  }

  public AirportsResponse addLocationsItem(Location locationsItem) {
    if (this.locations == null) {
      this.locations = new ArrayList<Location>();
    }
    this.locations.add(locationsItem);
    return this;
  }

  /**
   * Get locations
   * @return locations
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<Location> getLocations() {
    return locations;
  }

  public void setLocations(List<Location> locations) {
    this.locations = locations;
  }

  public AirportsResponse page(Page page) {
    this.page = page;
    return this;
  }

  /**
   * Get page
   * @return page
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Page getPage() {
    return page;
  }

  public void setPage(Page page) {
    this.page = page;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AirportsResponse airportsResponse = (AirportsResponse) o;
    return Objects.equals(this.locations, airportsResponse.locations) &&
        Objects.equals(this.page, airportsResponse.page);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locations, page);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AirportsResponse {\n");
    
    sb.append("    locations: ").append(toIndentedString(locations)).append("\n");
    sb.append("    page: ").append(toIndentedString(page)).append("\n");
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

