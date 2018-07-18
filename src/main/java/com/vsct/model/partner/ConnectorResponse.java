package com.vsct.model.partner;

import com.vsct.model.core.JourneyQuery;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Construit une liste de Response.
 */
public class ConnectorResponse {

    public final List<PartnerResponse> items;

    public ConnectorResponse(JourneyQuery query) {
        this.items = buildResponse(query);
    }

    public List<PartnerResponse> buildResponse(JourneyQuery query) {
        return Stream.iterate(0, i -> i)
                .limit(query.size)
                .map(i -> new PartnerResponse(i, "Value" + i))
                .collect(toList());
    }
}

