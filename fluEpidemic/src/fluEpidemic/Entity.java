package fluEpidemic;

public abstract class Entity {
	protected Disease disease;
	protected int countDisease;
	protected boolean dead;

	public Entity(Species species) {
		this.disease = null;
		this.countDisease = 0;
		this.dead = false;
	}

	public abstract String getName();

	public abstract Boolean canMove();

	public Entity(Disease disease, int countDisease) {
		this.disease = disease;
		this.countDisease = countDisease;
	}

	public void clear() {
		this.disease = null;
		this.countDisease = 0;
	}

	public int getCountDisease() {
		return this.countDisease;
	}

	public void setCountDisease(int mCount) {
		this.countDisease = mCount;
	}

	public Disease getDisease() {
		return this.disease;
	}

	public void infect(Disease d, int countDisease) {
		this.disease = d;
		this.countDisease = countDisease;
	}

	public boolean isSick() {
		return this.disease != null;
	}

	public boolean isContagious() {
		return true;
	}

	public boolean isDead() {
		return this.dead;
	}

	public void update() {
		if (!decrease()) {
			this.kill();
		}
	}

	protected void kill() {
		if (!this.dead) {
			this.dead = true;
		}
	}

	protected boolean decrease() {
		if (this.countDisease > 1) {
			this.countDisease--;
			return true;
		}
		return false;
	}

	public String toString() {
		String res = "";
		if (this.isDead())
			res = ColorAnsi.RED.getCodeColor();
		else if (this.isSick())
			res = ColorAnsi.GREEN.getCodeColor();
		res += this.getName();
		res += ColorAnsi.RESET.getCodeColor();
		return res;
	}
}
