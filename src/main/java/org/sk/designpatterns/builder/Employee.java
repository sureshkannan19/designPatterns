package org.sk.designpatterns.builder;

public class Employee {

    private final Long id;

    private final String name;
    private final String company;

    Employee(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.company = builder.company;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                '}';
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Long id;
        private String name;
        private String company;

        public Builder id(long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder company(String company) {
            this.company = company;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}