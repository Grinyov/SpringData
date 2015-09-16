package conference;

import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

/**
 * Created by green on 13.09.2015.
 */
@Entity
public class Talk {

    @Id
    @GeneratedValue
    private Long talkId;

    private Date when;

    private String title;

    public Talk(){}

    public Talk(Date when, String title) {
        this.when = when;
        this.title = title;
    }

    @Override
    public String toString() {
        return title;
    }

    public Date getWhen(){return when;}
}
