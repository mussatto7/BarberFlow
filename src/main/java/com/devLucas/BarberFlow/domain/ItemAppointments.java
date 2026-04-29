package com.devLucas.BarberFlow.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "item_agendamentos")
public class ItemAppointments implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "itemAppointment")
    private List<Services> services = new ArrayList<>();

    private BigDecimal subtotal;

    @ManyToOne
    @JoinColumn(name = "appointments_id")
    private Appointments appointments;

    public ItemAppointments() {
    }

    public ItemAppointments(Long id, List<Services> services, BigDecimal subtotal, Appointments appointments) {
        this.id = id;
        this.services = services;
        this.subtotal = subtotal;
        this.appointments = appointments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Services> getServices() {
        return services;
    }

    public void setServices(List<Services> services) {
        this.services = services;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ItemAppointments that = (ItemAppointments) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
