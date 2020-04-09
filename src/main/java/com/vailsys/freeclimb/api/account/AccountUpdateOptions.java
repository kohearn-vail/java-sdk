package com.vailsys.freeclimb.api.account;



/**
 * This class represents the optional fields which can be passed in when
 * updating an Account.
 *
 * @see com.vailsys.freeclimb.api.account.AccountRequester#update(String,
 *      AccountUpdateOptions)
 */
public class AccountUpdateOptions {

    /**
     * The alias of the account.
     */
    private String alias;
    /**
     * The label of the account.
     */
    private String label;

    /**
     * Retrieve the alias value.
     *
     * @return The alias value of the object.
     */
    public String getAlias() {
        return alias;
    }

    /**
     * Sets the alias value.
     *
     * @param alias The value to which to set alias.
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * Retrieve the label value.
     *
     * @return The label value of the object.
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the label value.
     *
     * @param label The value to which to set label.
     */
    public void setLabel(String label) {
        this.label = label;
    }
}
