package com.vailsys.freeclimb.api.queue;



/**
 * The class represents the optional fields which can be passsed in when
 * updating a Queue.
 */
public class QueueUpdateOptions {
    /**
     * The alias of the queue.
     */
    private String alias;
    /**
     * The maximum number of calls allowed in the queue at one time.
     */
    private Integer maxSize;

    /**
     * Retrieve the alias value.
     *
     * @return The alias value of the object.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias field.
     *
     * @param alias The value to which to set alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the maxSize value.
     *
     * @return The maxSize value of the object.
     */
    public Integer getMaxSize() {
        return maxSize;
    }

    /**
     * Sets the maxSize field.
     *
     * @param maxSize The value to which to set maxSize.
     */
    public void setMaxSize(Integer maxSize) {
        this.maxSize = maxSize;
    }
}
