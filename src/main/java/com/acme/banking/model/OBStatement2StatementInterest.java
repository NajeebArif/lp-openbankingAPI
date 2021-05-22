package com.acme.banking.model;

import java.util.Objects;
import com.acme.banking.model.OBActiveOrHistoricCurrencyAndAmount7;
import com.acme.banking.model.OBCreditDebitCode0;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import org.openapitools.jackson.nullable.JsonNullable;

/**
 * Set of elements used to provide details of a generic interest amount related to the statement resource.
 */
@ApiModel(description = "Set of elements used to provide details of a generic interest amount related to the statement resource.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-06T12:42:38.515350-05:00[America/New_York]")
public class OBStatement2StatementInterest   {
  @JsonProperty("Description")
  private String description;

  @JsonProperty("CreditDebitIndicator")
  private OBCreditDebitCode0 creditDebitIndicator;

  @JsonProperty("Type")
  private String type;

  @JsonProperty("Rate")
  private BigDecimal rate;

  @JsonProperty("RateType")
  private String rateType;

  @JsonProperty("Frequency")
  private String frequency;

  @JsonProperty("Amount")
  private OBActiveOrHistoricCurrencyAndAmount7 amount;

  public OBStatement2StatementInterest description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Description that may be available for the statement interest.
   * @return description
  */
  @ApiModelProperty(value = "Description that may be available for the statement interest.")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public OBStatement2StatementInterest creditDebitIndicator(OBCreditDebitCode0 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
    return this;
  }

  /**
   * Get creditDebitIndicator
   * @return creditDebitIndicator
  */
  @ApiModelProperty(required = true, value = "")
  public OBCreditDebitCode0 getCreditDebitIndicator() {
    return creditDebitIndicator;
  }

  public void setCreditDebitIndicator(OBCreditDebitCode0 creditDebitIndicator) {
    this.creditDebitIndicator = creditDebitIndicator;
  }

  public OBStatement2StatementInterest type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Interest amount type, in a coded form.
   * @return type
  */
  @ApiModelProperty(required = true, value = "Interest amount type, in a coded form.")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public OBStatement2StatementInterest rate(BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * field representing a percentage (e.g. 0.05 represents 5% and 0.9525 represents 95.25%). Note the number of decimal places may vary.
   * @return rate
  */
  @ApiModelProperty(value = "field representing a percentage (e.g. 0.05 represents 5% and 0.9525 represents 95.25%). Note the number of decimal places may vary.")
  public BigDecimal getRate() {
    return rate;
  }

  public void setRate(BigDecimal rate) {
    this.rate = rate;
  }

  public OBStatement2StatementInterest rateType(String rateType) {
    this.rateType = rateType;
    return this;
  }

  /**
   * Description that may be available for the statement Interest rate type.
   * @return rateType
  */
  @ApiModelProperty(value = "Description that may be available for the statement Interest rate type.")
  public String getRateType() {
    return rateType;
  }

  public void setRateType(String rateType) {
    this.rateType = rateType;
  }

  public OBStatement2StatementInterest frequency(String frequency) {
    this.frequency = frequency;
    return this;
  }

  /**
   * Specifies the statement fee type requested
   * @return frequency
  */
  @ApiModelProperty(value = "Specifies the statement fee type requested")
  public String getFrequency() {
    return frequency;
  }

  public void setFrequency(String frequency) {
    this.frequency = frequency;
  }

  public OBStatement2StatementInterest amount(OBActiveOrHistoricCurrencyAndAmount7 amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @ApiModelProperty(required = true, value = "")
  public OBActiveOrHistoricCurrencyAndAmount7 getAmount() {
    return amount;
  }

  public void setAmount(OBActiveOrHistoricCurrencyAndAmount7 amount) {
    this.amount = amount;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBStatement2StatementInterest obStatement2StatementInterest = (OBStatement2StatementInterest) o;
    return Objects.equals(this.description, obStatement2StatementInterest.description) &&
        Objects.equals(this.creditDebitIndicator, obStatement2StatementInterest.creditDebitIndicator) &&
        Objects.equals(this.type, obStatement2StatementInterest.type) &&
        Objects.equals(this.rate, obStatement2StatementInterest.rate) &&
        Objects.equals(this.rateType, obStatement2StatementInterest.rateType) &&
        Objects.equals(this.frequency, obStatement2StatementInterest.frequency) &&
        Objects.equals(this.amount, obStatement2StatementInterest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, creditDebitIndicator, type, rate, rateType, frequency, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBStatement2StatementInterest {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    creditDebitIndicator: ").append(toIndentedString(creditDebitIndicator)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    rateType: ").append(toIndentedString(rateType)).append("\n");
    sb.append("    frequency: ").append(toIndentedString(frequency)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

