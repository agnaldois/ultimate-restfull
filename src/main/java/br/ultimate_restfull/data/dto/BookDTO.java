package br.ultimate_restfull.data.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "title", "price", "author", "launch_date"})
public class BookDTO extends RepresentationModel<BookDTO> {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String title;
    private Float price;
    private String authorName;
    private Date launchDate;

    public BookDTO() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(Date launchDate) {
        this.launchDate = launchDate;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(getId(), bookDTO.getId()) && Objects.equals(getTitle(), bookDTO.getTitle()) && Objects.equals(getPrice(), bookDTO.getPrice()) && Objects.equals(getAuthorName(), bookDTO.getAuthorName()) && Objects.equals(getLaunchDate(), bookDTO.getLaunchDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getTitle(), getPrice(), getAuthorName(), getLaunchDate());
    }
}
