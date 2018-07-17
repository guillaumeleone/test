package com.vsct;

import com.vsct.model.core.Journey;
import static org.assertj.core.api.Assertions.assertThat;

import com.vsct.model.core.JourneyQuery;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

public class PublicTransportProviderTest {

    private PublicTransportProvider provider;

    @Before
    public void before() {
        provider = new PublicTransportProvider();
    }

    @Test
    public void search_queries100Journeys_returns1JourneysAfter2Hours() {
        List<Journey> journeys = provider.search(new JourneyQuery(100));
        assertThat(journeys).isNotNull();
        assertThat(journeys.get(0).date).isAfter(LocalDateTime.now().plusHours(2));
    }
}
