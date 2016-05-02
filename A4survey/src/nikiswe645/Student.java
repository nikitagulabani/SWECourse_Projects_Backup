package nikiswe645;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

@Entity
@SequenceGenerator(name="student_seq", sequenceName="student_seq", initialValue=1, allocationSize=1) 
public class Student {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="student_seq")
	private int sid;
	private String sfirst;
	private String slast;
	private String saddress;
	private String zipcode;
	private String city;
	private String state;
	private String telephone;
	private String email;
	private String url;
	private Date sdate;
	
	@Column(name="startdate")
	private Date start;
	private String radios;
	
	@Column(name="checks")
	private String check_final;
	
	@Transient
	private String[] check;
	
	public String[] getcheck() {
		return check;
	}


	public void setScheck(String[] check) {
		this.check = check;
		setCheck_final(list2String(check));
	}


	public String getCheck_final() {
		return check_final;
	}


	public void setCheck_final(String check_final) {
		this.check_final = check_final;
	}
	private String comments;
	private String chance;
	@Transient
	private String raffle;
	
	public Student(){
		
	}
	
	
	//getter setters
	public int getSid() {
		return sid;
	}


//	public void setSid(int sid) {
//		this.sid = sid;
//	}
	
	
	
	public Date getSdate() {
		return sdate;
	}


	public void setSdate(Date line) {
		this.sdate = line;
	}


	public Date getStart() {
		return start;
	}


	public void setStart(Date start) {
		this.start = start;
	}
	public String getSfirst() {
		return sfirst;
	}
	public void setSfirst(String sfirst) {
		this.sfirst = sfirst;
	}
	public String getSlast() {
		return slast;
	}
	public void setSlast(String slast) {
		this.slast = slast;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode=zipcode;
		
		
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

	public String getRadios() {
		return radios;
	}
	public void setRadios(String radios) {
		this.radios = radios;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getChance() {
		return chance;
	}
	public void setChance(String chance) {
		this.chance = chance;
	}
	public String getRaffle() {
		return raffle;
	}
	public void setRaffle(String raffle) {
		this.raffle = raffle;
	}
	public static String list2String(String[] list) {
        StringBuffer ret = new StringBuffer("");
        for (int i = 0; list != null && i < list.length; i++) {
            ret.append(list[i]);
            if (i < list.length - 1) {
                ret.append(',');
            }
        }
        return ret.toString();
    }
}
