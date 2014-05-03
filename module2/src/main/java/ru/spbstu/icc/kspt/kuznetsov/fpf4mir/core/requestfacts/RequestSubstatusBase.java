package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestSubstatusBase implements RequestSubstatus {
	private RequestStatus mainStatus;

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatus#getMainStatus()
	 */
	@Override
	public RequestStatus getMainStatus() {
		return mainStatus;
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatus#setMainStatus(ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus)
	 */
	@Override
	public void setMainStatus(RequestStatus mainStatus) {
		this.mainStatus = mainStatus;
	}
	
}
