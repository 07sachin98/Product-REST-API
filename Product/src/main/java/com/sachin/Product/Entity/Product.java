package com.sachin.Product.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.util.Date;

@Entity
public class Product {
    @Id
    private Long id;

    public Product() {
		super();
	}

	public Product(Long id, String name, int code, Date regDate, long MRP, String description) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.regDate = regDate;
        this.MRP = MRP;
        this.description = description;
    }
	
	@NotNull	
    private String name;
	
	@NotNull
	@Size(min = 1, max = 4)
    private int code;
	@NotNull
    private Date regDate;
	@NotNull
    private long MRP;
	
    private String description;

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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public long getMRP() {
        return MRP;
    }

    public void setMRP(long MRP) {
        this.MRP = MRP;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", regDate=" + regDate +
                ", MRP=" + MRP +
                ", description='" + description + '\'' +
                '}';
    }
}
