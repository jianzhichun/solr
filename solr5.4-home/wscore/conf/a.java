package irs.jjserver.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;
import org.joda.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "Ticket")
public class Ticket {
	
	private String id;

	private Trade trade;

	private Trader requestor;

	private Trader responser;

	private LocalDateTime createDateTime;

	private String firmAccount;
	
	private String CounterParty;
	//detail
	private SwapLeg firstLeg;
	
	private SwapLeg secondLeg;

	private Status status;

	
	@Id
	@Column(name = "ticketId")
	@GeneratedValue(strategy = GenerationType.TABLE)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = Trade.class)
	@Cascade(value=CascadeType.REFRESH)
	@JoinColumn(name="tradeId")
	public Trade getTrade() {
		return trade;
	}

	public void setTrade(Trade trade) {
		this.trade = trade;
	}
	
	@NotNull
	@OneToOne(targetEntity=Trader.class)
	@Cascade({ CascadeType.REFRESH })
	@JoinColumn(name="requestorId")
	public Trader getRequestor() {
		return requestor;
	}

	public void setRequestor(Trader requestor) {
		this.requestor = requestor;
	}

	@OneToOne(targetEntity=Trader.class)
	@Cascade({ CascadeType.REFRESH })
	@JoinColumn(name="responserId")
	public Trader getResponser() {
		return responser;
	}

	public void setResponser(Trader responser) {
		this.responser = responser;
	}

	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@Type(type = "org.jadira.usertype.dateandtime.joda.PersistentLocalDate")
	public LocalDateTime getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(LocalDateTime createDateTime) {
		this.createDateTime = createDateTime;
	}

	public SwapLeg getFirstLeg() {
		return firstLeg;
	}

	public void setFirstLeg(SwapLeg firstLeg) {
		this.firstLeg = firstLeg;
	}

	public SwapLeg getSecondLeg() {
		return secondLeg;
	}

	public void setSecondLeg(SwapLeg secondLeg) {
		this.secondLeg = secondLeg;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name="firmAccount")
	public String getFirmAccount() {
		return firmAccount;
	}

	public void setFirmAccount(String firmAccount) {
		this.firmAccount = firmAccount;
	}

	@Column(name="counterParty")
	public String getCounterParty() {
		return CounterParty;
	}

	public void setCounterParty(String counterParty) {
		CounterParty = counterParty;
	}


	
	
	
}
