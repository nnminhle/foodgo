package com.nnml.foodgo.ingredient;

public class Stock {
    private Long id;

    private String type;

    private Double minimumQuantity;

    private Double maximumQuantity;

    private Double availableQuantity;

    public Stock() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMinimumQuantity() {
        return minimumQuantity;
    }

    public void setMinimumQuantity(Double minimumQuantity) {
        this.minimumQuantity = minimumQuantity;
    }

    public Double getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(Double maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public Double getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Double availableQuantity) {
        this.availableQuantity = availableQuantity;
    }
}
