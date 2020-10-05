

import java.io.Serial;
import java.io.Serializable;

public class ButLong implements Serializable {
	private static final long serialVersionUID = 1234568767l;
	private boolean hetMucChua;

	public ButLong(boolean hetMucChua) {
		super();
		this.hetMucChua = hetMucChua;
	}

	public boolean isHetMucChua() {
		return hetMucChua;
	}

	public void setHetMucChua(boolean hetMucChua) {
		this.hetMucChua = hetMucChua;
	}

}
