package com.devLucas.BarberFlow.domain;

import com.devLucas.BarberFlow.enums.AccountsPayableCategory;
import com.devLucas.BarberFlow.enums.StatusToPay;
import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "contas_pagar")
public class AccountsPayable implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String title;
    private LocalDate issueDate;
    private BigDecimal amount;
    private LocalDate dueDate;
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)
    private AccountsPayableCategory category;

    @Enumerated(EnumType.STRING)
    private StatusToPay statusToPay;

    public AccountsPayable() {
    }

    public AccountsPayable(Long id, User user, String title, LocalDate issueDate, BigDecimal amount, LocalDate dueDate, LocalDate paymentDate, AccountsPayableCategory category, StatusToPay statusToPay) {
        this.id = id;
        this.user = user;
        this.title = title;
        this.issueDate = issueDate;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paymentDate = paymentDate;
        this.category = category;
        this.statusToPay = statusToPay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public AccountsPayableCategory getCategory() {
        return category;
    }

    public void setCategory(AccountsPayableCategory category) {
        this.category = category;
    }

    public StatusToPay getStatusToPay() {
        return statusToPay;
    }

    public void setStatusToPay(StatusToPay statusToPay) {
        this.statusToPay = statusToPay;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AccountsPayable that = (AccountsPayable) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
