package com.acme.banking.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.net.URI;
import java.util.Objects;

/**
 * Links relevant to the payload
 */
@ApiModel(description = "Links relevant to the payload")
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2021-02-27T20:13:15.656214-05:00[America/New_York]")
public class Links   {
  @JsonProperty("Self")
  private URI self;

  @JsonProperty("First")
  private URI first;

  @JsonProperty("Prev")
  private URI prev;

  @JsonProperty("Next")
  private URI next;

  @JsonProperty("Last")
  private URI last;

  public Links self(URI self) {
    this.self = self;
    return this;
  }

  /**
   * Get self
   * @return self
  */
  @ApiModelProperty(required = true, value = "")
  public URI getSelf() {
    return self;
  }

  public void setSelf(URI self) {
    this.self = self;
  }

  public Links first(URI first) {
    this.first = first;
    return this;
  }

  /**
   * Get first
   * @return first
  */
  @ApiModelProperty(value = "")
  public URI getFirst() {
    return first;
  }

  public void setFirst(URI first) {
    this.first = first;
  }

  public Links prev(URI prev) {
    this.prev = prev;
    return this;
  }

  /**
   * Get prev
   * @return prev
  */
  @ApiModelProperty(value = "")
  public URI getPrev() {
    return prev;
  }

  public void setPrev(URI prev) {
    this.prev = prev;
  }

  public Links next(URI next) {
    this.next = next;
    return this;
  }

  /**
   * Get next
   * @return next
  */
  @ApiModelProperty(value = "")
  public URI getNext() {
    return next;
  }

  public void setNext(URI next) {
    this.next = next;
  }

  public Links last(URI last) {
    this.last = last;
    return this;
  }

  /**
   * Get last
   * @return last
  */
  @ApiModelProperty(value = "")
  public URI getLast() {
    return last;
  }

  public void setLast(URI last) {
    this.last = last;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Links links = (Links) o;
    return Objects.equals(this.self, links.self) &&
        Objects.equals(this.first, links.first) &&
        Objects.equals(this.prev, links.prev) &&
        Objects.equals(this.next, links.next) &&
        Objects.equals(this.last, links.last);
  }

  @Override
  public int hashCode() {
    return Objects.hash(self, first, prev, next, last);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Links {\n");
    
    sb.append("    self: ").append(toIndentedString(self)).append("\n");
    sb.append("    first: ").append(toIndentedString(first)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    last: ").append(toIndentedString(last)).append("\n");
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

