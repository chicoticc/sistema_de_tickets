package com.lpv.sistematickets.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lpv.sistematickets.entities.Ticket;
import com.lpv.sistematickets.entities.Usuario;
import com.lpv.sistematickets.enums.EstadoTicket;
import com.lpv.sistematickets.enums.PrioridadTicket;
import com.lpv.sistematickets.repositories.TicketRepository;
import com.lpv.sistematickets.repositories.UsuarioRepository;
import com.lpv.sistematickets.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final UsuarioRepository usuarioRepository;

    public TicketServiceImpl(TicketRepository ticketRepository, UsuarioRepository usuarioRepository) {
        this.ticketRepository = ticketRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket getById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket no encontrado con id " + id));
    }

    @Override
    public Ticket save(Ticket ticket) {
        if (ticket.getUsuarioCreador() == null || ticket.getUsuarioCreador().getId() == null) {
            throw new IllegalArgumentException("El usuario creador es obligatorio y debe existir");
        }

        Usuario usuarioCreador = usuarioRepository.findById(ticket.getUsuarioCreador().getId())
                .orElseThrow(() -> new RuntimeException("Usuario creador no encontrado"));

        ticket.setUsuarioCreador(usuarioCreador);
        ticket.setEstado(EstadoTicket.EN_ESPERA);
        ticket.setPrioridad(PrioridadTicket.MEDIA);
        ticket.setTecnicoAsignado(null);
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket update(Long id, Ticket ticket) {
        Ticket ticketExistente = getById(id);

        ticketExistente.setTitulo(ticket.getTitulo());
        ticketExistente.setDescripcion(ticket.getDescripcion());
        ticketExistente.setAreaSolicitante(ticket.getAreaSolicitante());
        ticketExistente.setUbicacion(ticket.getUbicacion());

        return ticketRepository.save(ticketExistente);
    }

    @Override
    public void delete(Long id) {
        Ticket ticketExistente = getById(id);
        ticketRepository.delete(ticketExistente);
    }

}
