package vn.shippo.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the delivery_features database table.
 * 
 */
@Entity
@Table(name="delivery_features")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQuery(name="DeliveryFeature.findAll", query="SELECT d FROM DeliveryFeature d")
public class DeliveryFeature implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	private String code;

	@Column(name = "exclusion")
	@SerializedName("exclusion")
	@JsonProperty("exclusion")
	private String exclusion;

	@Column(name="is_count_fee")
	private Boolean isCountFee;

	private String name;

	private String state;

	private String type;

	public DeliveryFeature() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getExclusion() {
		return this.exclusion;
	}

	public void setExclusion(String exclusion) {
		this.exclusion = exclusion;
	}

	public Boolean getIsCountFee() {
		return this.isCountFee;
	}

	public void setIsCountFee(Boolean isCountFee) {
		this.isCountFee = isCountFee;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

}