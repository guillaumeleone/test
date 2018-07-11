package com.vsct;

import com.vsct.model.ConnectorResponse;
import com.vsct.model.Journey;
import com.vsct.model.JourneyQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static com.google.common.collect.Lists.newArrayList;
import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;

/**
 * La Classe récupère un ensemble de Journey
 * et retourne uniquement les Journeys qui débutent dans plus de deux heures.
 */
public class PublicTransportProvider {

    private static final long TWO_HOURS = 2l;

    List<Journey> getJourneysWithDepartureAtLeastIn2Hours(JourneyQuery q) {

        // mock
        Optional<ConnectorResponse> connector = buildConnector(q);

        return connector
                .map(this::transformAndFilterJourneys)
                .orElse(newArrayList());
    }

    private List<Journey> transformAndFilterJourneys(ConnectorResponse response) {
        return response.getItems().stream()
                .map(partnerResponse -> new Journey(partnerResponse.getId(), partnerResponse.getValue()))
                .filter(filteredAfter2Hours())
                .collect(toList());
    }

    private Predicate<Journey> filteredAfter2Hours() {
        return journey -> journey.getDate().isAfter(now().plusHours(TWO_HOURS));
    }

    // ---- end ----

    // mock response
    private Optional<ConnectorResponse> buildConnector(JourneyQuery query) {
        return Optional.of(new ConnectorResponse(query));
    }
}