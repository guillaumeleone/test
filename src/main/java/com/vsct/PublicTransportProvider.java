package com.vsct;

import com.vsct.model.partner.ConnectorResponse;
import com.vsct.model.core.JourneyQuery;
import com.vsct.model.core.Journey;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * PublicTransportProvider récupère un ensemble de Journey,
 * et retourne uniquement les Journeys qui débutent dans plus de deux heures.
 */
public class PublicTransportProvider {

    public List<Journey> search(JourneyQuery q) {

        Optional<ConnectorResponse> connector = getPartnerResponse(q);

        List<Journey> journeys = null;
        if (connector.isPresent()) {
            /* ici on transforme les éléments en des Journey */
            journeys = connector.get().items.stream()
                    .map(e -> new Journey(e.id, e.value))
                    .collect(Collectors.toList());
        }

        if (journeys != null) {
            List<Journey> result = new ArrayList<>();
            for (Journey j : journeys) {
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
    private Optional<ConnectorResponse> getPartnerResponse(JourneyQuery query) {
        return Optional.of(new ConnectorResponse(query));
    }
}