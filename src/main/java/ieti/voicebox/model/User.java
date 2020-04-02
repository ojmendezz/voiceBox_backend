package ieti.voicebox.model;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document
public class User{
    @Id
    private String username;
    private long userID;    
    private String name;
    private String gener;
    private String birthDate;
    private String email;
    private String password;    
    private String createDate;
    private Channel channel;
    private String userImageLink;
    //private List<Category> categories;

    
    public User(String username, String name, String gener, String birthDate, String email, String password, String createDate) {
        this.username = username;
        this.name = name;
        this.gener = gener;
        this.birthDate = birthDate;
        this.email = email;
        this.password = password;
        this.createDate = createDate;
        //this.categories = new ArrayList<>();
    }

	public long getUserID() {
        return userID;
    }

    public void setUserID(long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGener() {
        return gener;
    }

    public void setGener(String gener) {
        this.gener = gener;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
/*
    public void createChannel(Channel channel){
        this.channel = channel;
    }
*/
    @Override
    public String toString() {
        return String.format(
            "User[username=%s, name='%s', gener='%s', birthDate='%s', email='%s', password='%s', createDate='%s']",
            username, name, gener, birthDate, email, password,  createDate);
    }
    /*
    public List<Category> getCateogries() {
        return cateogries;
    }
    public void addCateogory(Category category) {
        this.categories.add(category);
    }*/

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public Channel getChannel() {
        return channel;
    }

	public String getUserImageLink() {
		return userImageLink;
	}

	public void setUserImageLink(String userImageLink) {
		this.userImageLink = userImageLink;
	}
    
    
}