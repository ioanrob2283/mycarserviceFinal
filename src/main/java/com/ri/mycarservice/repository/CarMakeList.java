package com.ri.mycarservice.repository;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/* Projection interface */
@JsonPropertyOrder({"id", "name"})
public interface CarMakeList {

    Long getId();

    String getName();
}
