package com.vsct;

import com.vsct.model.ConnectorResponse;
import com.vsct.model.JourneyQuery;
import com.vsct.model.Journey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * La Classe récupère un ensemble de Journey
 * et retourne uniquement les Journeys qui débutent dans plus de deux heures.
 */
public class PublicTransportProvider {

    public List<Journey> search(JourneyQuery q) {

        Optional<ConnectorResponse> connector = buildConnector(q);

        List<Journey> journeys = null;
        if (connector.isPresent()) {
            /* ici on transforme les éléments en des Journey */
            journeys = connector.get().items.stream()
                    .map(e -> new Journey(e.id, e.value))
                    .collect(Collectors.toList());
        }

        if (journeys != null) {
            List<Journey> result = null;
            for (Journey j : journeys) {
                result = new ArrayList<>();
                if (j.date.isAfter(LocalDateTime.now().plusHours(2l))) {
                    result.add(j);
                }
            }
            return result;
        }
        return null;
    }

    // ---- end ----

    // mock response
    private Optional<ConnectorResponse> buildConnector(JourneyQuery query) {
        return Optional.of(new ConnectorResponse(query));
    }
}