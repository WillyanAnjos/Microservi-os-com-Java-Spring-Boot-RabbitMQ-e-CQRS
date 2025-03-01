package br.com.beautique.ms_sync.dtos.customers;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customers")
public class CustomerDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;

    public CustomerDTO() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "CustomerDTO [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
    }
}
