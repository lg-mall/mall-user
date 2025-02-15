package com.practice.mall.user.entity;

import java.util.Date;

public class Merchant {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant.id
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant.merchant_name
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    private String merchantName;

    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant.phone_num
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    private String phoneNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant.create_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column merchant.update_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant.id
     *
     * @return the value of merchant.id
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant.id
     *
     * @param id the value for merchant.id
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant.merchant_name
     *
     * @return the value of merchant.merchant_name
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant.merchant_name
     *
     * @param merchantName the value for merchant.merchant_name
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName == null ? null : merchantName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant.phone_num
     *
     * @return the value of merchant.phone_num
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public String getPhoneNum() {
        return phoneNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant.phone_num
     *
     * @param phoneNum the value for merchant.phone_num
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum == null ? null : phoneNum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant.create_date
     *
     * @return the value of merchant.create_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant.create_date
     *
     * @param createDate the value for merchant.create_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column merchant.update_date
     *
     * @return the value of merchant.update_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column merchant.update_date
     *
     * @param updateDate the value for merchant.update_date
     *
     * @mbg.generated Sat Oct 05 21:00:36 CST 2019
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}