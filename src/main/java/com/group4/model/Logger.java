package com.group4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "loggers")
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @OneToOne(cascade = CascadeType.ALL, optional = false, orphanRemoval = true)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "taking_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date takingDate;
    @Column(name = "deadline_date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deadlineDate;
    @Column(name = "return_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;
}
