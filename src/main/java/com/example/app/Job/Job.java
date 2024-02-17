package com.example.app.Job;

import com.example.app.User.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity(name = "Job")
@Table(name = "Job", uniqueConstraints = { @UniqueConstraint(name = "job_unique_constraint", columnNames = "job_id") })
public class Job {
  @Id
  @SequenceGenerator(name = "job_sequence", sequenceName = "job_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "job_sequence")
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name", nullable = true, updatable = true)
  private String name;

  @Column(name = "started_at", nullable = false, updatable = true)
  private String started_at;

  @Column(name = "salary", nullable = false, updatable = true)
  private Long salary;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id", referencedColumnName = "id", foreignKey = @ForeignKey(name = "user_id_code_fk"))
  private User user;

  public Job() {
  }

  public Job(String name, String started_at, Long salary, User user) {

    this.name = name;
    this.started_at = started_at;
    this.salary = salary;
    this.user = user;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStarted_at() {
    return started_at;
  }

  public void setStarted_at(String started_at) {
    this.started_at = started_at;
  }

  public Long getSalary() {
    return salary;
  }

  public void setSalary(Long salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Job [id=" + id + ", name=" + name + ", started_at=" + started_at + ", salary=" + salary + ", user=" + user
        + "]";
  }

}
