package org.afs.pakinglot.domain.dto;

import org.afs.pakinglot.domain.Ticket;

public class FetchRequestDto {
    private Ticket ticket;

    // Getters and setters
    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}