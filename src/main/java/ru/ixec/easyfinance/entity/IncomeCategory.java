package ru.ixec.easyfinance.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class IncomeCategory {

    @Id
    @GeneratedValue
    private Long incomeCategoryId;
    private String name;

    @OneToMany(mappedBy = "incomeCategory")
    private List<Income> incomeList;
}