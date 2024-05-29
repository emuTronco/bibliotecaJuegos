package es.altia.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "auditoria")
public class Auditoria implements Serializable {

	private static final long serialVersionUID = -4573209559339860415L;

	public enum operationType {
		CREATE, UPDATE, DELETE
	};
	
	public enum userTypeInfo {
		ADMIN, USER, UPDATE_USER, DELETE_USER
	};
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private operationType operation_type;
	
	@NotNull
	private Long IDuser;
	
	@NotNull
	@NotBlank
	private String userName;

	@NotNull
	private userTypeInfo userTypeInfo;
	
	@NotNull
	private Date operationTime;

	private String operationDetails;

	
	

	public Auditoria(@NotNull operationType operation_type, @NotNull @NotBlank Long iDuser,
			@NotNull @NotBlank String userName, es.altia.app.entity.Auditoria.@NotNull userTypeInfo userTypeInfo,
			@NotNull @NotBlank @NotNull Date operationTime, String operationDetails) {
		super();
		this.operation_type = operation_type;
		IDuser = iDuser;
		this.userName = userName;
		this.userTypeInfo = userTypeInfo;
		this.operationTime = operationTime;
		this.operationDetails = operationDetails;
	}

	public Auditoria() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public operationType getOperationType() {
		return operation_type;
	}

	public void setOperationType(operationType operation) {
		this.operation_type = operation;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOperationDetails() {
		return operationDetails;
	}

	public void setOperationDetails(String operationDetails) {
		this.operationDetails = operationDetails;
	}

	public operationType getOperation_type() {
		return operation_type;
	}

	public void setOperation_type(operationType operation_type) {
		this.operation_type = operation_type;
	}

	public userTypeInfo getUserTypeInfo() {
		return userTypeInfo;
	}

	public void setUserTypeInfo(userTypeInfo userTypeInfo) {
		this.userTypeInfo = userTypeInfo;
	}

	public Long getIDuser() {
		return IDuser;
	}

	public void setIDuser(Long iDuser) {
		IDuser = iDuser;
	}

	public @NotNull Date getOperationTime() {
		return operationTime;
	}

	public void setOperationTime(@NotNull Date operationTime) {
		this.operationTime = operationTime;
	}

	
}
