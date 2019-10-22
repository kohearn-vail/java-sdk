package com.vailsys.freeclimb.api;

import java.util.Date;

/**
 * FreeClimbCommon is the base class from which all classes that are built to
 * represent objects returned from the FreeClimb API are built upon. A user of
 * the SDK should never directly interact with a FreeClimbCommon object.
 */
public class FreeClimbCommon {
	private String uri;
	private Date dateCreated;
	private Date dateUpdated;
	private Integer revision;

	protected FreeClimbCommon() {
	}

	/**
	 * @return The URI where this resource can be found
	 */
	public String getUri() {
		return this.uri;
	}

	/**
	 * @return The time and date when this resource was created.
	 */
	public Date getDateCreated() {
		return this.dateCreated;
	}

	/**
	 * @return The time and date when this resource was last updated
	 */
	public Date getDateUpdated() {
		return this.dateUpdated;
	}

	/**
	 * @return The number of revisions this object has undergone.
	 */
	public int getRevision() {
		return this.revision;
	}

	public boolean equals(FreeClimbCommon that) {
		if (this.uri == that.uri
				|| (this.uri != null && that.uri != null && this.uri.equals(that.uri))
						&& this.dateCreated == that.dateCreated
				|| (this.dateCreated != null && that.dateCreated != null && this.dateCreated.equals(that.dateCreated))
						&& this.dateUpdated == that.dateUpdated
				|| (this.dateUpdated != null && that.dateUpdated != null && this.dateUpdated.equals(that.dateUpdated))
						&& this.revision == that.revision
				|| (this.revision != null && that.revision != null && this.revision.equals(that.revision))) {
			return true;
		}
		return false;
	}
}
