package com.vsct.model.core;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class Journey {

    private final int id;
    private final String value;
    public final LocalDateTime date;

    public Journey(int id, String value) {
        this.id = id;
        this.value = value;
        this.date = LocalDateTime.now().plusHours(getRandomNumberInRange(0,10));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Journey journey = (Journey) o;
        return id == journey.id &&
                Objects.equals(value, journey.value) &&
                Objects.equals(date, journey.date);
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, id, date);
    }

    private static int getRandomNumberInRange(int min, int max) {
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
