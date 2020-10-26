package ImageHoster.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

//@Entity annotation specifies that the corresponding class is a JPA entity
//@Table annotation provides more options to customize the mapping.
@Entity
@Table(name = "Comments")
public class Comments {
    //@Id annotation specifies that the corresponding attribute is a primary key
    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    @Column(name = "text")
    private String text;

    //@Column annotation specifies that the attribute will be mapped to the column in the database.
    @Column(name = "timeStamp")
    private Date createdDate;

    //One user can have multiple comments
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    //one image can have multiple comments
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "image_id")
    private Image image;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }
}
