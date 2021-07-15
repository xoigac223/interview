package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.entity.Ticket;
import org.springframework.data.jpa.domain.Specification;

public class TicketSpecificationsBuilder {

    private final List<SearchCriteria> params;

    public TicketSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }

    public TicketSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Ticket> build() {
        if (params.size() == 0)
            return null;

        Specification<Ticket> result = new TicketSpecification(params.get(0));

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result).or(new TicketSpecification(params.get(i)));
        }

        return result;
    }
}
