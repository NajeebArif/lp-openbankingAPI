package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Details about the interest that may be payable to the BCA account holders
 */
@ApiModel(description = "Details about the interest that may be payable to the BCA account holders")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-27T20:13:15.656214-05:00[America/New_York]")
public class CreditInterest   {
  @JsonProperty("TierBandSet")
  
  private List<CreditInterestTierBandSet> tierBandSet = new ArrayList<>();

  public CreditInterest tierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
    this.tierBandSet = tierBandSet;
    return this;
  }

  public CreditInterest addTierBandSetItem(CreditInterestTierBandSet tierBandSetItem) {
    this.tierBandSet.add(tierBandSetItem);
    return this;
  }

  /**
   * The group of tiers or bands for which credit interest can be applied.
   * @return tierBandSet
  */
  @ApiModelProperty(required = true, value = "The group of tiers or bands for which credit interest can be applied.")
  public List<CreditInterestTierBandSet> getTierBandSet() {
    return tierBandSet;
  }

  public void setTierBandSet(List<CreditInterestTierBandSet> tierBandSet) {
    this.tierBandSet = tierBandSet;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreditInterest creditInterest = (CreditInterest) o;
    return Objects.equals(this.tierBandSet, creditInterest.tierBandSet);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tierBandSet);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreditInterest {\n");
    
    sb.append("    tierBandSet: ").append(toIndentedString(tierBandSet)).append("\n");
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

