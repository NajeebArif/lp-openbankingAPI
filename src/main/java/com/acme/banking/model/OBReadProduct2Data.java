package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Aligning with the read write specs structure.
 */
@ApiModel(description = "Aligning with the read write specs structure.")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-27T20:13:15.656214-05:00[America/New_York]")
public class OBReadProduct2Data   {
  @JsonProperty("Product")
  
  private List<OBReadProduct2DataProduct> product = null;

  public OBReadProduct2Data product(List<OBReadProduct2DataProduct> product) {
    this.product = product;
    return this;
  }

  public OBReadProduct2Data addProductItem(OBReadProduct2DataProduct productItem) {
    if (this.product == null) {
      this.product = new ArrayList<>();
    }
    this.product.add(productItem);
    return this;
  }

  /**
   * Get product
   * @return product
  */
  @ApiModelProperty(value = "")
  public List<OBReadProduct2DataProduct> getProduct() {
    return product;
  }

  public void setProduct(List<OBReadProduct2DataProduct> product) {
    this.product = product;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadProduct2Data obReadProduct2Data = (OBReadProduct2Data) o;
    return Objects.equals(this.product, obReadProduct2Data.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadProduct2Data {\n");
    
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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

