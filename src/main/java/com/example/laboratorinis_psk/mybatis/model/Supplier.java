package com.example.laboratorinis_psk.mybatis.model;

public class Supplier {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUPPLIER.ID
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUPPLIER.COUNTRY
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    private String country;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUPPLIER.NAME
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.SUPPLIER.COFFEETYPE
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    private String coffeetype;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUPPLIER.ID
     *
     * @return the value of PUBLIC.SUPPLIER.ID
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUPPLIER.ID
     *
     * @param id the value for PUBLIC.SUPPLIER.ID
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUPPLIER.COUNTRY
     *
     * @return the value of PUBLIC.SUPPLIER.COUNTRY
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUPPLIER.COUNTRY
     *
     * @param country the value for PUBLIC.SUPPLIER.COUNTRY
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUPPLIER.NAME
     *
     * @return the value of PUBLIC.SUPPLIER.NAME
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUPPLIER.NAME
     *
     * @param name the value for PUBLIC.SUPPLIER.NAME
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.SUPPLIER.COFFEETYPE
     *
     * @return the value of PUBLIC.SUPPLIER.COFFEETYPE
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public String getCoffeetype() {
        return coffeetype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.SUPPLIER.COFFEETYPE
     *
     * @param coffeetype the value for PUBLIC.SUPPLIER.COFFEETYPE
     *
     * @mbg.generated Mon May 08 22:09:52 EEST 2023
     */
    public void setCoffeetype(String coffeetype) {
        this.coffeetype = coffeetype;
    }
}