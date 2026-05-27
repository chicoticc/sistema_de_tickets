package com.lpv.sistematickets.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpv.sistematickets.entities.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
