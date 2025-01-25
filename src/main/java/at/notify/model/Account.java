package at.notify.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="accounts")
public class Account {

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long 		id;
	
	@Column(nullable=false,length=25)
	private String 		shortname;
	
	@Column(name="company_name")
	private String 		companyName;
	@Column(name="contact_email")
	private String 		contactEmail;
	@Column(name="contact_phone")
	private String 		contactPhone;
	@Column(name="language")
	private String 		language;
	@Column(name="website")
	private String 		website;
	@Column(name="address")
	private String     address;
	@Column(name="country")
	private String     country;
	@Column(name="city")
	private String     city;
	@Column(name="zip")
	private String     zip;
	@Column(nullable=false, name="max_devices")
	private Integer		maxDevices;
	@Column(name="max_users")
	private Integer		maxUsers;
	@Column(name="max_geofences")
	private Integer		maxGeofences;
	@Column(name="max_notifiers")
	private Integer		maxNotifiers;
	@Column(name="max_pois")
	private Integer		maxPois;
	@Column(name="account_enabled",nullable=false)
    private boolean 	enabled;
    @Column(nullable = false, columnDefinition="boolean DEFAULT FALSE")
    private boolean 	deleted;
    @Column(name="account_expired",nullable=false)
    private boolean 	accountExpired;
	@Column(name="account_locked",nullable=false)
    private boolean 	accountLocked;
    @Column(name="credentials_expired",nullable=false)
    private boolean 	credentialsExpired;
    @Column(name="dateof_creation")
    private Long 		creationDate;
    @Column(name="last_login")
    private Long 		lastLogin;
    @Column(name="units_speed",nullable=false)
    private String		speedUnits;
    @Column(name="units_distance",nullable=false)
    private String		distanceUnits;
    @Column(name="units_volume",nullable=false)
    private String		volumUnits;
    @Column(name="units_economy",nullable=false)
    private String		economyUnits;
    @Column(name="units_pressure",nullable=false)
    private	String		pressureUnits;
    @Column(name="units_temp",nullable=false)
    private String		tempUnits;
    @Column(name="emailUser")
    private String 		emailUser;
    @Column(name="emailPassword")
    private String		emailPassword; 
	
}
