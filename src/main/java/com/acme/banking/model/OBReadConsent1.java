package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.Objects;

/**
 * OBReadConsent1
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-27T20:13:15.656214-05:00[America/New_York]")
public class OBReadConsent1   {
  @JsonProperty("Data")
  private OBReadConsent1Data data;

  @JsonProperty("Risk")
  private Object risk;

  public OBReadConsent1 data(OBReadConsent1Data data) {
    this.data = data;
    return this;
  }

  /**
   * Get data
   * @return data
  */
  @ApiModelProperty(required = true, value = "")
  public OBReadConsent1Data getData() {
    return data;
  }

  public void setData(OBReadConsent1Data data) {
    this.data = data;
  }

  public OBReadConsent1 risk(Object risk) {
    this.risk = risk;
    return this;
  }

  /**
   * The Risk section is sent by the initiating party to the ASPSP. It is used to specify additional details for risk scoring for Account Info.
   * @return risk
  */
  @ApiModelProperty(required = true, value = "The Risk section is sent by the initiating party to the ASPSP. It is used to specify additional details for risk scoring for Account Info.")
  public Object getRisk() {
    return risk;
  }

  public void setRisk(Object risk) {
    this.risk = risk;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadConsent1 obReadConsent1 = (OBReadConsent1) o;
    return Objects.equals(this.data, obReadConsent1.data) &&
        Objects.equals(this.risk, obReadConsent1.risk);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, risk);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadConsent1 {\n");
    
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    risk: ").append(toIndentedString(risk)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

