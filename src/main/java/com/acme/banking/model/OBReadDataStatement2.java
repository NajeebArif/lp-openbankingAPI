package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * OBReadDataStatement2
 */
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-27T20:13:15.656214-05:00[America/New_York]")
public class OBReadDataStatement2   {
  @JsonProperty("Statement")
  
  private List<OBStatement2> statement = null;

  public OBReadDataStatement2 statement(List<OBStatement2> statement) {
    this.statement = statement;
    return this;
  }

  public OBReadDataStatement2 addStatementItem(OBStatement2 statementItem) {
    if (this.statement == null) {
      this.statement = new ArrayList<>();
    }
    this.statement.add(statementItem);
    return this;
  }

  /**
   * Get statement
   * @return statement
  */
  @ApiModelProperty(value = "")
  public List<OBStatement2> getStatement() {
    return statement;
  }

  public void setStatement(List<OBStatement2> statement) {
    this.statement = statement;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OBReadDataStatement2 obReadDataStatement2 = (OBReadDataStatement2) o;
    return Objects.equals(this.statement, obReadDataStatement2.statement);
  }

  @Override
  public int hashCode() {
    return Objects.hash(statement);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OBReadDataStatement2 {\n");
    
    sb.append("    statement: ").append(toIndentedString(statement)).append("\n");
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

