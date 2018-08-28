package vn.shippo.delivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.Type;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the service_fees database table.
 * 
 */
@Entity
@Table(name="service_fees")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@NamedQuery(name="ServiceFee.findAll", query="SELECT s FROM ServiceFee s")
public class ServiceFee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;

	@Column(name="apply_from_date")
	private Timestamp applyFromDate;

	@Column(name="apply_to_date")
	private Timestamp applyToDate;

	@Column(name="charge_type")
	@JsonProperty("change_type")
	private String chargeType;

	private String code;

	@Column(name="feature_id")
	private Integer featureId;

	@Column(name="fee_group")
	private String feeGroup;

	@Column(name="is_manual")
	private Boolean isManual;

	private String name;

	private String quantity;

	private String watches;

	public ServiceFee() {
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getApplyFromDate() {
		return this.applyFromDate;
	}

	public void setApplyFromDate(Timestamp applyFromDate) {
		this.applyFromDate = applyFromDate;
	}

	public Timestamp getApplyToDate() {
		return this.applyToDate;
	}

	public void setApplyToDate(Timestamp applyToDate) {
		this.applyToDate = applyToDate;
	}

	public String getChargeType() {
		return this.chargeType;
	}

	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getFeatureId() {
		return this.featureId;
	}

	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	public String getFeeGroup() {
		return this.feeGroup;
	}

	public void setFeeGroup(String feeGroup) {
		this.feeGroup = feeGroup;
	}

	public Boolean getIsManual() {
		return this.isManual;
	}

	public void setIsManual(Boolean isManual) {
		this.isManual = isManual;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getWatches() {
		return this.watches;
	}

	public void setWatches(String watches) {
		this.watches = watches;
	}

}