package org.alex.one_to_one;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="one_to_one_financial_operation")
public class FinancialOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date date;

    @Column
    private Integer total;

    @OneToOne(mappedBy = "financialOperation")
    private Customer customer;

    public FinancialOperation(Date date, Integer total, Customer customer) {
        this.date = date;
        this.total = total;
        this.customer = customer;
    }

    public FinancialOperation() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FinancialOperation that = (FinancialOperation) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return total != null ? total.equals(that.total) : that.total == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FinancialOperation{" +
                "id=" + id +
                ", date=" + date +
                ", total=" + total +
                '}';
    }
}
