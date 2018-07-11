package com.vsct.model;

import java.util.ArrayList;
import java.util.List;

public class ConnectorResponse {

    private final List<PartnerResponse> items;

    public ConnectorResponse(JourneyQuery query) {
        this.items = buildResponse(query);
    }

    private List<PartnerResponse> buildResponse(JourneyQuery query) {
        List<PartnerResponse> response = new ArrayList<>();
        for (int i = 0; i < query.total; i++) {
            response.add(new PartnerResponse(i, "Value" + i));
        }
        return response;
    }

    public List<PartnerResponse> getItems() {
        return items;
    }
}

