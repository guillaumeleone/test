package com.vsct;

import com.vsct.model.core.Journey;
import com.vsct.model.core.JourneyQuery;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class PublicTransportProviderTest {

    private PublicTransportProvider provider;

    @Before
    public void before() {
        provider = new PublicTransportProvider();
    }

    @Test
    public void search_queries100Journeys_returnsJourneysAfter2Hours() {
        List<Journey> journeys = provider.search(new JourneyQuery(100));
        assertThat(journeys).isNotNull();
        assertThat(journeys).allMatch(filteredAfter2Hours());
    }

    private static Predicate<Journey> filteredAfter2Hours() {
        return journey -> journey.date.isAfter(LocalDateTime.now().plusHours(2));
    }
}
