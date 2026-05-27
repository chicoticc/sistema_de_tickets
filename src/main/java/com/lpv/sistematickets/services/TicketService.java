package com.lpv.sistematickets.services;

import java.util.List;

import com.lpv.sistematickets.entities.Ticket;

public interface TicketService {

    List<Ticket> getAll();

    Ticket getById(Long id);

    Ticket save(Ticket ticket);

    Ticket update(Long id, Ticket ticket);

    void delete(Long id);
}