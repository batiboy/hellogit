package nulll.skr.pojo;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;


@Entity
@Table(name="user")
public class User implements Comparable<User>{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="userName")
    private String userName;

    @Column(name="password")
    private String password;

    @Column(name="email")
    private String email;

    @Column(name ="gender")
    private Integer gender;

    @Column(name = "headPortrait")
    private BufferedImage headPortrait;

    @Column(name = "personalProfile")
    private String personalProfile;

    @Column(name = "attentionNum")
    private Integer attentionNum;

    @Column(name = "fansNum")
    private Integer fansNum;

    @Column(name = "birthday")
    private Date birthday;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Comment> commentSet;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private Set<Post> postSet;


    public Integer getAttentionNum() {
        return attentionNum;
    }
    public void setAttentionNum(Integer attentionNum) {
        if(attentionNum<0){
            this.attentionNum=0;
        }
        this.attentionNum = attentionNum;
    }

    public Integer getFansNum() {
        return fansNum;
    }
    public void setFansNum(Integer fansNum) {
        if(fansNum<0){
            this.fansNum=0;
        }
        this.fansNum = fansNum;
    }

    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPersonalProfile() {
        return personalProfile;
    }
    public void setPersonalProfile(String personalProfile) {
        this.personalProfile = personalProfile;
    }

    public BufferedImage getHeadPortrait() {
        return headPortrait;
    }
    public void setHeadPortrait(String s) { ;
        try {
            this.headPortrait = ImageIO.read(new java.net.URL(s));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Integer getGender() {
        return gender;
    }
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password; }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int compareTo(User o){
        return -1;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
