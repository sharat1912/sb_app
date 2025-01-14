package miniproject1.dto;

public class DashboardDto {
	
	private Long totalEnqs;
	
	private Long openEnqs;
	
	private Long enrolleEnqs;
	
	private Long lostEnqs;

	public Long getTotalEnqs() {
		return totalEnqs;
	}

	public void setTotalEnqs(Long totalEnqs) {
		this.totalEnqs = totalEnqs;
	}

	public Long getOpenEnqs() {
		return openEnqs;
	}

	public void setOpenEnqs(Long openEnqs) {
		this.openEnqs = openEnqs;
	}

	public Long getEnrolleEnqs() {
		return enrolleEnqs;
	}

	public void setEnrolleEnqs(Long enrolleEnqs) {
		this.enrolleEnqs = enrolleEnqs;
	}

	public Long getLostEnqs() {
		return lostEnqs;
	}

	public void setLostEnqs(Long lostEnqs) {
		this.lostEnqs = lostEnqs;
	}

}
