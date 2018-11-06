package backpacker;

import java.time.Month;
import java.util.List;

public class Story {
    private int id;
    private int userId;
    private Month month;
    private String location;
    private Integer budget;
    private Currency currency;
    private List<Transport> transport;
    private List<Accommodation> accommodations;
    private String description;
//    private

    public Month getMonth() {
        return month;
    }

    public void setMonth(Month month) {
        this.month = month;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
